import { EyeOutlined } from '@ant-design/icons';
import { Layout, Menu } from 'antd';
import React from 'react';
import { Link, Outlet, useNavigate } from 'react-router-dom';
const { Header, Content, Footer, Sider } = Layout;

const ClientBwicLayout: React.FC = () => {
  const navigate = useNavigate();
  const topLayer = [{ key: 'bwic', label: <Link to="./bwic">BWIC</Link> },
  { key: 'bid', label: <Link to="./bid/view">BID</Link> }]
  const sideLayer_bwic = [EyeOutlined].map((icon, index) => {
    return {
      key: "view",
      icon: React.createElement(icon),
      label: "查看所有的BWIC",
    };
  });

  return (
    <Layout>
      <Header className="header">
        <div className="logo" />
        <Menu theme="dark" mode="horizontal" defaultSelectedKeys={['bwic']} items={topLayer} />

      </Header>
      <Content
        style={{
          padding: '0 50px',
        }}
      >
        <Layout
          className="site-layout-background"
          style={{
            padding: '50px 0',
          }}
        >
          <Sider className="site-layout-background" width={200}>
            <Menu
              mode="inline"
              defaultSelectedKeys={['view']}
              style={{
                height: '100%',
              }}
              items={sideLayer_bwic}
            />
          </Sider>
          <Content
            style={{
              padding: '0 24px',
              minHeight: 280,
            }}
          >
            <Outlet />
          </Content>
        </Layout>
      </Content>
      <Footer
        style={{
          textAlign: 'center',
        }}
      >
        E-Bidding System ©2022 Created by Group 5
      </Footer>
    </Layout>
  );
};

export default ClientBwicLayout;
