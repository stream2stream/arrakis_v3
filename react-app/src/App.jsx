import React from "react";
import AllBonds from "./components/pets/AllBonds";
import AllMaturingBonds from "./components/pets/AllMaturingBonds";
import Login from "./components/pets/Login";
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { Route, Routes } from 'react-router-dom'

function App() {
  return (
    <>
      <Navbar expand="lg" className="bg-body-tertiary">
        <Container>
          <Navbar.Brand href="/">Heroes</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <Nav.Link href="/allheroes">All Heroes</Nav.Link>
              <Nav.Link href="/addhero">Add Hero</Nav.Link>
            </Nav>          </Navbar.Collapse>
        </Container>      </Navbar>

      <Routes>
        <Route path="allheroes" element={<AllBonds />} />
        <Route path="addhero" element={<AllMaturingBonds />} />
        <Route path="/" element={<Login />} />
      </Routes>
    </>
  );
}

export default App;
