import React from 'react'
import MaturingBondsList from './MaturingBondsList';

const MaturingBond = (props) => {
  const date = new Date(props.info);
  return (
      <div className="container">
          <h3 className="my-3">{date.toString()}</h3>
          <MaturingBondsList props={props}/>
      </div>
  )
}

export default MaturingBond