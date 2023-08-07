import './App.css';
import Login from './components/Login';
import Home from './components/Home';
import { Routes, Route } from "react-router-dom";

const App = () => {
  return (
    <Routes>
        <Route path = "/Home" element = {<Home />} />
        <Route path = "/" element = {<Login />} /> 
    </Routes>
  );
};

export default App;