import React from 'react'
import { getBondsByDate } from '../../services/BondServices';
import BondDetail from './BondDetail';

const MaturingBond = (props) => {

  return (
    props.map(bond =>(
        <BondDetail info={bond} key={bond.isin.toString()} />
    ))
  )


}

export default MaturingBond