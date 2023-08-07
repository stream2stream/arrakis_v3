import React from 'react'
import AllSecurities from './AllSecurities'
import Trades from '../trade/Trades'

const Securities = () => {
  return (
    <>
      <div className='securities-container'>

        <div className='hot-all-securities'>
          <div className='hot-securities-container'>
          <h5> Hot Securities</h5>
              <AllSecurities all={false}/>
          </div>

          <div className='all-securities-container'>
            <h5> All Securities</h5>
              <AllSecurities all={true} />
          </div>
        </div>

        <div className='securities-trade-container'>
          <h5> Trades </h5>
          <Trades />
        </div>

      </div>
    </>
  )
}

export default Securities