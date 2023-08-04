import React from 'react'
import { Nav } from 'react-bootstrap';
import { NavLink } from 'react-bootstrap';
import { auth } from '../../firebase.js';
import { signInWithEmailAndPassword, updateEmail } from 'firebase/auth';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const LoginForm = (props) => {
    const handleSubmit = (event) => {
        event.preventDefault();
        props.setUser({});

    }

    const navigate = useNavigate();
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const onLogin = (e) => {
        e.preventDefault();
        console.log(email, password);
        signInWithEmailAndPassword(auth, email, password)
            .then((userCredential) => {
                // Signed in
                const user = userCredential.user;
                props.info.setUser(user)
                navigate("/")
                console.log(user.email);
            })
            .catch((error) => {
                const errorCode = error.code;
                const errorMessage = error.message;
                console.log(errorCode, errorMessage)
            });

    }
    const updateEmail = (event) => {
        setEmail(event.target.value)

    }
    const updatePassword = (event) => {
        setPassword(event.target.value)

    }

    return (
        <div className='login-container'>
            <form className='auth-inner'>
                <h3>Sign In</h3>
                <div className="mb-3">
                    <label>Email address</label>
                    <input type="email" className="form-control" onChange={updateEmail} placeholder="Enter email" />
                </div>
                <div className="mb-3">
                    <label>Password</label>
                    <input type="password" className="form-control" onChange={updatePassword} placeholder="Enter password" />
                </div>
                <div className="mb-3">
                    <div className="custom-control custom-checkbox">
                        <input type="checkbox" className="custom-control-input" id="customCheck1" />
                        <label className="custom-control-label" htmlFor="customCheck1">
                            Remember me
                        </label>
                    </div>
                </div>
                <div className="d-grid">
                    <button type="submit" className="btn" id='btn-custom' onClick={onLogin}>
                        Submit
                    </button>
                </div>
                <div>
                    <NavLink to="/signup" >
                        Don't have an account?
                    </NavLink>
                    <p className="forgot-password text-right">
                        Forgot <a href="#">password?</a>
                    </p>
                </div>

            </form>
        </div>
    )
}

export default LoginForm