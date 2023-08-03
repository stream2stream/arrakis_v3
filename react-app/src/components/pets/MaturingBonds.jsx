import React from 'react'
import { getBondsByDate } from '../../services/BondServices';
import BondDetail from './BondDetail';
import MaturingBondsList from './MaturingBondsList';

const MaturingBond = (props) => {
  console.log(props.info.date)
  const date = new Date(props.info.date);
  return (
      <div className="container">
          <h3 className="my-3">{date.toString()}</h3>
          <MaturingBondsList props={props}/>
      </div>
  )
}

export default MaturingBond