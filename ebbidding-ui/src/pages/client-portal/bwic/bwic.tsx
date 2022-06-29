import { Button, Table } from 'antd';
import type { ColumnsType } from 'antd/lib/table';
import React, { useEffect, useState } from 'react';
import { getBwicApi } from '../../../api/bwic.api';
import { BwicItems } from '../../../models/Bwic.model';


const ClientBwicPage: React.FC = () => {
  const [Items, setItems] = useState<BwicItems[]>()
  
  useEffect(() => {
    getData();
  }, [])

  const columns: ColumnsType<BwicItems> = [
    {
      title: 'ID',
      dataIndex: 'id',
      key: 'id',
    },
    {
      title: 'CUSIP',
      dataIndex: 'cusip',
      key: 'cusip',
    },
    {
      title: 'SIZE',
      dataIndex: 'size',
      key: 'size',
    },
    {
      title: '起始价格',
      dataIndex: 'startingprice',
      key: 'startingprice',
    },
    {
      title: '到期时间',
      dataIndex: 'duedate',
      key: 'duedate',
    },
  ];

  async function getData() {
    const { data } = await Promise.resolve(getBwicApi());
    setItems(data);
  };

  return (
    <div>
      <div style={{ marginBottom: 16 }}>
        <Button type="primary" onClick={getData}>
          Reload
        </Button>
      </div>
      <Table columns={columns} dataSource={Items} rowKey={record => record.id} />
    </div>
  );
};

export default ClientBwicPage;