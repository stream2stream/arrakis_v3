import React from "react";
import { useState } from "react";
import Header from "./components/includes/Header";
import Body from "./components/Body";
import Books from "./components/security/Securities";
import { Route, Routes } from 'react-router-dom';
import LoginForm from "./components/auth/LoginForm";
import Footer from "./components/includes/Footer";


const App = () => {
  const [dummyUser, setDummyUser] = useState(null);
  const setUser = () => {
    setDummyUser({});
  }
  return (
    <>
      <div className="page-container">
      <div className="content-wrap">
      <Header />

      <Routes>
        <Route path="/body" element={<Body setUser={setUser} user={dummyUser} />} />
        <Route path="/" element={<Books />} />
        <Route path="/login" element={<LoginForm />} />
      </Routes>
      </div>
      <Footer />
      
      </div>
    </>
  )
};

export default App;
