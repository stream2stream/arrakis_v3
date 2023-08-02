import React from 'react'
import MaturingBond from './MaturingBonds';
import { getBondsByDates } from '../../services/BondServices';

const AllMaturingBonds = () => {

    const arr = [-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5]; //list of list 
    const date = Date.parse("04/06/2021");

    return (
        arr.map(num =>(
            <MaturingBond info={date+num} key={num} />
        ))
      )
}

export default AllMaturingBonds