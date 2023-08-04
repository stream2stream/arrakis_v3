import React, { useState, useEffect } from "react";
import { DataGrid } from '@mui/x-data-grid';
import { Button } from "@mui/material";
import { getAllTrades } from "../../services/DashboardService";

export const Dashboard = () => {
    /*function formatJSON(currency,quantity,unit_price,buy_sell,book_name,counter_party_name,isin,cusip,issuer_name,maturity_date,coupon,type,face_value,security_currency,status,trade_date,settlement_date) {
        var formattedData = [],
        const jsonList = Object.values(data).map(({currency,quantity,unit_price,buy_sell,book_name,counter_party_name,isin,cusip,issuer_name,maturity_date,coupon,type,face_value,security_currency,status,trade_date,settlement_date}) => (

        ))
    }*/

    /*function formatJSON(data) {
        const formattedData = [];
        for (const jsonString of data) {
            try {
                const parsedObject = JSON.parse(jsonString);
                formattedData.push(parsedObject);
            } catch {
                console.error("Error parsing JSON: ", error);
            }
        }
        return formattedData;
    }

    const parsedObjects = formatJSON(data);

    const currency = 
    {field: "quantity
    {field: "unit_price
    {field: "book_name
    {field: "counter_party_name
    {field: "isin
    {field: "cusip
    {field: "issuer_name
    {field: "maturity_date
    {field: "coupon
    {field: "type
    {field: "face_value
    {field: "security_currency
    {field: "status
    {field: "trade_date
    {field: "settlement_date*/

    /*function parseJSONObjects(data) {
        const dataList = [];
        for (const jsonString of data) {
            try {
                const parsedObject = JSON.parse(jsonString);
                const row = [parsedObject]
            } catch {

            }
        }
    }*/

    const [data, setData] = useState([]);

    const handleSubmit = (event) => {
        event.preventDefault();
        window.location.href="http://localhost:3000/";
    }

    useEffect(() => {
        getAllTrades()
              .then(({data}) => {
              setData(data);
              });
    }, []);

    

    const rows = [
        {id: data.id, currency: data.currency,quantity: 1,unit_price: 900,buy_sell: "BUY",book_name: "TRADING_BOOK_X",counter_party_name: "ABC International",isin: "asduhasd",cusip: "12x812s2",issuer_name: "SomeCorporation",maturity_date: "2025-03-21",coupon: "5.00",type: "CORP",face_value: 1000,security_currency: "USD",status: "ACTIVE",trade_date: "2023-07-03",settlement_date: "2023-07-01"}
    ];

    const cols = [
        {field: "currency", headerName: "Currency", width: 150},
        {field: "quantity", headerName: "Quantity", width: 150},
        {field: "unit_price", headerName: "Unit Price", width: 150},
        {field: "buy_sell", headerName: "Buy / Sell", width: 150},
        {field: "book_name", headerName: "Trading Book", width: 150},
        {field: "counter_party_name", headerName: "Counter Party", width: 150},
        {field: "isin", headerName: "ISIN", width: 150},
        {field: "cusip", headerName: "CUSIP", width: 150},
        {field: "issuer_name", headerName: "Bond Issuer", width: 150},
        {field: "maturity_date", headerName: "Maturity Date YYYY-MM-DD", width: 150},
        {field: "coupon", headerName: "Coupon%", width: 150},
        {field: "type", headerName: "Bond Type", width: 150},
        {field: "face_value", headerName: "Face Value", width: 150},
        {field: "security_currency", headerName: "Security Currency", width: 150},
        {field: "status", headerName: "Status", width: 150},
        {field: "trade_date", headerName: "Trade Date YYYY-MM-DD", width: 150},
        {field: "settlement_date", headerName: "Settlement Date YYYY-MM-DD", width: 150},
    ];

    

    return (
        <>
        <h1>Bond Dashboard</h1>
        <div>
            <DataGrid rows={rows} columns={cols}
                sx={{
                    m:5,
                    boxShadow: 2,
                    border: 2,
                    borderColor: 'grey.500',
                    '& .MuiDataGrid-cell:hover': {
                    color: 'primary.main',
                    },
                }}
            />
            <Button variant="contained" onClick={handleSubmit}>Logout</Button>
        </div>
        <div>
            {/* Display tradesData and booksData in your component */}
            <h2>Trades Data:</h2>
            <pre>{JSON.stringify(data, null, 2)}</pre>
        </div>
        </>
    )
}