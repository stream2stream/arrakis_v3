import React from 'react'
import { getAllBonds } from '../../services/BondServices'
import '../../App.css'

const BondDetail = (props) => {
  return (
    
    <div>
        <h1>{props.info.issuerName}</h1>
        <p>Face Value: {props.info.faceValue} &emsp; Coupon: {props.info.couponPercent} &emsp; Maturity Date: {props.info.bondMaturityDate} &emsp; ISIN: {props.info.isin}</p>
    </div>
  )
}

export default BondDetail


//isin, issuer_name, bond_maturity_date, coupon_percent, face_value