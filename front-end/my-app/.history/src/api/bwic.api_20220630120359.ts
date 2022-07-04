import { BwicItems } from "../Model/Bwic.model"
import { request } from "./request"

export const addBwicApi = (params: BwicItems) => { return request<BwicItems>("post", "http://localhost:8080/api/v1/bwic/value=/BWICAdd", null, {params:params}); }