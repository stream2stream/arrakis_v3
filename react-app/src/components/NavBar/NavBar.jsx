import React from "react";
import { Link, NavLink } from "react-router-dom";
import { AppBar, Toolbar, Typography, Button } from "@mui/material";
import { useNavigate } from "react-router-dom";

const NavBar = ({  setIsLoggedIn }) => {
  const navigate = useNavigate();
  const handleLogout = () => {
    // Remove the loggedInUser from local storage
    localStorage.removeItem("loggedInUser");
    
    // Set the loggedIn state to false
    setIsLoggedIn(false);
  };

  return (
    <AppBar position="static" className="AppBar">
      <Toolbar>
        <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
          DB App
        </Typography>
        <Button
          color="inherit"
          component={NavLink}
          to="/dashboard"
          className="linkButton"
        >
          Dashboard
        </Button>
        <Button
          color="inherit"
          component={NavLink}
          to="/landingpage"
          className="linkButton"
        >
          Landing Page
        </Button>
        <Button
          color="inherit"
          component={NavLink}
          to="/detail/123"
          className="linkButton"
        >
          Detail Page
        </Button>

        <Button
          color="inherit"
          component={NavLink}
          to="/userbonds"
          className="linkButton"
        >
         Your Bonds
        </Button>

        <Button
      color="inherit"
      component={Link}
      // to="/login"
      onClick={handleLogout}
      className="linkButton"
    >
      LogOut
    </Button>
      </Toolbar>
    </AppBar>
  );
};

export default NavBar;
