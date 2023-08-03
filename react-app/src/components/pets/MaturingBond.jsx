import React from 'react'
import { getBondsByDate } from '../../services/BondServices';
import BondDetail from './BondDetail';
import MaturingBondsList from './MaturingBondsList';

const MaturingBond = (props) => {
  console.log(props.info.date)
  const date = new Date(props.info.date);
  return (
    <>
      <h3>{date.toString()}</h3>
      <MaturingBondsList props={props}/>
    </>
  )


}

export default MaturingBond