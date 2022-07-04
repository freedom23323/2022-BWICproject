import { BwicItems,BwicId} from "../Model/Bwic.model"
import { requestBody } from "./request"

export const addBwicApi = (params: BwicItems) => { return requestBody<BwicItems>("post", "http://localhost:8080/api/v1/bwic/value=/BWICAdd",params) }

export const getBwicApi =()=>{ return requestBody<BwicItems[]>("get", "http://localhost:8080/api/v1/bwic/value=/AllBWIC", null); }

export const deleteBwicApi=(params:BwicId)=>{return requestBody<BwicId>("post", "http://localhost:8080/api/v1/bwic/deleteBWIC",params);}

export const addBwicApi = (params: BwicItems) => { return requestBody<BwicItems>("post", "http://localhost:8080/api/v1/bwic/value=/u",params) }
