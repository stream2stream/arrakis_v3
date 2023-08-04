
import React from 'react';

const BondTable = ({ data }) => {
  return (
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
        {data.map((index) => (
           <tr key={index.id}>
       <td >{index.isin}</td> 
           <td>{index.type}</td>
           <td>{index.issuer}</td>
           <td>{index.maturity}</td>

           <td>{index.faceValue}</td>
           <td>{index.currency}</td>
           <td>{index.coupon}</td>
           <td>{index.status}</td>
         </tr>
        ))}
      </tbody>
    </table>
  );
};

export default BondTable;