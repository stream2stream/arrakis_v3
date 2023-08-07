// import { Button, TextField, Grid, Paper, Typography } from "@material-ui/core";
import { Button, Grid, TextField, Paper, Typography } from "@mui/material";

import "./Login.css";
// To redirect after successful login
import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const Login = ({ setIsLoggedIn }) => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const handleLogin = async () => {
    try {
      const response = await axios.post("http://localhost:8080/api/v1/check_login", {
        username: username,
        password: password,
      });
  
      if (response.status === 200) {
        localStorage.setItem("loggedInUser", username);
        setIsLoggedIn(true);
        // Login successful, redirect to dashboard or other protected routes
        navigate("/dashboard"); // Adjust the path based on your routing configuration
      } else {
        // Login failed, handle the error
        console.log("Login failed");
      }
    } catch (error) {
      console.log("Error during login:", error);
    }
  };

  return (
    <Grid container className="container">
      <Grid item xs={12} sm={8} md={6} lg={4}>
        <Paper className="login-form">
          <Typography variant="h4" align="center">
            Login
          </Typography>{" "}
          <TextField
            fullWidth
            margin="normal"
            label="Username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
          />
          <TextField
            fullWidth
            margin="normal"
            type="password"
            label="Password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
          <Button
            style={{ marginTop: "1em" }}
            fullWidth
            variant="contained"
            color="primary"
            onClick={handleLogin}
          >
            Login
          </Button>{" "}
        </Paper>
      </Grid>
    </Grid>
  );
};

export default Login;
