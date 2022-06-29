import { Layout, Menu } from "antd";
import { ItemType } from "antd/lib/menu/hooks/useItems";
import { Outlet, useNavigate } from "react-router";
const { Header, Content, Sider } = Layout;

const LayoutPage: React.FC = () => {
  const navigate = useNavigate();
  const menuItems: ItemType[] = [
    {
      label: "Add BWIC",
      key: "createBwic",
    },
    {
      label: "Added Bwic",
      key: "addedBwic",
    },
  ];

  const selectMenu = (event: any) => {
    navigate(event.key);
  };

  return (
    <Layout>
      <Header style={{ backgroundColor: "white" }}>eBidding Platform</Header>
      <Layout>
        <Sider>
          <Menu mode="inline" onSelect={selectMenu} items={menuItems}></Menu>
        </Sider>
        <Content>
          <Outlet />
        </Content>
      </Layout>
    </Layout>
  );
};

export default LayoutPage;
