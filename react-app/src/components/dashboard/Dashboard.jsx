import React, { useState, useEffect } from "react";
import { DataGrid } from '@mui/x-data-grid';
import { Button } from "@mui/material";

export const Dashboard = () => {
    const rows = [
        {id: 1, name: "Brion", favoriteFood: "snowcrab"},
        {id: 2, name: "Bjorn", favoriteFood: "chicken parmesan"}
    ];

    const cols = [
        {field: "id", headerName: "ID", width: 150},
        {field: "name", headerName: "Name", width: 150},
        {field: "favoriteFood", headerName: "Food of Favorite", width: 150}
    ];

//    const [data, setData] = useState([]);

    const handleSubmit = (event) => {
        event.preventDefault();
        window.location.href="http://localhost:3000/";
    }

//    useEffect(() => {
//        getBondData()
//              .then(({data}) => {
//              setData(data);
//              });
//    }, []);

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
        </>
    )
}