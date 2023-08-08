import React from 'react';
import '../styles/layout.css';
import AllBooks from './AllBooks'
import AllBonds from './AllBonds'
import DateBox from './DateBox'
import Calendar from './Calendar';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { useNavigate } from "react-router-dom";
import { Button } from 'react-bootstrap';

const Home = () => {

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
  const handleCalendar= (event) => {
    //Prevent page reload

    event.preventDefault();
    navigate("/filter");

  }
  return (

    <div className="container">
      <Navbar expand="lg" className="bg-body-tertiary">
        <Container>
          <Navbar.Brand href="#home">Bond overview</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <Nav.Link onClick={handleOnClick1} >All Bonds</Nav.Link>

              <Nav.Link onClick={handleOnClick2} >My Bonds</Nav.Link>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>

      <div className="left-column">
        <div className='box'>
          <DateBox></DateBox>
        </div>
        <div>
          <Button onClick={handleCalendar}>Filter By Date</Button>
        </div>
        <div className='bidnumber'>

        </div>

      </div>

      <div className='table-container'>
        <div className="right-column">
          
          <table>

            <AllBonds></AllBonds>

          </table>

          <div className="space-between-tables" />
        </div>
      </div>

    </div>
  );
};

export default Home;



