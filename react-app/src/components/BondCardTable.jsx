import React, { useEffect } from 'react';
import Paper from '@mui/material/Paper';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import { useNavigate } from 'react-router-dom';
import { useState } from 'react';
const columns = [
  { id: 'type', label: 'Type', minWidth: 170 },
  { id: 'issuerID', label: 'Bonds Mature', minWidth: 50 },
];

const typeOfBonds =  { CORP: 0, GOVN:0, SOVN: 0}

export default function BondCardTable({ bond }) {
  const navigate = useNavigate();
  const dataRows = bond ? [bond] : [];
  const [sortOrder, setSortOrder] = useState('asc');
  const [sortColumn, setSortColumn] = useState('name');

  const showBonds = (id) => {
    console.log(id);
    navigate("/home/zoombond");
  };

  
  const handleSort = (column) => {
    if (column === sortColumn) {
      setSortOrder(sortOrder === 'asc' ? 'desc' : 'asc');
    } else {
      setSortColumn(column);
      setSortOrder('asc');
    }
  };

  
  return (
    <Paper sx={{ width: '100%', overflow: 'hidden' }}>
      <TableContainer sx={{ maxHeight: 440 }}>
        <Table stickyHeader aria-label="sticky table">
          <TableHead>
            <TableRow>
              {columns.map((column) => (
                <TableCell key={column.id} align={column.align} style={{ minWidth: column.minWidth }}  onClick={() => handleSort('name')}>
                  {column.label}  
                </TableCell>
              ))}
            </TableRow>
          </TableHead>
          <TableBody>
      {Object.entries(typeOfBonds).map(([key, value]) => (
        <TableRow hover role="checkbox" tabIndex={-1} key={key}>
            <TableCell>
              {key}
            </TableCell>
            <TableCell 
              onClick={ () => showBonds(value)}
              style={{
                cursor: 'pointer' ,
                color:  'red' 
              }}
              >
              {bond[key] ? bond[key]: 0}
            </TableCell>
          {/* {columns.map((column) => (
            <TableCell
              key={column.id}
              align={column.align}
             // onClick={column.id === 'key' ? () => showBonds(row[column.id]) : null}
              style={{
                cursor: column.id === 'key' ? 'pointer' : 'default',
                color: column.id === 'key' ? 'red' : 'black',
              }}
            >
              {column.id === 'key' ? value : value}
            </TableCell>
          ))} */}
        </TableRow>
      ))}
    </TableBody>
        </Table>
      </TableContainer>
    </Paper>
  );
}
