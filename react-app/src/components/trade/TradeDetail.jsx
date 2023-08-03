import React from 'react'

export const TradeDetail = (props) => {
    return (
        <tr>
            <td>{props.info.isin}</td>
            <td>{props.info.bookId} </td>
            <td>{props.info.counterParty}</td>
            <td>{props.info.status}</td>
            <td>{props.info.quantity}</td>
            <td>{props.info.unitPrice}</td>
            <td>{props.info.currency}</td>
            <td>{props.info.buySell}</td>
            <td>{props.info.tradeDate}</td>
            <td>{props.info.settlementDate}</td>
        </tr>
    )
}
