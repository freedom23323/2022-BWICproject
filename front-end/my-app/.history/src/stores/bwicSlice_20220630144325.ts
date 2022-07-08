import { BwicState, StateStatus ,BwicItem, BwicItems} from "../Model/Bwic.model";
import {createSlice,createAsyncThunk} from "@reduxjs/toolkit";
import { addBwicApi } from "../api/bwic.api";


const initialState={
    status:StateStatus.PENDING,
    AddedBwic:[],
}as BwicState;

const BwicSlice=createSlice({
    name:"bwic",
    initialState:initialState,
    reducers:{
        addBwic: (state, action) => {
            const { payload } = action;
            state.AddedBwic.push(payload);
            console.log("Add BWIC", payload);
          },
    },
    extraReducers: (builder) => {
        builder.addCase(addBwicAsync1.pending, (state, action) => {
          console.log("pending", action);
          Object.assign(state, { status: StateStatus.PENDING });
        });
        builder.addCase(addBwicAsync1.fulfilled, (state, action) => {
          console.log("fullfilled", action);
          Object.assign(state, { status: StateStatus.READY });
        });
        builder.addCase(addBwicAsync1.rejected, (state, action) => {
          console.log("rejected", action);
          Object.assign(state, { status: StateStatus.ERROR });
        });
      },
}
)

// export const addBwicAsync = createAsyncThunk(
//     "addBwicAsync",
//     (payload: BwicItem) => {
//       return addBwicApi(payload);
//     }
//   );
  export const addBwicAsync1 = createAsyncThunk(
    "addBwicAsync",
    (payload1: BwicItems) => {
      return addBwicApi(payload1);
    }
  );

  
export const { addBwic } = BwicSlice.actions;

export default BwicSlice.reducer;