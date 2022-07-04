import { BwicItem } from "../Model/Bwic.model"
import { request } from "./request"

export const addBwicApi = (params: BwicItem) => { return request<BwicItem>("post", "/api/v1/bwic/create", params); }