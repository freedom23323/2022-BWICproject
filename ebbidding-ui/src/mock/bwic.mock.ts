import Mock from "mockjs";

Mock.setup({
  timeout: 300,
});

Mock.mock("/api/v1/bwic/create", "post", (config: any) => {
  const body = config.body;
  return {
    success: true,
    status: "success",
    message: null,
    data: body,
  };
});
