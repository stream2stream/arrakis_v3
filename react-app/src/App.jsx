import React from "react";
import { Dashboard } from "./components/dashboard/Dashboard";
import { LoginPage } from "./components/dashboard/LoginPage";
import { Routes, Route } from "react-router-dom";
import styles from "./App.css"

const App = () => {
  return (
    <>
      <LoginPage />
      <Routes>
        <Route path="dashboard" element={<Dashboard/>} />
      </Routes>
    </>
  )
};

export default App;
