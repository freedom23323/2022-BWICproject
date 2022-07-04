import React from "react";
import logo from "./logo.svg";
import "./App.css";
import CreateBwic_Antd from "./pages/trader-portal/CreateBwic_Antd";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import LoginPage from "./pages/login/login";
import RenderRouter from "./routes";
import {Provider} from "react-redux"
import store from "./stores/store";

function App() {
  return (
    <Provider store={store}>
    <BrowserRouter>
      {/* <Routes>
        <Route index element={<LoginPage />} />
        <Route path="/trader" element={<CreateBwic_Antd />} />
      </Routes> */}
      <RenderRouter />
    </BrowserRouter>
    </Provider>
  );
}

// import React from 'react';
// import logo from './logo.svg';
// import './App.css';
// import CreateBwic_Antd from './pages/trader-portal/CreateBwic_Antd';
// //import CreateBwic from './pages/trader-portal/CreateBwic';'./pages\trader-portal\CreateBwic.tsx';
// //import CreateBwic from './pages/trader-portal/CreateBwic';
// //import BrowserRouter 

// function App() {
//   return( <CreateBwic_Antd />);
//   // return (
  //   <div className="App">
  //     <header className="App-header">
  //       <img src={logo} className="App-logo" alt="logo" />
  //       <p>
  //         Edit <code>src/App.tsx</code> and save to reload.
  //       </p>
  //       <a
  //         className="App-link"
  //         href="https://reactjs.org"
  //         target="_blank"
  //         rel="noopener noreferrer"
  //       >
  //         Learn React
  //       </a>
  //     </header>
  //   </div>
//}

export default App;
