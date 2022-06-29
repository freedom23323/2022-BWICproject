import { Button, Form } from "antd";
import Input from "rc-input";
import { useNavigate } from "react-router";
import { loginApi } from "../../api/user.api";
import { LoginParams } from "../../models/User.model";
import "./login.scss";

const LoginPage: React.FC = () => {
  const navigate = useNavigate();

  const initialValues = {
    username: "test-trader",
    password: "123456",
  } as LoginParams;

  const login = async (params: any) => {
    const { success, data } = await loginApi(params);
    if (success) {
      localStorage.setItem("t", data.token);
      localStorage.setItem("username", data.username);
      navigate("/trader");
    }
  };

  return (
    <div className="login-page">
      <Form
        name="login"
        onFinish={login}
        labelCol={{ span: 8 }}
        wrapperCol={{ span: 16 }}
        initialValues={initialValues}
      >
        <h1>eBidding Platform</h1>
        <Form.Item
          name="username"
          label="User Name"
          rules={[{ required: true, message: "Please input username!" }]}
        >
          <Input />
        </Form.Item>
        <Form.Item
          name="password"
          label="Password"
          rules={[{ required: true, message: "Please input password!" }]}
        >
          <Input type="password" />
        </Form.Item>
        <Form.Item wrapperCol={{ offset: 8, span: 16 }}>
          <Button type="primary" htmlType="submit">
            Submit
          </Button>
        </Form.Item>
      </Form>
    </div>
  );
};

export default LoginPage;
