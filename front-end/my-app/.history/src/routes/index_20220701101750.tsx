import { Navigate, Route, RouteObject, Routes, useRoutes } from "react-router";
import LayoutPage from "../pages/layout/Layout";
import LoginPage from "../pages/login/login";
import BwicPage from "../pages/trader-portal/Bwic";
//import CreateBiwc_Original from "../pages/trader-portal/CreateBwic";
import CreateBwic_Antd from "../pages/trader-portal/CreateBwic_Antd";
import PrivateRouter from "./privateRouter";

const RenderRouter: React.FC = () => {
  const routeList: RouteObject[] = [
    {
      path: "/",
      element: <LoginPage />,
    },
    {
      path: "/trader",
      element: <PrivateRouter element={<LayoutPage/>}/>,
      children: [
        {
          path: "",
          index: true,
          element: <Navigate to="createBwic" />,
        },
        {
          path: "createBwic",
          element: <PrivateRouter element={<CreateBwic_Antd />}/>,
        },
        {
          path: "addedBwic",
          element: <PrivateRouter element={<BwicPage />}/>,
        },
        {
          path:"updateBwic",
          element:<p
        }
      ],
    },
  ];

  return useRoutes(routeList);
};

export default RenderRouter;
