import React from "react";
import { Grid, Card, CardContent, CardHeader, Select, MenuItem } from "@mui/material";
import NavBar from "../../components/NavBar/NavBar";
import { useState} from "react";


const Dashboard = () => {
  const today = new Date();
  const [selectedDay, setSelectedDay] = useState(0);
  
  const handleChange = (event) => {
    setSelectedDay(event.target.value);
  };
  const generateDates = (numberOfDays) => {
    const dates = [];
    for (let i = -2; i < numberOfDays - 2; i++) {
      const date = new Date(today.getTime() + i * 24 * 60 * 60 * 1000);
      dates.push(date);
    }
    return dates;
  };

  const handleDateChange = (date) => {
    return date.toLocaleDateString("en-US", {
      weekday: "long",
      day: "numeric",
      month: "long",
    });
  };

  const dates = generateDates(5 + selectedDay);
  return (
    <>
    <NavBar />
    <Select value={selectedDay} onChange={handleChange}>
        {[...Array(11).keys()].map((index) => (
          <MenuItem key={index} value={index - 5}>
            {index - 5 === 0 ? "Today" : `${index - 5 > 0 ? "+" : ""}${index - 5} days`}
          </MenuItem>
        ))}
      </Select>
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
