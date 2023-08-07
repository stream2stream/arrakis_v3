import React, { useEffect } from 'react'
import Navbar from "react-bootstrap/Navbar";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Image from './../images/Deutsche-Bank-Logo.png'
import { useState } from "react";
import { useNavigate } from 'react-router-dom';
import {getAllBondsOfAUser} from "../services/bonds-service";
import {signOut} from "firebase/auth";
import auth from "../config/firebase";

export const Bonds = () => {

    const [isShown, setIsShown] = useState(false);
    const [bonds, setBonds] = useState([]);
    const [selectedBondHolder, setSelectedBondHolder] = useState('AZ Holdings Inc');

    const handleClick = event => {
        setIsShown(true);
    }

    let navigate = useNavigate();



    const logOut = async () => {
        try {
            const shouldLogout = window.confirm("Are you sure you want to logout?");
            if (shouldLogout){
                await signOut(auth);
                navigate('/login')
            }
            console.log("Logout successfully!")

        } catch (err){
            console.error(err);
        }
    };


    useEffect(() => {
        getAllBondsofAUserAPI(selectedBondHolder);
    }, [selectedBondHolder])

    const getAllBondsofAUserAPI = (bondHolder) => {
        console.log(bondHolder)
        getAllBondsOfAUser(bondHolder)
            .then(res => {
                setBonds(res.data);
            })
            .catch(err => {
                setBonds([]);
                console.log(err);
            })

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
                            <Nav.Link onClick={logOut}><b>Logout</b></Nav.Link>
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
            <div style={{ background: "linear-gradient(to bottom right, #000FFF, #000000)", minHeight: "calc(100vh - 56px)", padding: "20px" }}>
                <div>
                    <label style={{ color: "#FFFFFF" }}>
                        <b>Choose the Bond Holder:</b><br></br>

                        <select onChange={(event) => setSelectedBondHolder(event.target.value)}>
                            <option value="AZ Holdings Inc">AZ Holdings Inc</option>
                            <option value="Acme co">Acme co</option>
                            <option value="Sovereign Investments">Sovereign Investments</option>
                            <option value="Astra Trading Ltd">Astra Trading Ltd</option>
                            <option value="Muncipal Gov Of Orange County">Muncipal Gov Of Orange County</option>
                            <option value="Goldman Sachs">Goldman Sachs</option>
                            <option value="UBS">UBS</option>
                            <option value="Barclays">Barclays</option>
                            <option value="British Telecom">British Telecom</option>
                            <option value="Pension Holdings">Pension Holdings</option>
                            <option value="Zurich Pension fund 4">Zurich Pension fund 4</option>
                        </select>

                    </label>
                </div>
                <div className="card" style={{ width: "18rem", marginLeft: "600px", marginTop: "100px" }}>
                    <div className="card-body" >
                        <h5 className="card-title">Bond</h5>
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
                                <th scope="col">Book name</th>
                                <th scope="col">Bond Holder</th>
                                <th scope="col">Status</th>
                                <th scope="col">Issuer Name</th>
                                <th scope="col">ISIN</th>
                                <th scope="col">CUSIP</th>
                                <th scope="col">Quantity</th>
                                <th scope="col">Bond Maturity Date</th>
                                <th scope="col">Bond Currency</th>
                                <th scope="col">Coupon Percent</th>
                                <th scope="col">Unit Price</th>

                            </tr>
                        </thead>
                        <tbody>
                            {bonds.map((bond, index) => {
                                const bondData = bond.split(',');
                                if (bondData[1] === selectedBondHolder) {
                                    return (
                                        <tr key={index}>
                                            <td>{bondData[0]}</td>
                                            <td>{bondData[1]}</td>
                                            <td>{bondData[2]}</td>
                                            <td>{bondData[3]}</td>
                                            <td>{bondData[4]}</td>
                                            <td>{bondData[5]}</td>
                                            <td>{bondData[6]}</td>
                                            <td>{bondData[7]}</td>
                                            <td>{bondData[8]}</td>
                                            <td>{bondData[9]}</td>
                                            <td>{bondData[10]}</td>
                                        </tr>
                                    );
                                    
                                }
                                return null;
                            })}
                        </tbody>
                    </table>
                </>


                )}

            </div>


        </>

    )
}

