import React from 'react'
import BondCard from './BondCard'

const BondDetailPage = (props) => {
  let data = [{ISIN : 'A12356112', Type : 'Sovereign' , Issuer :'BunderBank', Maturity : '15/07/2021'
, FaceValue: '900', BondCurrency: 'USD', Coupon : '2', Status: 'active', BookID:'book4', Client: 'Goldman Sachs', Quantity: '60', UnitPrice: '70.5',  
TradeCurrency: "GBP", Buysell: 'buy', TradeDate: '04/02/2021', SettlementDate: '27/09/2021' , TradeStatus: 'open'}]

  return (<>
        <BondCard bonds= {["test", "test2"]}/>
      
      <table style = {{border: '1px solid grey'}}> 
        <tr>  
          <th> ISIN </th>
          <th> Type </th>
          <th> Issuer </th>
          <th> Maturity </th>
          <th> Face Value </th>
          <th> Bond Currency </th>
          <th> Coupon % </th>
          <th> Status</th>

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

      <table style = {{border: '1px solid grey'}}> 
        <tr>  
          <th> ISIN </th>
          <th> Book ID </th>
          <th> Client </th>
          <th> Trade Status </th>
          <th> Quantity </th>
          <th> Unit Price </th>
          <th> Trade Currency </th>  
          <th> Buy/Sell </th>
          <th> Trade Date </th> 
          <th> Settlement Date</th>

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
