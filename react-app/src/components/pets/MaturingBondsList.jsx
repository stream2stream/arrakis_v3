import React from 'react'
import BondDetail from './BondDetail';
import { getBondsByDate } from '../../services/BondServices';

const MaturingBondsList = (props) => {
  const bonds = getBondsByDate(props);

  return (
      <div className="container">
          {bonds.map(bond => (
              <BondDetail info={bond} key={bond.isin.toString()} />
          ))}
      </div>
  )
}

export default MaturingBondsList