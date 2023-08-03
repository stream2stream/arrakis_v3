import React from "react";
import { Card, CardContent, Typography } from "@mui/material";

import { makeStyles } from "@mui/styles";

const useStyles = makeStyles({
  root: {
    minWidth: 275,
    marginTop: 50,
    padding: 20,
    backgroundColor: "#f5f5f5",
    boxShadow: "0 3px 5px 2px rgba(125, 123, 135, .3)",
  },
  title: {
    fontSize: 20,
    color: "#3f51b5",
    marginBottom: 12,
  },
});

const DetailPage = () => {
    const classes = useStyles();
  const bond = {
    ISIN: "Example ISIN",
    CUSIP: "Example CUSIP",
    Issue_Name: "Example Issue",
    Maturity_Date: "2025-01-01",
    Coupon: "Example Coupon",
    Type: "Example Type",
    Face_Value: "Example Face Value",
    Currency: "Example Currency",
    Status: "Example Status",
  };

  return (
    <Card>
      <CardContent>
        <Typography variant="h5" component="div">
          {bond.Issue_Name}
        </Typography>{" "}
        <Typography sx={{ mb: 1.5 }} color="text.secondary">
          {bond.ISIN}
        </Typography>
        <Typography variant="body2">CUSIP: {bond.CUSIP}</Typography>
        <Typography variant="body2">
          Maturity Date: {bond.Maturity_Date}
        </Typography>{" "}
        <Typography variant="body2">Coupon: {bond.Coupon}</Typography>
        <Typography variant="body2">Type: {bond.Type}</Typography>
        <Typography variant="body2">
          Face Value: {bond.Face_Value}
        </Typography>{" "}
        <Typography variant="body2">Currency: {bond.Currency}</Typography>{" "}
        <Typography variant="body2">Status: {bond.Status}</Typography>{" "}
      </CardContent>
    </Card>
  );
};

export default DetailPage;
