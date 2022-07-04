import axios, { AxiosRequestConfig } from "axios";

const axiosInstance = axios.create(
    { timeout: 60000 }
);

axiosInstance.interceptors.request.use(config => {
    // Add auth token
    return config;
}, error => {
    // console,
    return Promise.reject(error);
});

axiosInstance.interceptors.response.use(response => {
    // special logic, logging
    return {
        success: true,
        status: "success",
        message: "error",
        data: response.data
    } as Response<string>;
}, error => {
    // LOGIN
    return {
        success: true,
        status: "success",
        message: error,
        data: ""
    } as Response<string>;
});

export interface Response<T> {
    success: boolean;
    status: string;
    message: string;
    data: T
}

export const requestBody = <T>(method: string,
    url: string,
    data?: any,
    config?: AxiosRequestConfig): Promise<T> => {
    if (method === "get") {
        return axiosInstance.get(url, {
            params: data,
            ...config
        });
    }
    else {
        return axiosInstance.post(url, data, config);
    }
    // else{
    //     return axiosInstance
    // }
}