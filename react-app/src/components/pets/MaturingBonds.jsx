import React from 'react'

const MaturingBond = (props) => {
  const todayBonds = getBondsByDate(props);

  return (
    todayBonds.map(bond =>(
        <BondDetail info={bond} key={bond.isin.toString()} />
    ))
  )


}

export default MaturingBond