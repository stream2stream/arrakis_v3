import React from "react";
import { Pets } from "./components/pets/Pets";
import Login from "./pages/LoginPage/Login";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Dashboard from "./pages/DashboardPage/Dashboard";
import LandingPage from "./pages/LandingPage/LandingPage";
import DetailPage from "./pages/DetailPage/DetailPage";
const App = () => {
  return (
    <>
      <Router>
        <Routes>
          <Route path="/login" element={<Login />} />

          <Route path="/dashboard" element={<Dashboard />} />

          <Route path="/landingpage" element={<LandingPage />} />

          <Route path="/detail/:ISIN" element={<DetailPage />} />
        </Routes>
      </Router>
    </>
  );
};

export default App;
