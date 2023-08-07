import React from 'react'
import AllSecurities from './AllSecurities'
import Trades from '../trade/Trades'

const Securities = (props) => {
  return (
    <>
      <div className='securities-container'>

        <div className='hot-all-securities'>
          <div className='hot-securities-container'>
            <h5> Hot Securities</h5>
              <AllSecurities info={props.info} allFilters={false}/>
          </div>

          <div className='all-securities-container'>
            <h5> All Securities</h5>
              <AllSecurities info={props.info} allFilters={true}/>
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