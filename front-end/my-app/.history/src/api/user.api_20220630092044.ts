import { request } from "./request";
import { LoginParams, UserModel } from "../Model/User.model";

export const loginApi = (params: LoginParams) => {
  return request<UserModel>("post", "/api/v1/account/login", params);
};
