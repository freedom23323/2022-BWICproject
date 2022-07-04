import {  Button,List ,Space,Table,Tag,Input, message, Form} from "antd";
import { useEffect } from "react";
import { BwicId, BwicItem,BwicItems } from "../../Model/Bwic.model";
import { useAppDispatch, useAppSelector } from "../../stores/hook";
import { addBwicAsync1 } from "../../stores/bwicSlice";
import type { ColumnsType, TableProps, ColumnType } from 'antd/lib/table';
import { SearchOutlined } from '@ant-design/icons';
import type { InputRef } from 'antd';
import type { FilterConfirmProps } from 'antd/lib/table/interface';
import React, { useRef, useState } from 'react';
import Highlighter from 'react-highlight-words';
import { addBwicApi, deleteBwicApi, getBwicApi } from "../../api/bwic.api";
import { timeStamp } from "console";


const {Column,ColumnGroup}=Table;
const {Search}=Input;
const onSearch=(value:string)=>console.log(value);
const columns: ColumnsType<BwicItems> = [
  {
    title:'ID',
    dataIndex:'id',
    width: '40%',
    sorter: (a, b) => a.id - b.id,
  },
  {
    title: 'Cusip',
    dataIndex: 'cusip',
    key:'cusip',
    filters: [
      {
        text: 'cuisp1',
        value: 'cuisp1',
      },
      {
        text: 'Category 1',
        value: 'Category 1',
      },
      {
        text: 'Category 2',
        value: 'Category 2',
      },
    ],
    filterMode: 'tree',
    filterSearch: true,
    onFilter: (value:any, record) => record.cusip.startsWith(value),
    width: '30%',
  },

  // {
  //   title: 'Issuer',
  //   dataIndex: 'issuer',
  //   filters: [
  //     {
  //       text: <span>issuer1</span>,
  //       value: 'issuer1',
  //     },
  //     {
  //       text: <span>New York</span>,
  //       value: 'New York',
  //     },
  //   ],
  //   onFilter: (value: any, record) => record.issuer.startsWith(value),
  //   filterSearch: true,
  //   width: '40%',
  // },
  {
    title:'dueDate',
    dataIndex:'duedate',
    width: '40%',
  },
  // {
  //   title:'Owner',
  //   dataIndex:'owner',
  //   width: '40%',
  // },
  // {
  //   title:'ClinetId',
  //   dataIndex:'clientId',
  //   width: '40%',
  // },
  {
    title: 'Size',
    dataIndex: 'size',
    sorter: (a, b) => a.size - b.size,
  },
  {
    title: 'StartingPrice',
    dataIndex: 'startingprice',
    sorter: (a, b) => a.startingprice - b.startingprice,
  },
];

const onChange: TableProps<BwicItems>['onChange'] = (pagination, filters, sorter, extra) => {
  console.log('params', pagination, filters, sorter, extra);
};
// const initateBwic1 = {
//   id:123,
//   cusip: "cusip1",
//   size:23,
//   startingprice:231,
//   duedate:"2022-11-11 10:10:10"
// } as BwicItems;

const BwicPage: React.FC = () => {  
  const bwic = useAppSelector((state) => state.bwic);
  //const data:bwic?.AddedBwic[];
  const dispatch = useAppDispatch();
  console.log("Bwic Status", bwic.status);

  // async function dda(){
  //   console.log("dddddddddddd");
  //   const {data}=await addBwicApi(initateBwic1);
  //   setddd(data.cusip);
  // }

  useEffect(() => {
    // dispatch(
    //   addBwicAsync1({
    //       //id: number;
    //       cusip: "cusip1",
    //       size: 1000,
    //       startingprice:100,
    //       duedate: "2022-06-27",
    //   }as BwicItems)
    // );
    
//dda();
  }, []);
  // const [ddd,setddd]=useState<string>("123");
  // return(<div>{ddd}</div>);
  function formatDate(time:any):string{
    let date = new Date(time);
    
    let YY = date.getFullYear();
    let MM = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
    let DD = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
    let hh = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
    let mm = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
    let ss = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();

	// 这里修改返回时间的格式
    return YY + "-" + MM + "-" + DD + " " + hh + ":" + mm + ":" + ss;
}
  const [ddd,setddd]=useState<BwicItems[]>();
  const onClick = async () => {
    const { success, data } = await getBwicApi();
    // console.log(1111);
    // console.log(data);
    for (let datai of data) {
       //datai.duedate=new Date(datai.duedate);
       datai.duedate=formatDate(datai.duedate);
    }
    setddd(data);
  }//bwic?.AddedBwic
  const start11={
    id:18,
  }as BwicId;
  const onFinish = async (form: BwicId) => {
    //const{success,data}=await deleteBwicApi(id);
    const{success,data}=await deleteBwicApi(form);
    //console.log(form);
     if (success && form) {
        message.success("Success to delete a BWIC!");
    }
    else {
        message.error("Failure!.");
    }
  }

  return(
    <div>  
      <Button onClick={onClick}>Load BWIC data</Button>
      <Form<BwicId> labelCol={{ span: 8 }} wrapperCol={{ span: 16 }} onFinish={onFinish} initialValues={start11} >
        <Form.Item label="Delete_id" name="id" >
          <Input />
        </Form.Item>
        <Form.Item wrapperCol={{ offset: 8, span: 16 }}>
          <Button htmlType="submit">Delete!</Button>
        </Form.Item>
      </Form>
      <div>23333</div>
      <Table columns={columns} dataSource={ddd} onChange={onChange} key="cuisp" />
      <Button title="刷新" onClick={onClick}/>
    </div>);
}

// const BwicPage: React.FC = () => {
//   const bwic = useAppSelector((state) => state.bwic);
//   //const data:bwic?.AddedBwic[];
//   const dispatch = useAppDispatch();
//   console.log("Bwic Status", bwic.status);

//   useEffect(() => {
//     dispatch(
//       addBwicAsync({
//         cusip: "453012O20",
//         issuer: "issuer1",
//         dueDate: new Date(),
//         owner: "owner",
//         clientId: "owner",
//         size: 1000,
//         price: 100,
//       } as BwicItem)
//     );
//   }, []);
//   return (
//     // <div>
//     //   <List<string>
//     //     size="small"
//     //     grid={{ gutter: 19, column: 1 }}
//     //     dataSource={bwic?.AddedBwic}
//     //     renderItem={(item) => <List.Item>{item}</List.Item>}
//     //   />

//     // </div>
//     <div>
//     <Search placeholder="input search text" onSearch={onSearch} enterButton/>
//     <Table dataSource={bwic?.AddedBwic}>
//       <Column title="Cuisp" dataIndex="cuisp" key='cusip'/>
//       <Column title="Issuer" dataIndex="issuer" key='issuer'/>
//       <Column title="dueDate" dataIndex="dueDate" key='dueDate'/>
//       <Column title="owner" dataIndex="owner" key='owner'/>
//       <Column title="ClientId" dataIndex="clientId" key='clientId'/>
//       <Column title="Size" dataIndex="size" key='size'/>
//       <Column title="Price" dataIndex="price" key='price'/>
//       {/* <Column title="Action" key="action" 
//       render={
//         ()=>(
//           <Space size="middle">
//             <a>Delete</a>
//           </Space>
//         )
//       }/> */}
//     </Table>
//     </div>
//   );
// };

export default BwicPage;