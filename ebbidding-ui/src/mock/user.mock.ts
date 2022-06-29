import Mock from "mockjs";
import { UserModel } from "../models/User.model";

Mock.setup({
  timeout: 300,
});

Mock.mock("/api/v1/account/login", "post", (config: any) => {
  const body = config.body;
  return {
    success: true,
    status: "success",
    message: null,
    data: {
      username: body.username,
      role: "trader",
      token: "token1",
    } as UserModel,
  };
});
