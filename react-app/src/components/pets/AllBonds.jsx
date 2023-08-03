import React from 'react'
import BondDetail from './BondDetail'
import { getAllBonds } from '../../services/BondServices'
import { useState } from 'react'
import { useEffect } from 'react'


const AllBonds = () => {
  const [bonds, setBonds] = useState([]);

  useEffect(() => {
    getBondsFromAPI();
  },
    []
  );

  const getBondsFromAPI = () => {
    getAllBonds()
      .then(res => {
        setBonds(res.data);
        console.log(res);
      })
      .catch(err => {
        setBonds([]);
        console.log(err);
      })
  }

  const formatDate = (timestamp) => {
    const date = new Date(timestamp);
    const formattedDate = date.toLocaleDateString();
    return formattedDate;
  }

  return (
    // bonds.map(bond =>(
    //     <BondDetail info={bond} key={bond.isin.toString()} />
    // ))
    <table>
      <thead>
        <th>ISIN</th>
        <th>Type</th>
        <th>Issuer</th>
        <th>Maturity</th>
        <th>Face Value</th>
        <th>Currency</th>
        <th>Coupon %</th>
        <th>Status</th>
      </thead>
      <tbody>
        {bonds.map((row, index) => (
          <tr key={index}>
            <td>{row.isin}</td>
            <td>{row.type}</td>
            <td>{row.issuerName}</td>
            <td>{formatDate(row.bondMaturityDate)}</td>
            <td>{row.faceValue}</td>
            <td>{row.bondCurrency}</td>
            <td>{row.couponPercent}</td>
            <td>{row.status}</td>
          </tr>
        ))}

      </tbody>
    </table>
  )
}

export default AllBonds