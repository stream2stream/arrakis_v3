import React from 'react'
import { getAllBonds } from '../../services/BondServices'
import '../../App.css'

const BondDetail = (props) => {
  var bonds = getAllBonds();
  return (
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
            <td>{row.coupon_percent}</td>
          </tr>
        ))}

      </tbody>
    </table>

    // <div>
    //     <h1>{props.info.issuerName}</h1>
    //     <p>Face Value: {props.info.faceValue} &emsp; Coupon: {props.info.couponPercent} &emsp; Maturity Date: {props.info.bondMaturityDate} &emsp; ISIN: {props.info.isin}</p>
    // </div>
  )
}

export default BondDetail


//isin, issuer_name, bond_maturity_date, coupon_percent, face_value