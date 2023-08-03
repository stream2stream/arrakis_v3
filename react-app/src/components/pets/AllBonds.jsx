import React, { useEffect } from 'react'
import BondDetail from './BondDetail'
import { getAllBonds } from '../../services/BondServices'
import { getAuth } from 'firebase/auth';
import { useNavigate } from 'react-router-dom'

const AllBonds = () => {

  const navigate = useNavigate();
    const auth = getAuth();
    const user = auth.currentUser;

    useEffect(() => {
        if(!user) {
            // Route to NotAuthroized
            navigate("/notauthorized");
        }
    });

  var bonds = getAllBonds();
  return (
    bonds.map(bond =>(
        <BondDetail info={bond} key={bond.isin.toString()} />
    ))
  )
}

export default AllBonds