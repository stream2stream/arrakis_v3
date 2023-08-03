import React from 'react'
import BondDetail from './BondDetail';
import { getBondsByDate } from '../../services/BondServices';

const MaturingBondsList = (props) => {
    const bonds = getBondsByDate(props);

    return (
      bonds.map(bond => (
        <>
          <BondDetail info={bond} key={bond.isin.toString()} />
        </>
      ))
    )
}

export default MaturingBondsList