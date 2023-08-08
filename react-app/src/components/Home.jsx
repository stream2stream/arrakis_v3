import React, { createContext, useState } from 'react';
import onChange from "react";
import ReactSwitch from "react-switch";
import '../styles/layout.css';
import Modal from './Modal'
import AllBooks from './AllBooks'
import AllBonds from './AllBonds'
import DateBox from './DateBox'
import Calendar from './Calendar';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { useNavigate } from "react-router-dom";
import { Button } from 'react-bootstrap';
export const ThemeContext = createContext(null);

const Home = () => {

  const navigate = useNavigate();
  const handleOnClick1 = (event) => {
    //Prevent page reload

    event.preventDefault();
    navigate("/Home");

  }

  const handleOnClick2 = (event) => {
    //Prevent page reload

    event.preventDefault();
    navigate("/myBonds");

  }
  const handleCalendar= (event) => {
    //Prevent page reload

    event.preventDefault();
    navigate("/filter");

  }
    const handleLogout = (event) => {
        //Prevent page reload
        event.preventDefault();

        navigate("/")
    }
  const [theme, setTheme] = useState("light")
  const toggleTheme = () => {
    setTheme((curr) => (curr === "light" ? "dark": "light"));
  }
  return (
    
    <ThemeContext.Provider value={{theme, toggleTheme}}>
      <div  id={theme}>
      <header id='header'>
      <Navbar id='nav' expand="lg" className="bg-body-tertiary">
        <Container id='nav' >
          <Navbar.Brand id='nav' href="#home">Bond Overview</Navbar.Brand>
          <Navbar.Toggle id='nav' aria-controls="basic-navbar-nav"  />
          <Navbar.Collapse  id="basic-navbar-nav" >
            <Nav className="me-auto" >
              <Nav.Link id='nav' onClick={handleOnClick1}  >All Bonds</Nav.Link>

              <Nav.Link id='nav' onClick={handleOnClick2} >My Bonds</Nav.Link>
            </Nav>
          </Navbar.Collapse>
        </Container>
        
      </Navbar>
      </header>
          <div className="left-column" id={theme}>

      <div className='main'>
          <div className="top-right">
              <Button as="input" type="logout" value="Sign out" onClick={handleLogout} />
          </div>

          <div className='box'>
              <Modal></Modal>
          </div>

      <div className='switch'>
        <label>{theme ==="light" ? "Light Mode" : "Dark Mode"}</label>
        <ReactSwitch onChange={toggleTheme} checked={theme === "dark"}/>


          <div className="filter">
              <Button onClick={handleCalendar}>Filter By Date</Button>
          </div>
              <div className='bidnumber'></div>

        </div>




        <div className='bidnumber'>

        </div>


      </div>

      <div className='table-container' id={theme}>
        <div className="right-column" id={theme}>

          <table id={theme}>

            <AllBonds></AllBonds>

          </table>

          <div className="space-between-tables" id={theme}/>
        </div>
      </div>

      </div>
    </div>
    </ThemeContext.Provider>
  );
};

export default Home;



