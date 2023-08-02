import React, { useState, useEffect } from "react";
import { findPets } from "../../services/PetServices";
import styles from "./Pets.module.css";
import { DataGrid } from '@mui/x-data-grid';
import { Box } from "@mui/material";


export const Pets = () => {
    const [pets, setPets] = useState([]);

    useEffect(() => {
      findPets()
            .then(({data}) => {
            setPets(data);
            });
    }, []);
    const columnDef = [
      {field: 'id', headerName: 'ID'},
      {field: 'name', headerName: 'Name'},
      {field: 'age', headerName: 'Age'}
    ]

    const rowDef = []
    pets.map(pet => 
      rowDef.push({id: pet.id, name: pet.name, age: pet.age})
      )


  return (
    <>
          <Box sx={{ height: 400, width: '100%'}}>
            <DataGrid
              rows={rowDef}
              columns={columnDef}
              />
          </Box>
        
    </>
  )
};
