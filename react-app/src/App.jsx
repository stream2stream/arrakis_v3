import React from "react";
import HomePage from "./components/HomePage";
import LoginPage from "./components/LoginPage";
import {Route, Routes} from "react-router-dom";
import BondDetailPage from "./components/BondDetailPage";

const App = () => {
    let date;
    let user;
    let dates = [["bond 1", "bond 2", "bond 3"],
                    ["bond 4", "bond 5", "bond 6", "bond 4", "bond 5"],
                    ["bond 7", "bond 8", "bond 9"],
                    ["bond a", "bond b", "bond c"],
                    ["bond d", "bond e", "bond f"],
                    ["bond 1", "bond 2", "bond 3"],
                    ["bond 4", "bond 5", "bond 6"],
                    ["bond 7", "bond 8", "bond 9"]]
  // return <HomePage dates={dates}/>;
    return <Routes>
        <Route path="/" element={<LoginPage />} />
        <Route path={`/bonds/details/:date`} element={<BondDetailPage />} />
        <Route path={`/bonds`} element={<HomePage user={""} dates={dates}/>} />
    </Routes>
};

export default App;
