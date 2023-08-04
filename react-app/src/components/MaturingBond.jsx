import React from 'react'
import MaturingBondsList from './MaturingBondsList';
import moment from 'moment';

const MaturingBond = (props) => {
  const date = new Date(props.info.date);
  return (
      <div className="container">
          <h3 className="my-3">{moment(date).format('MMM DD, YYYY')}</h3>
          <MaturingBondsList props={props}/>
      </div>
  )
}

export default MaturingBond