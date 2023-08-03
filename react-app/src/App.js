import logo from './logo.svg';
import './App.css';
import Bond from './components/AllBonds'
import Login from './components/Login';
import {Dummy} from './components/dummy';
import { Routes, Route } from "react-router-dom";

const App = () => {
  return (
    <Routes>
        <Route path="/dummy" element={<Dummy />} />
        <Route path="/" element={<Login />} />
    </Routes>
  )
};

export default App;

