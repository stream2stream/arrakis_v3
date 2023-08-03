import React from "react";
// import { Button, TextField, Grid, Paper, Typography } from "@material-ui/core";
import{ Button,Grid, TextField, Paper,Typography} from '@mui/material'
import { useState } from "react";
import './Login.css'


const Login = () => {
   const [username, setUsername] = useState("");
     const [password, setPassword] = useState("");

       const handleLogin = () => {
            // logica de autentificare aici
                console.log("Username: ", username);
                    console.log("Password: ", password);
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

  }
export default Login;
