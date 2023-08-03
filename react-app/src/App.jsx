import'bootstrap/dist/css/bootstrap.min.css';
import React from "react";
import { Pets } from "./components/pets/Pets";
import Navigation from "./components/Navigation";
import Datepicker from './components/Datepicker';
import Table from './components/Table';


const App = () => {
  return <>
    <Navigation/>
    <Datepicker/>
    <Table/>
  </>
};

export default App;



