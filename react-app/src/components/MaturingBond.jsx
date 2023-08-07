import React from 'react'
import MaturingBondsList, { formatDate } from './MaturingBondsList';
import moment from 'moment';

const MaturingBond = (props) => {
  const date = new Date(props.info.date);


  return (
    <div className="container">
      <header className={'my-3 p-2 bg-${props.info.color} text-white'} style={{backgroundColor: props.info.color}}>
        <h3 className="mb-0">{moment(date).format('MMM DD, YYYY')}</h3>
      </header>
      <MaturingBondsList props={props} />
    </div>
  )
}

export default MaturingBond