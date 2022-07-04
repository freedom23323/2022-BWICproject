// import { Button } from "antd";
import { Layout,Menu } from "antd";
import { ItemType } from "antd/lib/menu/hooks/useItems";
import { Outlet, useNavigate } from "react-router";
import"./Layout.scss";

const { Header, Content, Sider } = Layout;

const LayoutPage: React.FC = () => {
  const navigate = useNavigate();
  const menuItems:ItemType[]=[
    {
      label:"Add BWIC",
      key:"createBwic",
    },
    {
      label:"Added Bwic",
      key:"addedBwic",
    },
    {
      label:"Update BWIC",
      key:"updateBwic",
    }
  ]
  const selectMenu=(event:any)=>{
    navigate(event.key);
  }
  return(
    <Layout className="Layout-page">
    <Header className="Header" style={{ backgroundColor: "blue"}}>eBidding Platform/</Header>
    <Layout>
      <Sider>
        <Menu mode="inline" onSelect={selectMenu} items={menuItems}></Menu>
      </Sider>
      <Content>
        <Outlet />
      </Content>
    </Layout>
  </Layout>
  )
};

export default LayoutPage;

  // const switchEvent = (event: any) => {
  //   navigate("/trader/createBwic_1");
  // };

  // return (
  //   <div>
  //     <div>This is LayoutPage.</div>
  //     <Button type="primary" onClick={switchEvent}>
  //       Switch
  //     </Button>
  //     <Outlet />
  //   </div>
  // );