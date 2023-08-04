import React from "react";
import Home from "./pages/Home";
import ZoomBond from "./pages/ZoomBond";
import Bonds from "./pages/Bonds";
import Test from "./pages/Test";
import Login from "./pages/Login";
import { BrowserRouter as Router, Routes, Route, Navigate, } from "react-router-dom";

const isAuthenticated = () => {
  // Replace with your actual authentication logic
  return localStorage.getItem('jwtToken') !== null ;
};

// ProtectedRoute component
const ProtectedRoute = ({ component: Component, ...rest }) => (
  <Route
    {...rest}
    render={props =>
      isAuthenticated() ? (
        <Component {...props} />
      ) : (
        <Navigate to="/login" />
      )
    }
  />
);


const App = () => {

  return (<>
  
    <Routes>
      <Route path="/" element={<Navigate replace to="/home/bonds" />} />
      <Route path="login" element={<Login />}/>
      <Route ProtectedRoute  path="home" element={<Home />}>
          <Route ProtectedRoute path="bonds" element={<Bonds />} />
          <Route ProtectedRoute path="zoombond" element={<ZoomBond />} />
          <Route ProtectedRoute path="test" element={<Test />} />
      </Route>
    </Routes>
  </>);
};

export default App;
