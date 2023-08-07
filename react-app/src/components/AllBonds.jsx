import React from 'react'
import BondDetails from './BondDetails'
import { useState } from 'react';
import { useEffect } from 'react';
import { getAllBonds } from '../services/bond-service';




const AllBonds = () => {

const [bonds,setBonds] = useState([]);

useEffect(()=>{
  getBondsFromAPI();}, 
  []
);



const getBondsFromAPI = ()=>{

  getAllBonds()
  .then(res => {
    console.log('data returned from Springboot get API')
   
      setBonds(res.data);
  })
  .catch(err => {
    console.log('when no data returned from Springboot get API')
      setBonds([]);
      console.log(err);
  })

}
const bonds2 = [{
  "id":1,
  "isin":100,
  "type":"Sell",
  "issuer":"Someone",
  "maturity":"10-10-2023",
  "faceValue": 10.33,
  "currency": "USD",
  "coupon":1,
  "status":"Active"


},

{
  "id":2,
  "isin":200,
  "type":"Sell",
  "issuer":"Someone",
  "maturity":"15-10-2023",
  "faceValue": 10.33,
  "currency": "USD",
  "coupon":1,
  "status":"Active"


},
{
    "id":3,
    "isin":300,
    "type":"Sell",
    "issuer":"Someone",
    "maturity":"11-10-2023",
    "faceValue": 10.33,
    "currency": "USD",
    "coupon":1,
    "status":"Active"
  
  
  },
  {
    "id":4,
    "isin":400,
    "type":"Sell",
    "issuer":"Someone",
    "maturity":"5-10-2023",
    "faceValue": 10.33,
    "currency": "USD",
    "coupon":1,
    "status":"Active"
  
  
  },
  {
    "id":5,
    "isin":500,
    "type":"Sell",
    "issuer":"Someone",
    "maturity":"15-10-2023",
    "faceValue": 10.33,
    "currency": "USD",
    "coupon":1,
    "status":"Active"
  
  
  },
  {
    "id":6,
    "isin":600,
    "type":"Sell",
    "issuer":"Someone",
    "maturity":"25-10-2023",
    "faceValue": 10.33,
    "currency": "USD",
    "coupon":1,
    "status":"Active"
  
  
  },
  {
    "id":7,
    "isin":700,
    "type":"Sell",
    "issuer":"Someone",
    "maturity":"15-10-2023",
    "faceValue": 10.33,
    "currency": "USD",
    "coupon":1,
    "status":"Active"
  
  
  },
  {
    "id":8,
    "isin":800,
    "type":"Sell",
    "issuer":"Someone",
    "maturity":"15-10-2023",
    "faceValue": 10.33,
    "currency": "USD",
    "coupon":1,
    "status":"Active"
  
  
  }
]

  return (
    <div>
      <BondDetails data={bonds}></BondDetails>
    </div>
    
  )
}

export default AllBonds