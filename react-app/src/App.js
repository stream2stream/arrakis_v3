import './App.css';
import Login from './components/Login';
import Home from './components/Home';
import { Routes, Route } from "react-router-dom";
import Calendar from './components/Calendar';

const App = () => {
  return (
    <Routes>
        <Route path = "/Home" element = {<Home />} />
        <Route path = "/" element = {<Login />} /> 
        <Route path='/filter' element ={<Calendar/>}/>
    </Routes>
  );
};

export default App;