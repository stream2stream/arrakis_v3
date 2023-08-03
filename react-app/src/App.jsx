import React from "react";
import { Pets } from "./components/pets/Pets";
import Login from "./pages/LoginPage/Login";
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import Dashboard from "./pages/DashboardPage/Dashboard";
import LandingPage from "./pages/LandingPage/LandingPage";
const App = () => {
  return (
    <>
    <Router>
      <Routes>
        <Route path = "/login"    
          element = {<Login/>} />
         
      

        <Route path = '/dashboard'
          element = {<Dashboard/>} />
          
        <Route path = '/landingpage'
        element = {<LandingPage/>} />
       
      </Routes>
    </Router>
    </>
  )
};

export default App;
