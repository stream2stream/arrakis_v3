import React from "react";
import HomePage from "./components/HomePage";

const App = () => {
  let dates = [["bond 1", "bond 2", "bond 3"], ["bond 4", "bond 5", "bond 6"], ["bond 7", "bond 8", "bond 9"]]
  return <HomePage dates={dates}/>;
};

export default App;
