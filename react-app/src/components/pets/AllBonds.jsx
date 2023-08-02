import React from 'react'
import BondDetail from './BondDetail'

const AllBonds = () => {
  return (
    bonds.map(hero=>(
        <BondDetail info={bond} key={bond.isin.toString()} />
    ))
  )
}

export default AllBonds