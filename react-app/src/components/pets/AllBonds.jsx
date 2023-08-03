import React from 'react'
import BondDetail from './BondDetail'
import { getAllBonds } from '../../services/BondServices'

const AllBonds = () => {
  var bonds = getAllBonds();

  return (
    bonds.map(bond =>(
        <BondDetail info={bond} key={bond.isin.toString()} />
    ))
  )
}

export default AllBonds