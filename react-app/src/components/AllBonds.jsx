import React from 'react'
import BondDetails from './BondDetails'
import { useState } from 'react';
import { useEffect } from 'react';
import { getAllBonds } from '../services/bond-service';

const AllBonds = () => {

  const [bonds, setBonds] = useState([]);

  useEffect(() => {
    getBondsFromAPI();
  }, []
  );

  const getBondsFromAPI = () => {

  getAllBonds()
  .then(res => {
    setBonds(res.data);
  })
  .catch(err => {
    setBonds([]);
  })

  }
  
  return (
    <div>
      <BondDetails data={bonds}></BondDetails>
    </div>
  )
}

export default AllBonds