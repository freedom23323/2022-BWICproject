import { RouteProps } from "react-router";
import LoginPage from "../pages/login/login";

const PrivateRouter: React.FC<RouteProps> = (props: RouteProps) => {
  const element = props.element as React.ReactElement;
  const logged = localStorage.getItem("username");

  if (logged) {
    return element;
  } else {
    return <LoginPage />;
  }
};

export default PrivateRouter;