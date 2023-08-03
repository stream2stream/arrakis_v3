import React from "react";
import AllBonds from "./components/pets/AllBonds";
import AllMaturingBonds from "./components/pets/AllMaturingBonds";
import Login from "./components/pets/Login";
import NotAuthorized from "./components/pets/NotAuthorized";
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { Route, Routes } from 'react-router-dom'
import Logout from "./components/pets/Logout";
import { getAuth } from 'firebase/auth';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  const auth = getAuth();
  const user = auth.currentUser;

  return (
    <>
      <Navbar expand="lg" className="bg-body-tertiary">
        <Container>
          <Navbar.Brand href="/">Home</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="ml-auto">
              {user &&
              <>
                <Nav.Link href="/logout">Logout</Nav.Link>
                <Nav.Link href="/allbonds">All Bonds</Nav.Link>
                <Nav.Link href="/bondsbymaturity">Bonds by Maturity</Nav.Link>
              </>}
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
  
      <Container className="mt-3">
        <Routes>
          <Route path="/" element={<AllBonds />} />
          <Route path="/allbonds" element={<AllBonds />} />
          <Route path="/login" element={<Login/>} />
          <Route path="/bondsbymaturity" element={<AllMaturingBonds/>} />
          <Route path="notauthorized" element={<NotAuthorized />} />
          <Route path="logout" element={<Logout />} />
        </Routes>
      </Container>
    </>
  );
}

export default App;
