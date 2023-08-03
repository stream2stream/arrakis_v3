import React from 'react'
import MaturingBondsList from './MaturingBondsList';

const MaturingBond = (props) => {
  const date = new Date(props.info.date);
  return (
    <>
      <h3>{date.toString()}</h3>
      <MaturingBondsList props={props}/>
    </>
  )


}

export default MaturingBond