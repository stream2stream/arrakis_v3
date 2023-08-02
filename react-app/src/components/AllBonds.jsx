import React from 'react'
import BondDetails from './BondDetails'




const Bonds = () => {

  
const bonds = {
  "isin":1,
  "Type":"Sell",
  "issuer":"Someone",
  "superpower":"Martial Arts",
  "Maturiry":15/10/2023,
  "FaceValue": 10.33,
  "Currency": "USD",
  "Coupon %":1,
  "status":"Active"


}

  return (
    <BondDetails info={bonds}></BondDetails>
  )
}

export default Bonds
