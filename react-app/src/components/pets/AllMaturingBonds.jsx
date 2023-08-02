import React from 'react'
import MaturingBond from './MaturingBonds';

const AllMaturingBonds = () => {

    const allBondLists = getBondsByDates(); //list of list 

    return (
        allBondLists.map(bondList =>(
            <BondDetail info={bondList} key={bondList.isin.toString()} />
        ))
      )
}

export default AllMaturingBonds