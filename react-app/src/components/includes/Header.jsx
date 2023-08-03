import React from 'react'
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';

const Header = () => {
    return (
        <>
            <Navbar expand="lg" className="bg-body-tertiary" >
                <Container>
                    <Navbar.Brand href="/body">Just-Bond</Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                        
                        <Nav className="header-nav-links me-auto">
                            <Nav.Link href="/products">Products</Nav.Link>
                            <Nav.Link href="/products">Free Trial</Nav.Link>
                            <Nav.Link href="/about">About</Nav.Link>
                        </Nav>
                        <Nav id='ms-auto'>
                                <Nav.Link href="/login">Sign Out</Nav.Link>
                                <NavDropdown title="Language" id="basic-nav-dropdown">
                                    <NavDropdown.Item href="#action/3.1">English</NavDropdown.Item>
                                    <NavDropdown.Divider />
                                    <NavDropdown.Item href="#action/3.2">German</NavDropdown.Item>
                                </NavDropdown>
                                <Nav.Link href="#link">Welcome User</Nav.Link>
                            </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        </>
    )
}

export default Header