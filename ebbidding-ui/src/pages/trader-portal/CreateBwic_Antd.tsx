import { Button, DatePicker, Form, Input, List, message } from "antd";
import { addBwicApi } from "../../api/bwic.api";
import { BwicItem } from "../../models/Bwic.model";
import { addBwic } from "../../stores/bwicSlice";
import { useAppDispatch } from "../../stores/hook";

const CreateBwic_Antd: React.FC = () => {
  const initateBwic = {
    cusip: "453012O20",
    issuer: "issuer1",
    // dueDate: "2022-06-27",
    owner: "owner",
    clientId: "owner",
    size: 1000,
    price: 100,
  } as BwicItem;

  const dispatch = useAppDispatch();

  const onFinish = async (form: BwicItem) => {
    const { success, data } = await addBwicApi(form);
    if (success && data) {
      const cusip = form.cusip;
      dispatch(addBwic(cusip));
      message.success("New BWIC success.");
    } else {
      message.error("New BWIC Failed.");
    }
  };

  return (
    <div style={{ display: "flex", justifyContent: "center" }}>
      <div style={{ width: "400px" }}>
        <h1>Create BWIC</h1>
        <Form<BwicItem>
          labelCol={{ span: 8 }}
          wrapperCol={{ span: 16 }}
          onFinish={onFinish}
          initialValues={initateBwic}
        >
          <Form.Item
            label="Cusip"
            name="cusip"
            rules={[{ required: true, message: "Please input CUSIP!" }]}
          >
            <Input />
          </Form.Item>
          <Form.Item label="Issuer" name="issuer">
            <Input />
          </Form.Item>
          <Form.Item label="Due Date" name="dueDate">
            <DatePicker
              showTime
              format="YYYY-MM-DD HH:mm:ss"
              style={{ width: "100%" }}
            />
          </Form.Item>
          <Form.Item label="Bond Owner" name="clientId">
            <Input />
          </Form.Item>
          <Form.Item label="Size" name="size">
            <Input />
          </Form.Item>
          <Form.Item label="Recommand Price" name="price">
            <Input />
          </Form.Item>
          <Form.Item wrapperCol={{ offset: 8, span: 16 }}>
            <Button htmlType="submit">Submit</Button>
          </Form.Item>
        </Form>
      </div>
    </div>
  );
};

export default CreateBwic_Antd;
