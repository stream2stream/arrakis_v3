import React from 'react'
import MaturingBond from './MaturingBond';
import { getBondsByDates } from '../../services/BondServices';

const AllMaturingBonds = () => {

    const arr = [-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5]; //list of list 
    const date = Date.parse("2020/01/01");
    const date = moment("2020/01/01").format('YYYY/MM/DD')
    DateFormat 
    console.log(date);



    return (
        arr.map(num =>( 
            <MaturingBond info={{date:date+(num*86400000)}} key={num} />
        ))
      )
}

export default AllMaturingBonds