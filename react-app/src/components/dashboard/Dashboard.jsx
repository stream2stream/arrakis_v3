import React, { useState, useEffect } from "react";
import {DataGrid} from '@mui/x-data-grid';

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
    return (
        <>
        <h1>Bond Dashboard</h1>
        <div>
            <DataGrid rows={rows} columns={cols}/>
        </div>
        </>
    )
}