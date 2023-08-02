import React from "react";
import Home from "./pages/Home";
import ZoomBond from "./pages/ZoomBond";
import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";

const App = () => {
  return (<>
  
    <Routes>
      <Route path="/" element={<Navigate replace to="/home" />} />
      <Route path="/home" element={<Home />} />
      <Route path="/zoombond" element={<ZoomBond />} /> 
    </Routes>
  </>);
};

export default App;
