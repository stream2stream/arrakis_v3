import React, { useEffect, useState } from 'react';
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper } from '@mui/material';
import axios from 'axios';
import NavBar from '../../components/NavBar/NavBar';

const UserBonds = () => {

    const [bondsData, setBondsData] = useState([]);
    const loggedInUser = localStorage.getItem('loggedInUser');

    useEffect(() => {
        if (loggedInUser) {
    
          axios.post(`http://localhost:8080/api/v1/bonds/user?userMail=${loggedInUser}`)
            .then((response) => {
                console.log('Response Data:', response.data); 
              setBondsData(response.data);
            })
            .catch((error) => {
              console.error('Error in backend call:', error);
            });
        }
    }, [loggedInUser]);


  return (
    <>
    <NavBar/>
    <TableContainer component={Paper}>
    <Table>
      <TableHead>
        <TableRow>
          <TableCell>ID</TableCell>
          <TableCell>ISIN</TableCell>
          <TableCell>Issuer Name</TableCell>
          <TableCell>Maturity Date</TableCell>
          <TableCell>Coupon</TableCell>
          <TableCell>Type</TableCell>
          <TableCell>Face Value</TableCell>
          <TableCell>Currency</TableCell>
          <TableCell>Status</TableCell>
        </TableRow>
      </TableHead>
      <TableBody>
        {bondsData.map((bond) => (
          <TableRow key={bond.id}>
            <TableCell>{bond.id}</TableCell>
            <TableCell>{bond.isin}</TableCell>
            <TableCell>{bond.issuerName}</TableCell>
            <TableCell>{bond.maturityDate}</TableCell>
            <TableCell>{bond.coupon}</TableCell>
            <TableCell>{bond.type}</TableCell>
            <TableCell>{bond.faceValue}</TableCell>
            <TableCell>{bond.currency}</TableCell>
            <TableCell>{bond.status}</TableCell>
          </TableRow>
        ))}
      </TableBody>
    </Table>
  </TableContainer>
  </>

  )
}

export default UserBonds