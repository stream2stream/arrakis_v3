import React from 'react'
import BondDetail from './BondDetail'

const AllBonds = (props) => {

  return (
    props.map(bond =>(
        <BondDetail info={bond} key={bond.isin.toString()} />
    ))
  )
}

export default AllBonds