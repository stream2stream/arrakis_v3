import React, { createContext, useState } from 'react';
import ReactSwitch from "react-switch";
import Form from 'react-bootstrap/Form';
import { checkDateBonds } from '../services/marturity-service';
import BondTable from './BondTable';
import AllBonds from './AllBonds';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import { useNavigate } from "react-router-dom";
import Navbar from 'react-bootstrap/Navbar';
import BondTable2 from './BondTable2';
export const ThemeContext = createContext(null);

const Calendar = () => {

  const [date, setDate] = useState(new Date());   
  const [bonds, setBonds] = useState([]);
  const navigate = useNavigate();
  const handleOnClick1 = (event) => {
    //Prevent page reload

    event.preventDefault();
    navigate("/home");

  }

  const handleOnClick2 = (event) => {
    //Prevent page reload

    event.preventDefault();
    navigate("/myBonds");

  }
  const updateDate = (event) => {
    setDate(event.target.value)

    checkDateBonds(date)
        .then(res => {
            setBonds(res.data);
        })
        .catch(err => {
            setBonds([]);
        console.log(err);
        })
  } 
  const [theme, setTheme] = useState("light")
  const toggleTheme = () => {
    setTheme((curr) => (curr === "light" ? "dark": "light"));
  }
  return (
    <ThemeContext.Provider value={{theme, toggleTheme}}>
    <div id={theme}>
    <Navbar expand="lg" className="bg-body-tertiary" id='nav'>
        <Container>
          <Navbar.Brand id='nav' href="#home">Bond Overview</Navbar.Brand>
          <Navbar.Toggle id='nav' aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
          <Nav id='nav' className="me-auto">
              <Nav.Link id='nav' onClick={handleOnClick1} >All Bonds</Nav.Link>

              <Nav.Link id='nav' onClick={handleOnClick2} >My Bonds</Nav.Link>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
    
        <div className='main'>
        <div className='switch'>
        <label>{theme ==="light" ? "Light Mode" : "Dark Mode"}</label>
        <ReactSwitch onChange={toggleTheme} checked={theme === "dark"}/>
        </div>
        <Form.Control type = "date" value = {date} onChange = {updateDate} />
        <BondTable2 data = {bonds} />
        </div>
    </div>
    </ThemeContext.Provider>
  )
}

export default Calendar
