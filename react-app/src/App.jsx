import React from "react";
import Home from "./pages/Home";
import ZoomBond from "./pages/ZoomBond";
import Bonds from "./pages/Bonds";
import Test from "./pages/Test";
import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";

const App = () => {
  return (<>
  
    <Routes>
      <Route path="/" element={<Navigate replace to="/home/bonds" />} />
      <Route path="home" element={<Home />}>
          <Route path="bonds" element={<Bonds />} />
          <Route path="zoombond" element={<ZoomBond />} />
          <Route path="test" element={<Test />} />
      </Route>
    </Routes>
  </>);
};

export default App;
