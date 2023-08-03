import React, { useEffect } from 'react'
import MaturingBond from './MaturingBonds';
import { getBondsByDates } from '../../services/BondServices';
import { getAuth } from 'firebase/auth';
import { useNavigate } from 'react-router-dom'
import { useState } from 'react';

const AllMaturingBonds = (props) => {
    const navigate = useNavigate();
    const [user, setUser] = useState(props.user);
  
    useEffect(() => {
      console.log(props)
      //if (!user) {
        // Route to NotAuthroized
        //navigate("/notauthorized");
      //}
    });

    const arr = [-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5]; //list of list 
    const date = Date.parse("05/07/2021");

    return (
        arr.map(num =>( 
            <MaturingBond info={{date:date+(num*86400000)}} key={num} />
        ))
      )
}

export default AllMaturingBonds