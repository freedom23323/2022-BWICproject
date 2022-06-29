import { BwicItem, BwicItems } from "../models/Bwic.model";
import { request } from "./request";

export const addBwicApi = (params: BwicItem) => {
  return request<BwicItem>("post", "/api/v1/bwic/create", params);
};

export const getBwicApi = () => {
  return request<BwicItems[]>("get", "http://localhost:8080/api/v1/bwic/value/ActiveBWIC");
};