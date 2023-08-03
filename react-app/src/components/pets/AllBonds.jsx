import React, { useEffect } from 'react'
import BondDetail from './BondDetail'
import { getAllBonds } from '../../services/BondServices'
import { getAuth } from 'firebase/auth';
import { useNavigate } from 'react-router-dom'
import { useState } from 'react';

const AllBonds = (props) => {
  const navigate = useNavigate();
  const [user, setUser] = useState(props.user);

  useEffect(() => {
    console.log(props)
    //if (!user) {
      // Route to NotAuthroized
      //navigate("/notauthorized");
    //}
  });

  var bonds = getAllBonds();
  return (
    bonds.map(bond => (
      <BondDetail info={bond} key={bond.isin.toString()} />
    ))
  )
}

export default AllBonds