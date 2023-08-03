import React, {useState } from 'react';

import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import { Container, Paper, Button,IconButton} from '@material-ui/core';
import '../App.css';
import axios from 'axios';


export default function Login() {

const [username, setUsername] = useState('');
const [password, setPassword] = useState('');
const [isLoggedIn, setIsLoggedIn] = useState(false);


const handleUsernameChange = (e) => {
  setUsername(e.target.value);
};

const handlePasswordChange = (e) => {
  setPassword(e.target.value);
};

const handleLogin = () => {
  // Simulate authentication
  if (username === 'user' && password === 'password') {
    console.log('Valid credentials');
  } else {
    console.log('Invalid credentials');
  }
};

const handleLogout = () => {
  setIsLoggedIn(false);
};

const formStyle = {
  width: '400px', // Adjust width as needed
  margin: '0 auto', // Center the form horizontally
  padding: "100px",
};


  return (
  

<form style={formStyle}>

        <h3>Sign In</h3>
        <div className="mb-3">
          <label>Email address</label>
          <input
         type="text" value={username} onChange={handleUsernameChange}
          />
        </div>
        <div className="mb-3">
          <label>Password</label>
          <input
            type="password" value={password} onChange={handlePasswordChange}
          />
        </div>
        <div className="mb-3">
          <div className="custom-control custom-checkbox">
            <input
              type="checkbox"
              className="custom-control-input"
              id="customCheck1"
            />
            <label className="custom-control-label" htmlFor="customCheck1">
              Remember me
            </label>
          </div>
        </div>
        <div className="d-grid">
          <button onClick={handleLogin} type="submit" className="btn btn-primary">
            Login
          </button>
        </div>
      </form>

  );
}
