import React, { useState, useEffect } from "react";
// import { findPets } from "../../services/PetServices";
import { findSecurities } from "../services/SecurityServices";
import { DataGrid } from '@mui/x-data-grid';
import { Box } from "@mui/material";
import { Card } from "@mui/material";
import CardContent from "@mui/material";
import Typography from "@mui/material";
import styles from "./pets/Pets.module.css";


export const HomePage = () => {
    const [securities, setSecurities] = useState([]);

    useEffect(() => {
      findSecurities()
            .then(({data}) => {
            setSecurities(data);
            });
    }, []);
    const columnDef = [
      {field: 'id', headerName: 'ID'},
      {field: 'couponPercent', headerName: 'Coupon %'},
      {field: 'bondCurrency', headerName: 'Currency'},
      {field: 'cusip', headerName: 'CUSIP'},
      {field: 'faceValue', headerName: 'Face Value'},
      {field: 'isin', headerName: 'ISIN'},
      {field: 'issuerName', headerName: 'Issuer'},
      {field: 'bondMaturityDate', headerName: 'Maturity Date'},
      {field: 'status', headerName: 'Status'},
      {field: 'type', headerName: 'Type'}
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
          <Box sx={{ height: '100%', width: '100%'}}>
            <div className={styles.container}>
            <DataGrid
              rows={rowDef}
              columns={columnDef}
              sx={{ maxWidth: '75%' }}
              />
            <Card sx={{ minWidth: '25%'}}>
                Hello
            </Card>
            </div>
          </Box>
        
    </>
  )
};
