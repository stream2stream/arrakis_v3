import React from 'react'
import BondDetail from './BondDetail'
import { getAllBonds} from '../../services/BondServices'
import { useState } from 'react'
import { useEffect } from 'react'


const AllBonds = () => {
  const [bonds, setBonds] = useState([]);

  useEffect(()=>{
    getBondsFromAPI();},
    []
  );

  const getBondsFromAPI = ()=>{
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

  return (
    // bonds.map(bond =>(
    //     <BondDetail info={bond} key={bond.isin.toString()} />
    // ))
    <table>
      <thead>
        <th>ISIN</th>
        <th>Face Value</th>
        <th>Coupon %</th>
      </thead>
      <tbody>
        {bonds.map((row, index) => (
          <tr key={index}>
            <td>{row.isin}</td>
            <td>{row.faceValue}</td>
            <td>{row.faceValue}</td>
            <td>{row.coupon_percent}</td>
          </tr>
        ))}

      </tbody>
    </table>
  )
}

export default AllBonds