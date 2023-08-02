import React from 'react'
import MaturingBond from './MaturingBonds';
import { getBondsByDates } from '../../services/BondServices';

const AllMaturingBonds = () => {

    const allBondLists = getBondsByDates(); //list of list 

    return (
        allBondLists.map(bondList =>(
            <MaturingBond info={bondList} key={bondList.isin.toString()} />
        ))
      )
}

export default AllMaturingBonds