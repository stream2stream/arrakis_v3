import React from "react";
import Header from "./components/includes/Header";
import Body from "./components/Body";
import { Route, Routes } from 'react-router-dom';
import LoginForm from "./components/auth/LoginForm";
import Footer from "./components/includes/Footer";


const App = () => {
  return (
    <>
      <div className="page-container">
        <div className="content-wrap">

          <div className="header-container">
            <Header />
          </div>

          <div className="content-container">
            <Routes>
              <Route path="/" element={<Body />} />
              <Route path="/body" element={<Body />} />
              <Route path="/login" element={<LoginForm />} />
            </Routes>
          </div>

          <div className="footer-container">
            <Footer />
          </div>

        </div>
      </div>
    </>
  )
};

export default App;
