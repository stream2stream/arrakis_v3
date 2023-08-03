import React from 'react'
import BondCard from './BondCard'

const BondDetailPage = (props) => {
  return (<>
        <BondCard bonds= {["test", "test2"]}/>
      
      <table style = {{border: '1px solid grey'}}> 
        <tr>  
          <th> ISIN </th>
          <th> Type </th>
          <th> Issuer </th>
          <th> Maturity </th>
          <th> Face Value </th>
          <th> Currency </th>
          <th> Coupon % </th>
          <th> Status</th>

        </tr>
          {props.data.map(bonds => bonds.map(bond =>
              <tr>
                  <td>{bond["ISIN"]}</td>
                  <td>{bond["Type"]}</td>
                  <td>{bond["Issuer"]}</td>
                  <td>{bond["Maturity"]}</td>
                  <td>{bond["Face Value"]}</td>
                  <td>{bond["Currency"]}</td>
                  <td>{bond["Coupon %"]}</td>
                  <td>{bond["Status"]}</td>
              </tr>
          ))}
      </table>

      <table style = {{border: '1px solid grey'}}> 
        <tr>  
          <th> ISIN </th>
          <th> Book ID </th>
          <th> Client </th>
          <th> Status </th>
          <th> Quantity </th>
          <th> Buy/Sell </th>
          <th> Trade Date </th> 
          <th> Settlement Date</th>

        </tr>
      </table>


      </>
  )
}


export default BondDetailPage;
