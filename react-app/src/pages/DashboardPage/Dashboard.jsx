import React from "react";
import { Grid, Card, CardContent, CardHeader } from "@mui/material";
import NavBar from "../../components/NavBar/NavBar";

const Dashboard = () => {
  const today = new Date();
  const dates = [
    today,
    new Date(today.getTime() + 24 * 60 * 60 * 1000),
    new Date(today.getTime() + 2 * 24 * 60 * 60 * 1000),
    new Date(today.getTime() + 3 * 24 * 60 * 60 * 1000),
    new Date(today.getTime() + 4 * 24 * 60 * 60 * 1000),
  ];

  return (
    <>
    <NavBar />
    <Grid container spacing={2} direction="row" justify="center" className="container">
    {dates.map((date, index) => (
      <Grid item xs={2} key={index} className="grid-content">
        <Card>
          <CardHeader
            title={date.toLocaleDateString("en-US", {
              weekday: "long",
              day: "numeric",
              month: "long",
            })}
          />
          <CardContent>
            {/* Alte informații despre card pot fi aici */}No bonds expiring
          </CardContent>{" "}
        </Card>
      </Grid>
    ))}
  </Grid>
  </>
  );
};

export default Dashboard;
