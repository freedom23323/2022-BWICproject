/* eslint-disable react/jsx-no-undef */
import { Button,DatePicker, Form, Input, message } from "antd";
import moment from "moment";
//import { useState } from "react";
import { addBwicApi } from "../../api/bwic.api";
import { BwicItem,BwicItems } from "../../Model/Bwic.model";
import { addBwic } from "../../stores/bwicSlice";
import { useAppDispatch } from "../../stores/hook";
import ClockCircleOutlined from '@ant-design/icons/ClockCircleOutlined';

const CreateBwic_Antd: React.FC = () => {
    const initateBwic={
        //id: number;
        id:1,
        cusip: "cusip1",
        startingprice:100,
        duedate: "2022-06-27 10:10:10",
        size: 1000,
    }as BwicItems;
    const dispatch=useAppDispatch();
    const onFinish = async (form: BwicItems) => {
        form.duedate=new Date(form.duedate).getTime();
        const{success,data}=await addBwicApi(form);
        console.log(form);
        //await addBwicApi(initateBwic);
        if (success && form) {
            message.success("New BWIC success.");
        }
        else {
            message.error("New BWIC Failed.");
        }
    }
    return (
        <div style={{ display: "flex", justifyContent: "center" }}>
            <div style={{ width: "400px" }}>
                <h1>Create BWIC</h1>
                <Form<BwicItems> labelCol={{ span: 8 }} wrapperCol={{ span: 16 }} onFinish={onFinish} initialValues={initateBwic}>
                <Form.Item label="BWICId" name="id" rules={[{ required: true, message: 'Please input BWICID!', }]} >
                        <Input />
                    </Form.Item>
                    <Form.Item label="Cusip" name="cusip" rules={[{ required: true, message: 'Please input CUSIP!', }]} >
                        <Input />
                    </Form.Item>
                    {<Form.Item label="Due Date" name="duedate" >
                        <Input prefix={<ClockCircleOutlined />} placeholder="YYYY-MM-DD HH:mm:ss"/> 
                    </Form.Item> }
                    <Form.Item label="Size" name="size" >
                        <Input />
                    </Form.Item>
                    <Form.Item label="StartingPrice" name="startingprice" >
                        <Input />
                    </Form.Item>
                    <Form.Item wrapperCol={{ offset: 8, span: 16 }}>
                        <Button htmlType="submit">Submit</Button>
                    </Form.Item>
                </Form>
            </div>
        </div>
    );
}

export default CreateBwic_Antd;
