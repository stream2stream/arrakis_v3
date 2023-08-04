import React, {useState} from 'react';
import {useNavigate} from 'react-router-dom'
import 'bootstrap/dist/css/bootstrap.min.css';
import Container from "react-bootstrap/Container";
import Navbar from "react-bootstrap/Navbar";
import Image from "../images/Deutsche-Bank-Logo.png";
import Nav from "react-bootstrap/Nav";


const Login = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [errors, setErrors] = useState({});

    let navigate = useNavigate();
    const routeChange =() =>{
        let path = '/register'
        navigate(path)
    }
    const handleFormSubmit = (e) => {
        e.preventDefault();

        // Basic form validation
        let errors = {};
        if (!email.trim()) {
            errors.email = 'Email is required';
        } else if (!/\S+@\S+\.\S+/.test(email)) {
            errors.email = 'Invalid email format';
        }
        if (!password.trim()) {
            errors.password = 'Password is required';
        } else if (password.length < 6) {
            errors.password = 'Password must be at least 6 characters';
        }

        if (Object.keys(errors).length === 0) {
            // Submit the form - You can implement your login logic here
            console.log('Form submitted successfully!');
            console.log(email);
        } else {
            setErrors(errors);
        }
    };


    return (
    <>
        <Navbar class="navbar navbar-light" style={{backgroundColor: "#e3f2fd"}}>
            <Container>
                <Navbar.Brand>
                    <img src={Image} width="100px" height="50px" />
                </Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />

            </Container>
        </Navbar>
        <div style={{ background: "linear-gradient(to bottom right, #000FFF, #000000)", minHeight: "calc(100vh)", padding: "20px" }}></div>
        <div className="container mt-5" style={{
            position: "absolute", top: "50%", left: "50%", transform: "translate(-50%, -50%)", padding: "10px"}}>
            <h2 style={{marginLeft:"500px", marginTop:"-290px", color:"white"}}>Login</h2>
            <form onSubmit={handleFormSubmit}>
                <div className="form-group" >
                    <label htmlFor="email" style={{marginLeft:"500px", color: "white"}}>Email:</label>
                    <input
                        type="email"
                        className="form-control"
                        id="email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        style={{marginTop:"5px",width:"300px", marginLeft:"500px"}}
                    />
                    {errors.email && <span className="text-danger" style={{marginLeft:"500px"}}>{errors.email}</span>}
                </div>
                <div className="form-group">
                    <label htmlFor="password" style={{marginLeft:"500px", color: "white"}} >Password:</label>
                    <input
                        type="password"
                        className="form-control"
                        id="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        style={{marginTop:"5px",width:"300px", marginLeft:"500px"}}
                    />
                    {errors.password && <span className="text-danger" style={{marginLeft:"500px"}}>{errors.password}</span>}
                </div>
                <button type="submit" className="btn btn-primary" style={{marginTop:"10px", marginLeft:"500px"}}>Login</button>
                <button type="submit" className="btn btn-primary" onClick={routeChange} style={{marginTop:"10px", marginLeft:"150px"}}>Register</button>

            </form>
        </div>
        </>
    );
};

export default Login;