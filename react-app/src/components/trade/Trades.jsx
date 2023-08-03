import React from 'react'
import { useState, useEffect } from 'react'
import { TradeDetail } from './TradeDetail'
import Table from 'react-bootstrap/Table';

const dummy = [
  {
      id:'id',
      isin : 111,
      bookId : 'book 22',
      counterParty: 'shell',
      status: 'open',
      quantity: 3,
      unitPrice: 10,
      currency: 'USD',
      buySell: 'sell',
      tradeDate: '03.04.2023',
      settlementDate: '03.06.2024'

  }   
]

const Trades = () => {
  return (
    <div className='trades-table-container'>
        <Table striped bordered hover className='trades-table'>
            <thead>
                <tr>
                    <th>ISIN</th>
                    <th>Book Id</th>
                    <th>Client</th>
                    <th>Status</th>
                    <th>Quantity</th>
                    <th>unit Price</th>
                    <th>Currency</th>
                    <th>Buy/Sell</th>
                    <th>Trade Date</th>
                    <th>Settlement Date</th>
                </tr>
                
            </thead>
            <tbody>
                {
                    dummy.map(trade => (
                        < TradeDetail info={trade} key={trade.id} />
                    ))
                }
                <tr>
                    <td>1</td>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                </tr>
            </tbody>
        </Table>
        </div>
    )
}

export default Trades