import React from 'react'
import BondCard from './BondCard'

const BondDetailPage = (props) => {
  let data = [{ISIN : 'A12356112', Type : 'Sovereign' , Issuer :'BunderBank', Maturity : '15/07/2021'
, FaceValue: '900', BondCurrency: 'USD', Coupon : '2', Status: 'active', BookID:'book4', Client: 'Goldman Sachs', Quantity: '60', UnitPrice: '70.5',  
TradeCurrency: "GBP", Buysell: 'buy', TradeDate: '04/02/2021', SettlementDate: '27/09/2021' , TradeStatus: 'open'}]

const TableStyle = {
  border: '1px solid grey'
}
const THStyle = {
  borderBottom: '1px solid black'
}

  return (<>
        <BondCard bonds= {["test", "test2"]}/>
      
      <table style = {TableStyle}> 
        <tr>  
          <th style = {THStyle}> ISIN </th>
          <th style = {THStyle}> Type </th>
          <th style = {THStyle}> Issuer </th>
          <th style = {THStyle}> Maturity </th>
          <th style = {THStyle}> Face Value </th>
          <th style = {THStyle}> Bond Currency </th>
          <th style = {THStyle}> Coupon % </th>
          <th style = {THStyle}> Status</th>

        </tr>
          {data.map(bond =>
              <tr>
                  <td>{bond["ISIN"]}</td>
                  <td>{bond["Type"]}</td>
                  <td>{bond["Issuer"]}</td>
                  <td>{bond["Maturity"]}</td>
                  <td>{bond["FaceValue"]}</td>
                  <td>{bond["BondCurrency"]}</td>
                  <td>{bond["Coupon"]}</td>
                  <td>{bond["Status"]}</td>
              </tr>
          )}
      </table>

      <table style = {TableStyle}> 
        <tr>  
          <th style = {THStyle}> ISIN </th>
          <th style = {THStyle}> Book ID </th>
          <th style = {THStyle}> Client </th>
          <th style = {THStyle}> Trade Status </th>
          <th style = {THStyle}> Quantity </th>
          <th style = {THStyle}> Unit Price </th>
          <th style = {THStyle}> Trade Currency </th>  
          <th style = {THStyle}> Buy/Sell </th>
          <th style = {THStyle}> Trade Date </th> 
          <th style = {THStyle}> Settlement Date</th>

        </tr>
        {data.map(bond =>
              <tr>
                  <td>{bond["ISIN"]}</td>
                  <td>{bond["BookID"]}</td>
                  <td>{bond["Client"]}</td>
                  <td>{bond["TradeStatus"]}</td>
                  <td>{bond["Quantity"]}</td>
                  <td>{bond["UnitPrice"]}</td>
                  <td>{bond["TradeCurrency"]}</td>
                  <td>{bond["Buysell"]}</td>
                  <td>{bond["TradeDate"]}</td>
                  <td>{bond["SettlementDate"]}</td>
              </tr>
          )}
      </table>


      </>
  )
}


export default BondDetailPage;
