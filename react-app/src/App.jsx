import React from "react";
import { useState } from "react";
import Header from "./components/includes/Header";
import Body from "./components/Body";
import Books from "./components/security/Securities";
import { Route, Routes } from 'react-router-dom';

const App = () => {
  const [dummyUser, setDummyUser] = useState(null);
  const setUser = () => {
    setDummyUser({});
  }
  return (
    <>
      <Header />

      <Routes>
        <Route path="/body" element={<Body setUser={setUser} user={dummyUser} />} />
        <Route path="/" element={<Books />} />
      </Routes>
    </>
  )
};

export default App;
