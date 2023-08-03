import React, { useState, useEffect } from "react";
import { findUpcoming } from "../services/UpcomingServices";
import { DataGrid } from '@mui/x-data-grid';
import { Box, TextField } from "@mui/material";
import styles from "./pets/Pets.module.css";
import { Button } from "@mui/material";


export const UpcomingPage = () => {
    const [securities, setSecurities] = useState([]);
    const [date, setDate] = useState("");
    const [dateFinal, setDateFinal] = useState("");


    const handleDateInput = (event) => {
        setDate(event.target.value);
    }

    const handleSubmit = () => {
        console.log(date)
        setDateFinal(date)
    }

    useEffect(() => {
      findUpcoming(dateFinal)
            .then(({data}) => {
            setSecurities(data);
            });
    }, [dateFinal]);
    const columnDef = [
      {field: 'id', headerName: 'ID', flex: 1},
      {field: 'couponPercent', headerName: 'Coupon %'},
      {field: 'bondCurrency', headerName: 'Currency'},
      {field: 'cusip', headerName: 'CUSIP', flex: 1},
      {field: 'bondCurrency', headerName: 'Currency', flex: 1},
      {field: 'faceValue', headerName: 'Face Value', flex: 1},
      {field: 'isin', headerName: 'ISIN'},
      {field: 'issuerName', headerName: 'Issuer'},
      {field: 'bondMaturityDate', headerName: 'Maturity Date', flex: 1},
      {field: 'status', headerName: 'Status', flex: 1},
      {field: 'type', headerName: 'Type', flex: 1}
    ]

    const rowDef = []
    securities.map(security => 
      rowDef.push({
            id: security.id, 
            couponPercent: security.couponPercent,
            bondCurrency: security.bondCurrency,
            cusip: security.cusip,
            faceValue: security.faceValue,
            isin: security.isin,
            issuerName: security.issuerName,
            bondMaturityDate: security.bondMaturityDate,
            status: security.status,
            type: security.type
        })
    )

  return (
    <>
        <div className={styles.container}>
        <TextField
         sx = {{ 'display': 'flex', 'flex-direction': 'row', 'justify-content': 'space-around', 'content-align': 'center'}}
         id="standard-basic" 
         variant="standard" 
         type="search"
         defaultValue={"DD/MM/YYYY"}
        //  value={date}
         onChange={handleDateInput}
         />
         <Button variant="contained" color="primary" onClick={handleSubmit}>
            Submit
         </Button>
        </div>
        <Box sx={{ height: '100%', width: '100%'}}>
            <div className={styles.container}>
                <DataGrid
                    rows={rowDef}
                    columns={columnDef}
                    sx={{ maxWidth: '75%' }}
                    maxColumns={6}
                    />
            </div>
        </Box>   
    </>
  );
};
