import React, { useState, useEffect } from "react";
// import { findPets } from "../../services/PetServices";
// import { findSecurities } from "../../services/SecurityServices"
import { DataGrid } from '@mui/x-data-grid';
import { Box } from "@mui/material";


export const HomePage = () => {
    const [securities, setSecurities] = useState([]);

    // useEffect(() => {
    //   findSecurities()
    //         .then(({data}) => {
    //         setSecurities(data);
    //         });
    // }, []);
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
    const rowDefDev = [{
            id: 1, 
            couponPercent: 2,
            bondCurrency: 'USD',
            cusip: 1234,
            faceValue: '$400',
            isin: 5678,
            issuerName: 'US GOV',
            bondMaturityDate: '08/02/2023',
            status: 'Active',
            type: 'Bond'
    },
    {
        id: 2, 
        couponPercent: 2,
        bondCurrency: 'USD',
        cusip: 1234,
        faceValue: '$400',
        isin: 5678,
        issuerName: 'US GOV',
        bondMaturityDate: '08/03/2023',
        status: 'Active',
        type: 'Bond'
}]
    // securities.map(security => 
    //   rowDef.push({
    //         id: security.id, 
    //         couponPercent: security.couponPercent,
    //         bondCurrency: security.bondCurrency,
    //         cusip: security.cusip,
    //         faceValue: security.faceValue,
    //         isin: security.isin,
    //         issuerName: security.issuerName,
    //         bondMaturityDate: security.bondMaturityDate,
    //         status: security.status,
    //         type: security.type
    //     })
    // )


  return (
    <>
          <Box sx={{ height: 400, width: '75%'}}>
            <DataGrid
              rows={rowDefDev}
              columns={columnDef}
              />
          </Box>
        
    </>
  )
};
