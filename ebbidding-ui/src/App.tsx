import React from "react";
import logo from "./logo.svg";
import "./App.css";
import { BrowserRouter } from "react-router-dom";
import RenderRouter from "./routes";
import { Provider } from "react-redux";
import store from "./stores/store";

function App() {
  return (
    <Provider store={store}>
      <BrowserRouter>
        <RenderRouter />
      </BrowserRouter>
    </Provider>
  );
}

export default App;
