import React from 'react'

const SecurityDetails = (props) => {
  return (
    <tr>
      <td>{props.info.isin}</td>
      <td>{props.info.cusip} </td>
      <td>{props.info.issuerName}</td>
      <td>{props.info.maturityDate}</td>
      <td>{props.info.coupon}</td>
      <td>{props.info.type}</td>
      <td>{props.info.faceValue}</td>
      <td>{props.info.currency}</td>
      <td>{props.info.status}</td>
    </tr>
  )
}

export default SecurityDetails