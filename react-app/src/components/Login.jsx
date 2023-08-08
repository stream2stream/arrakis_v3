import React, { useState } from "react";
import ReactDOM from "react-dom";
import "./LoginStyle.css";
//import { useNavigate } from 'react'
import { useNavigate } from "react-router-dom";
//import { redirect } from "react-router-dom";
import { useEffect } from 'react';
import {checkUser} from '../services/login-service';



export default function Login() {
  
  // React States
  const navigate = useNavigate();
  const [errorMessages, setErrorMessages] = useState({});
  const [isSubmitted, setIsSubmitted] = useState(false);



  const handleSubmit = (event) => {
    //Prevent page reload
    event.preventDefault();
    var { uname, pass } = document.forms[0];
    const email = uname.value
    const password = pass.value
    let user = { email, password  };

    // Find user login info
    checkUser(user)
    .then(res => {
      console.log('loggedin');
       navigate("/Home")
       })
     .catch(err=>{
      console.log('notloggedin');
      setErrorMessages({ name: "error", message: 'Invalid username or password'});
       })
       }
  

  // Generate JSX code for error message
  const renderErrorMessage = (name) =>
    name === errorMessages.name && (
      <div className="error">{errorMessages.message}</div>
    );

  // JSX code for login form
  const renderForm = (
    <div className="form"> {renderErrorMessage("error")}
      <form onSubmit={handleSubmit}>
        <div className="input-container">
          <input type="text" name="uname" required placeholder="Email"/>
        </div>
        <div className="input-container">
          <input type="password" name="pass" required placeholder="Password"/>
        </div>
        <div className="button-container">
          <input type="submit" />
        </div>
      </form>
    </div>
  );

  return (
    <div className="app">
      <div className="login-form">
        <div className="title">Sign In</div>
        {isSubmitted ? <div>User is successfully logged in</div> : renderForm}
      </div>
    </div>
  );
}

