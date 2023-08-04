import React from 'react'
import AllMaturingBonds from './AllMaturingBonds'

const MatureBondsWrapper = (dateBonds) => {
  return (
    <>
    <AllMaturingBonds/>
      <table className="table table-striped">
      <thead>
        <tr>
          <th scope="col">ISIN</th>
          <th scope="col">Type</th>
          <th scope="col">Issuer</th>
          <th scope="col">Maturity</th>
          <th scope="col">Face Value</th>
          <th scope="col">Currency</th>
          <th scope="col">Coupon %</th>
          <th scope="col">Status</th>
        </tr>
      </thead>
      <tbody>
        {dateBonds.map((row, index) => (
          <tr key={index}>
            <td>{row.isin}</td>
            <td>{row.type}</td>
            <td>{row.issuerName}</td>
            <td>{formatDate(row.bondMaturityDate)}</td>
            <td>{row.faceValue}</td>
            <td>{row.bondCurrency}</td>
            <td>{row.couponPercent}</td>
            <td>{row.status}</td>
          </tr>
        ))}
      </tbody>
    </table>
          </>
  )
}

export default MatureBondsWrapper