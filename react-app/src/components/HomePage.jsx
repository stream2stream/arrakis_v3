import React from 'react'
import BondCard from './BondCard'

const HomePage = () => {
  let bonds = ["bond 1", "bond 2", "bond 3", "bond 4"]
  return (
    <div>HomePage
        <BondCard bonds = {bonds}/>
    </div>
  )
}

export default HomePage