import React from "react";
import "./App.css";
import { Bonds } from "./components/Bonds";
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './components/home';
import Login from './components/login';
import { useState } from 'react';

const App = () => {
  // return <Bonds />;
  const [loggedIn, setLoggedIn] = useState(false)
  const [email, setEmail] = useState("")

  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Home email={email} loggedIn={loggedIn} setLoggedIn={setLoggedIn}/>} />
          <Route path="/login" element={<Login setLoggedIn={setLoggedIn} setEmail={setEmail} />} />
          <Route path="/Bonds" element={<Bonds/>} />
        </Routes>
      </BrowserRouter>
    </div>);
};

export default App;
