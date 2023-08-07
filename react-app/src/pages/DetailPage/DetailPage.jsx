import React from "react";
import { Card, CardContent, Typography } from "@mui/material";
import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";

import { makeStyles } from "@mui/styles";
import NavBar from "../../components/NavBar/NavBar";
const useStyles = makeStyles({
  root: {
    minWidth: 275,
    marginTop: 50,
    padding: 20,
    backgroundColor: "#f5f5f5",
    boxShadow: "0 3px 5px 2px rgba(125, 123, 135, .3)",
    position: "absolute",
    top: "50%",
    left: "50%",
    transform: "translate(-50%, -50%)"
  },
  title: {
    fontSize: 20,
    color: "#3f51b5",
    marginBottom: 12,
  },
  
});

const DetailPage = ({ setIsLoggedIn }) => {
  const classes = useStyles();
  const { isin } = useParams(); 
  const [bond, setBond] = useState({});

  useEffect(() => {
    axios.post(`http://localhost:8080/api/v1/bond_details?isin=${isin}`, {})
    .then((response) => {
        setBond(response.data);  
    })
    .catch((error) => {
        console.error("Eroare la solicitarea detaliilor bond-ului:", error);
    });
}, [isin]);

  return (
    <>
      <NavBar setIsLoggedIn={setIsLoggedIn} />
      <Card className={classes.root}>
        <CardContent>
        <Typography variant="h5" component="div">
            {bond.issuerName || "Loading..."}  {/* Updated property name */}
          </Typography>{" "}
          <Typography sx={{ mb: 1.5 }} color="text.secondary">
            {bond.isin}
          </Typography>
          <Typography variant="body2">CUSIP: {bond.cusip}</Typography>
          <Typography variant="body2">
            Maturity Date: {bond.maturityDate}
          </Typography>{" "}
          <Typography variant="body2">Coupon: {bond.coupon}</Typography>
          <Typography variant="body2">Type: {bond.type}</Typography>
          <Typography variant="body2">
            Face Value: {bond.faceValue}
          </Typography>{" "}
          <Typography variant="body2">Currency: {bond.currency}</Typography>{" "}
          <Typography variant="body2">Status: {bond.status}</Typography>{" "}
        </CardContent>
      </Card>
    </>
  );
};

export default DetailPage;
