import axios, { AxiosRequestConfig } from "axios";

const axiosInstance = axios.create({ timeout: 60000 });

axiosInstance.interceptors.request.use(
  (config) => {
    // Add auth token
    const token = localStorage.getItem("t");
    return { ...config, ...{ headers: { Authorization: `Bearer ${token}` } } };
  },
  (error) => {
    // console,
    return Promise.reject(error);
  }
);

axiosInstance.interceptors.response.use(
  (response) => {
    // special logic, logging
    return{
      success: true,
      status: "success",
      message: response.statusText,
      data: response.data,
    } as Response<string>;
  },
  (error) => {
    // LOGIN
    return {
      success: false,
      status: "failure",
      message: error,
      data: "",
    } as Response<string>;
  }
);

export interface Response<T> {
  success: boolean;
  status: string;
  message: string;
  data: T;
}

export const request = <T>(
  method: string,
  url: string,
  data?: any,
  config?: AxiosRequestConfig
): Promise<Response<T>> => {
  if (method === "get") {
    return axiosInstance.get(url, {
      params: data,
      ...config,
    });
  } else {
    return axiosInstance.post(url, data, config);
  }
  // else{
  //     return axiosInstance
  // }
};
