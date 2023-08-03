import React from "react";
import { Pets } from "./components/pets/Pets";
import { HomePage } from "./components/HomePage";
import NavigationBar from "./components/NavigationBar";

const App = () => {
  return (
    <>
      <NavigationBar />
      <HomePage />
    </>
  )
};

export default App;
