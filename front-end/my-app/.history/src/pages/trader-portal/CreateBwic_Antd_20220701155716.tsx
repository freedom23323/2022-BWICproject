/* eslint-disable react/jsx-no-undef */
import { Button,DatePicker, Form, Input, message } from "antd";
import moment from "moment";
//import { useState } from "react";
import { addBwicApi } from "../../api/bwic.api";
import { BwicItem,BwicItems } from "../../Model/Bwic.model";
import { addBwic } from "../../stores/bwicSlice";
import { useAppDispatch } from "../../stores/hook";
import ClockCircleOutlined from '@ant-design/icons/ClockCircleOutlined';
import"./CreateBwic.scss"

const CreateBwic_Antd: React.FC = () => {

    // const initateBwic = {
    //     cusip: "cusip1",
    //     issuer: "issuer1",
    //     //dueDate: "2022-06-27",
    //     owner: "owner",
    //     clientId: "owner",
    //     size: 1000,
    //     price: 100,
    // } as BwicItem;
    const initateBwic={
        //id: number;
        //id:1000,
        cusip: "cusip1",
        startingprice:100,
        duedate: "2022-06-27 10:10:10",
        size: 1000,
    }as BwicItems;
    const dispatch=useAppDispatch();
    const onFinish = async (form: BwicItems) => {
        //console.log(form);
        //form.dueDate= new Date(form.dueDate || "");
        //form.dueDate.format("YYYY-MM-DD HH:mm:ss");
        //moment(form.dueDate).format("YYYY-MM-DD HH:mm:ss");
        //form.duedate.fotmat.parse();
        form.duedate=new Date(form.duedate).getTime();
        const{success,data}=await addBwicApi(form);
        console.log(form);
        //await addBwicApi(initateBwic);
        if (success && form) {
            //const issuer=form.issuer;
            //dispatch(addBwic(issuer));
            // data.dueDate.toDate();
            //dispatch(addBwic(form));
            message.success("New BWIC success.");
        }
        else {
            message.error("New BWIC Failed.");
        }
    }

    //const [bwicObj, setBwicObj] = useState(initateBwic);

    // const onFinish = (form: BwicItem) => {
    //     // Call API, 
    //    //console.log(JSON.stringify(form));
    //    alert((JSON.stringify(form)));
    // }

    return (
        <div style={{ display: "flex", justifyContent: "center" }}>
            <div className="aaa" style={{ width: "400px" }}>
                <h1>Create BWIC</h1>
                <Form<BwicItems> labelCol={{ span: 8 }} wrapperCol={{ span: 16 }} onFinish={onFinish} initialValues={initateBwic}>
                    <Form.Item label="Cusip" name="cusip" rules={[{ required: true, message: 'Please input CUSIP!', }]} >
                        <Input />
                    </Form.Item>
                    {/* <Form.Item label="Issuer" name="issuer" >
                        <Input />
                    </Form.Item> */}
                    {<Form.Item label="Due Date" name="duedate" >
                        <Input prefix={<ClockCircleOutlined />} placeholder="YYYY-MM-DD HH:mm:ss"/> 
                    {/* <DatePicker
              showTime
              format="YYYY-MM-DD HH:mm:ss"
              style={{ width: "100%" }}
            />  */}

                    </Form.Item> }
                    {/* <Form.Item label="Bond Owner" name="owner" >
                        <Input />
                    </Form.Item> */}
                    <Form.Item label="Size" name="size" >
                        <Input />
                    </Form.Item>
                    <Form.Item label="StartingPrice" name="startingprice" >
                        <Input />
                    </Form.Item>
                    {/* <Form.Item label="ClientId" name="clientId" >
                        <Input />
                    </Form.Item> */}
                    <Form.Item wrapperCol={{ offset: 8, span: 16 }}>
                        <Button htmlType="submit">Submit</Button>
                    </Form.Item>
                </Form>
            </div>
        </div>
    );
}

export default CreateBwic_Antd;
