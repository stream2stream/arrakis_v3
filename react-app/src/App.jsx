import React from "react";
import AllBonds from "./components/pets/AllBonds";
import AllMaturingBonds from "./components/pets/AllMaturingBonds";
import Login from "./components/pets/Login";
import NotAuthorized from "./components/pets/NotAuthorized";
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { Route, Routes } from 'react-router-dom'

function App() {
  return (
    <>
      <Navbar expand="lg" className="bg-body-tertiary">
        <Container>
          <Navbar.Brand href="/">Home</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <Nav.Link href="/allbonds">All Bonds</Nav.Link>
              <Nav.Link href="/bondsbymaturity">Bonds by Maturity</Nav.Link>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>


      <Routes>
        <Route path="/allbonds" element={<AllBonds />} />
        <Route path="/bondsbymaturity" element={<AllMaturingBonds/>} />
        <Route path="/" element={<Login />} />
        <Route path="notauthorized" element={<NotAuthorized />} />
      </Routes>
    </>
  );
}

export default App;
