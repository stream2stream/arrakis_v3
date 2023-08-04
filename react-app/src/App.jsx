
import { Pets } from "./components/pets/Pets";
import Login from "./pages/LoginPage/Login";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Dashboard from "./pages/DashboardPage/Dashboard";
import LandingPage from "./pages/LandingPage/LandingPage";
import DetailPage from "./pages/DetailPage/DetailPage";
import axios from "axios";
import { useHistory } from 'react-router-dom'; // To redirect after successful login
import React, { useState, useEffect } from "react";
import {useNavigate} from 'react-router-dom';
import { Navigate } from "react-router-dom";
const App = () => {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  return (
    <>
      <Router>
      
        <Routes>
          <Route path="/login" element={<Login setIsLoggedIn={setIsLoggedIn} />} />
          <Route
            path="/dashboard"
            element={isLoggedIn ? <Dashboard /> : <Navigate to="/login" replace />}
          />
          <Route
            path="/landingpage"
            element={isLoggedIn ? <LandingPage /> : <Navigate to="/login" replace />}
          />
          <Route
            path="/detail/:ISIN"
            element={isLoggedIn ? <DetailPage /> : <Navigate to="/login" replace />}
          />
        </Routes>
      </Router>
    </>
  );
};

export default App;