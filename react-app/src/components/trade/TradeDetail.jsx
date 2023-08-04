import React from 'react'

export const TradeDetail = (props) => {
    return (
        <tr>
            {/* <td>{props.info.isin}</td> */}
            <td>{props.info.book_id} </td>
            <td>{props.info.counterparty_id}</td>
            <td>{props.info.currency}</td>
            <td>{props.info.status}</td>
            <td>{props.info.quantity}</td>
            <td>{props.info.unit_price}</td>
            <td>{props.info.buy_sell}</td>
            <td>{props.info.trade_date}</td>
            <td>{props.info.settlement_date}</td>
        </tr>
    )
}
