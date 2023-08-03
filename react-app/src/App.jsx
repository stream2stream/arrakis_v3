import React from "react";
import { useState } from "react";
import Header from "./components/includes/Header";
import Body from "./components/Body";
import Securities from "./components/security/Securities";
import Trades from "./components/trade/Trades";
import { Route, Routes } from 'react-router-dom';
import LoginForm from "./components/auth/LoginForm";
import Footer from "./components/includes/Footer";


const App = () => {
  return (
    <>
      <div className="page-container">
      <div className="content-wrap">
      <Header />

      <Routes>
        <Route path="/body" element={<Body />} />
        <Route path="/login" element={<LoginForm />} />
        <Route path="/" element={<Body/>} />
        <Route path="/securities" element={<Securities />} />
        <Route path="/trades" element={<Trades />} />
      </Routes>
      </div>
      <Footer />
      
      </div>
    </>
  )
};

export default App;
