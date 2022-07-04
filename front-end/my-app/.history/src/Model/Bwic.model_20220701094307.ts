export interface BwicItem {
    cusip: string;
    issuer: string;
    dueDate: any;
    owner: string;
    clientId?:string;
    size: number;
    price: number;
  }

  export interface BwicItems {
    id: number;
    cusip: string;
    size: number;
    startingprice: number;
    duedate: any;
  }

  export interface BwicId{
    id: number;
  }

  export enum StateStatus{
    PENDING,
    READY,
    ERROR,
  }

  export interface BwicState{
    status:StateStatus;
    AddedBwic:any;
  }