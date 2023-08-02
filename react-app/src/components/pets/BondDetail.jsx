import React from 'react'

const BondDetail = (props) => {
  return (
    <div>
        <h1>{props.info.issuerName}</h1>
        <p>Face Value: {props.info.faceValue}</p>
        <p>Coupoon: {props.info.couponPercent}</p>
        <p>Maturity Date: {props.info.maturityDate}</p>
        <p>ISIN: {props.info.isin}</p>
            
    
    </div>
  )
}

export default BondDetail


//isin, issuer_name, bond_maturity_date, coupon_percent, face_value