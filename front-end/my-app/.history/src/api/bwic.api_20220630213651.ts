import { BwicItems } from "../Model/Bwic.model"
import { requestBody } from "./request"

export const addBwicApi = (params: BwicItems) => { return requestBody<BwicItems>("post", "http://localhost:8080/api/v1/bwic/value=/BWICAdd",params) }

export const getBwicApi =()=>{ return requestBody<BwicItems[]>("get", "http://localhost:8080/api/v1/bwic/value=/AllBWIC", null); }

export const deleteBwicApi=(id:number)=>{return requestBody<number>("delete", "http://localhost:8080/api/v1/bwic/deleteBWIC/{"+id.toString()+"}", id);}
