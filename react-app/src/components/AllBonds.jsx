import React from 'react'
import BondDetails from './BondDetails'
import { useState } from 'react';
import { useEffect } from 'react';
import {getAllBonds} from '../services/bond-service';




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
  "maturity":15/10/2023,
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
  "maturity":15/10/2023,
  "faceValue": 10.33,
  "currency": "USD",
  "coupon":1,
  "status":"Active"


}
]

  return (
    <div>
      <BondDetails data={bonds2}></BondDetails>
    </div>
    
  )
}

export default AllBonds



