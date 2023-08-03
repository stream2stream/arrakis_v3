import React from 'react';
import Paper from '@mui/material/Paper';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import { useNavigate } from 'react-router-dom';

const columns = [
  { id: 'type', label: 'Type', minWidth: 170 },
  { id: 'issuerID', label: 'Issuer ID', minWidth: 50 },
];

export default function BondCardTable({ bond }) {
  const navigate = useNavigate();
  const dataRows = bond ? [bond] : [];

  const showBonds = (id) => {
    console.log(id);
    navigate("/home/zoombond");
  };

  return (
    <Paper sx={{ width: '100%', overflow: 'hidden' }}>
      <TableContainer sx={{ maxHeight: 440 }}>
        <Table stickyHeader aria-label="sticky table">
          <TableHead>
            <TableRow>
              {columns.map((column) => (
                <TableCell key={column.id} align={column.align} style={{ minWidth: column.minWidth }}>
                  {column.label}
                </TableCell>
              ))}
            </TableRow>
          </TableHead>
          <TableBody>
            {dataRows.map((row, index) => (
              <TableRow hover role="checkbox" tabIndex={-1} key={index}>
                {columns.map((column) => (
                  <TableCell 
                    key={column.id} 
                    align={column.align} 
                    onClick={column.id =='issuerID'? ()=> showBonds(row[column.id]): null}
                    style={{ cursor: column.id =='issuerID'? 'pointer': 'default',
                    color: column.id =='issuerID'? 'red': 'black' }}
                  >
                    {row[column.id]}
                  </TableCell>
                ))}
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </Paper>
  );
}
