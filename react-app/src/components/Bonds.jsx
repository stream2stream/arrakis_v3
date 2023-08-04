import React from 'react'
import Navbar from "react-bootstrap/Navbar";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Image from './../images/Deutsche-Bank-Logo.png'
import { useState } from "react";
import { useNavigate } from 'react-router-dom';

export const Bonds = () => {

    const [date, setDate] = useState('12-July-2021');
    const [type, setType] = useState('Sovereign');
    const [isShown, setIsShown] = useState(false);

    const handleClick = event => {
        setIsShown(true);
    }

    let navigate = useNavigate();

    const routeChange = () => {
        const shouldLogout = window.confirm("Are you sure you want to logout?");
        let path = '/login'
        if (shouldLogout)
        navigate(path)
    }

    return (
        < >
            <Navbar class="navbar navbar-light" style={{ backgroundColor: "#e3f2fd" }}>
                <Container>
                    <Navbar.Brand href="/home">
                        <img src={Image} width="100px" height="50px" />
                    </Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="me-auto">
                            <Nav.Link href="/bonds"><b>Bonds</b></Nav.Link>
                            <Nav.Link href="/profile"><b>Profile</b></Nav.Link>
                            <Nav.Link onClick={routeChange}><b>Logout</b></Nav.Link>
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
            <div style={{ background: "linear-gradient(to bottom right, #000FFF, #000000)", minHeight: "calc(100vh - 56px)", padding: "20px" }}>
                <div className="card" style={{ width: "18rem", marginLeft: "600px", marginTop: "100px" }}>
                    <div className="card-body" >
                        <h5 className="card-title">Bond</h5>
                        <h6 className="card-subtitle mb-2 text-muted">Maturity: {date}</h6>
                        <p className="card-text">Type: {type}</p>
                        <button type="submit" className="btn btn-primary" >Previous</button>
                        <button type="submit" className="btn btn-primary" onClick={handleClick} style={{ marginLeft: "10px" }}>Details</button>
                        <button type="submit" className="btn btn-primary" style={{ marginLeft: "20px" }} >Next</button>
                    </div>
                </div>
                {isShown && (<>
                    <h2 style={{ color: "white" }}>More details:</h2>
                    <table className="table" style={{ borderStyle: "solid", borderRadius: "20px", borderColor: "gray" }} >
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">First</th>
                                <th scope="col">Last</th>
                                <th scope="col">Handle</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>@mdo</td>
                            </tr>
                            <tr>
                                <th scope="row">2</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>@fat</td>
                            </tr>
                            <tr>
                                <th scope="row">3</th>
                                <td colSpan="2">Larry the Bird</td>
                                <td>@twitter</td>
                            </tr>
                        </tbody>
                    </table>
                </>


                )}

            </div>


        </>

    )
}

