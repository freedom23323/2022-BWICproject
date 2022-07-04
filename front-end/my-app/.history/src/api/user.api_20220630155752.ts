import { requestBody } from "./request";
import { LoginParams, UserModel } from "../Model/User.model";

export const loginApi = (params: LoginParams) => {
  return requestBody<UserModel>("post", "/api/v1/account/login", params);
};
