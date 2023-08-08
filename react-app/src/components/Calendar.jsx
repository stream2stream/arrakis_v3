import React from 'react';
import Form from 'react-bootstrap/Form';
import { useState } from 'react';
import { checkDateBonds } from '../services/marturity-service';
import BondTable from './BondTable';
import AllBonds from './AllBonds';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import { useNavigate } from "react-router-dom";
import Navbar from 'react-bootstrap/Navbar';
import BondTable2 from './BondTable2';

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

  return (
    <div>
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
    
        <Form.Control type = "date" value = {date} onChange = {updateDate} />
        <BondTable2 data = {bonds} />
    </div>
  )
}

export default Calendar
