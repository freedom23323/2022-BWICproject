import { List } from "antd";
import { useEffect } from "react";
import { BwicItem } from "../../models/Bwic.model";
import { addBwicAsync } from "../../stores/bwicSlice";
import { useAppDispatch, useAppSelector } from "../../stores/hook";

const BwicPage: React.FC = () => {
  const bwic = useAppSelector((state) => state.bwic);
  const dispatch = useAppDispatch();
  console.log("Bwic Status", bwic.status);

  useEffect(() => {
    dispatch(
      addBwicAsync({
        cusip: "453012O20",
        issuer: "issuer1",
        // dueDate: "2022-06-27",
        owner: "owner",
        clientId: "owner",
        size: 1000,
        price: 100,
      } as BwicItem)
    );
  }, []);

  return (
    <div>
      <List<string>
        size="small"
        grid={{ gutter: 19, column: 1 }}
        dataSource={bwic?.AddedBwic}
        renderItem={(item) => <List.Item>{item}</List.Item>}
      />
    </div>
  );
};

export default BwicPage;
