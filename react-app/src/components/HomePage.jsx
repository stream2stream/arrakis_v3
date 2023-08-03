import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import Navbar from "react-bootstrap/Navbar";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";

const Homepage = () => {
  return (
      <>
        <Navbar bg="dark" data-bs-theme="dark" expand="lg" className="bg-body-tertiary">
          <Container>
            <Navbar.Brand href="/home"><b>Home</b></Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav" />
            <Navbar.Collapse id="basic-navbar-nav">
              <Nav className="me-auto">
                <Nav.Link href="/bonds"><b>Bonds</b></Nav.Link>
                <Nav.Link href="/profile"><b>Profile</b></Nav.Link>
                <Nav.Link href="/logout"><b>Logout</b></Nav.Link>
              </Nav>
            </Navbar.Collapse>
          </Container>
        </Navbar>
      <h1>Welcome to My Homepage</h1>
    </>
  );
};

export default Homepage;
