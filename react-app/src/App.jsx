import React from "react";
import AllBonds from "./components/pets/AllBonds";
import AllMaturingBonds from "./components/pets/AllMaturingBonds";
import { Navbar, Nav, Container } from 'react-bootstrap';
import { Route, Routes } from 'react-router-dom'

function App() {
  return (
    <>
      <Navbar expand="lg" className="bg-body-tertiary">
        <Container>
          <Navbar.Brand href="/">Bonds</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <Nav.Link href="/allbonds">All Bond</Nav.Link>
              <Nav.Link href="/addhero">All Maturing Bonds</Nav.Link>
            </Nav>          </Navbar.Collapse>
        </Container>      </Navbar>

      <Routes>
        <Route path="allbonds" element={<AllBonds />} />
        <Route path="addhero" element={<AllMaturingBonds />} />
        <Route path="/" element={<AllBonds />} />
      </Routes>
    </>
  );
}

export default App;
