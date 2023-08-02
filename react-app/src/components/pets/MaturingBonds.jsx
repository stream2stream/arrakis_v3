import React from 'react'
import { getBondsByDate } from '../../services/BondServices';
import BondDetail from './BondDetail';

const MaturingBond = (props) => {
  const bonds = getBondsByDate(props);

  return (
    bonds.map(bond => (
      <>
        <h3>{props}</h3>
        <BondDetail info={bond} key={bond.isin.toString()} />
      </>
    ))
  )


}

export default MaturingBond