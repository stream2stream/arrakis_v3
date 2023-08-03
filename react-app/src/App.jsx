import React from "react";
import { Pets } from "./components/pets/Pets";
import { HomePage } from "./components/HomePage";
import NavigationBar from "./components/NavigationBar";
import { useState } from "react";

const App = () => {
  const [selectedTab, setSelectedTab] = useState(0);
  if (selectedTab === 0) {
    return (
      <>
        <NavigationBar setTab={setSelectedTab} />
        <HomePage />
      </>
    )
  } else {
    return (
      <>
        <NavigationBar setTab={setSelectedTab} />
        <Pets />
      </>
    )
  }
};

export default App;
