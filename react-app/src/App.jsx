import React from "react";
import { Dashboard } from "./components/dashboard/Dashboard";
import { LoginPage } from "./components/dashboard/LoginPage";
import { Routes, Route } from "react-router-dom";
import styles from "./App.css"

const App = () => {
  return (
    <>
      <Routes>
        <Route path="dashboard" element={<Dashboard/>} />
        <Route path="login" element={<LoginPage/>} />
        <Route path="/" element={<LoginPage/>} />
      </Routes>
    </>
  )
};

export default App;
