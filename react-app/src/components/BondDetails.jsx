import React from 'react'
import BondTable  from './BondTable'

const BondDetails = ({data}) => {
  return (
    <div>
      <BondTable data={data}></BondTable>
    </div>
  )
}

export default BondDetails
