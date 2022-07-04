import { configureStore } from "@reduxjs/toolkit";
import bwicReducers from "./bwicSlice";

const store = configureStore({
  reducer: {
    bwic: bwicReducers,
  },
});

export default store;

export type RootState = ReturnType<typeof store.getState>;

export type AppDispatch = typeof store.dispatch;