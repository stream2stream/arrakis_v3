import React from 'react'
import BondCard from './BondCard'
import {useNavigate, useParams} from 'react-router-dom'
import {Button} from "react-bootstrap";

const BondDetailPage = (props) => {
  let data = [{ISIN : 'A12356112', Type : 'Sovereign' , Issuer :'BunderBank', Maturity : '15/07/2021'
, FaceValue: '900', BondCurrency: 'USD', Coupon : '2', Status: 'active', BookID:'book4', Client: 'Goldman Sachs', Quantity: '60', UnitPrice: '70.5',
TradeCurrency: "GBP", Buysell: 'buy', TradeDate: '04/02/2021', SettlementDate: '27/09/2021' , TradeStatus: 'open'}];

  const params = useParams();

  const TableStyle = {
    border: '1px solid grey',
    marginLeft: '30%',
    paddingBottom: 20,
    maxHeight: 400,
    overflow: "auto",
    minHeight: 100,
    width: "60%",
    marginBottom: "5%"
  }
  const THStyle = {
    borderBottom: '1px solid black'
  }
  const TDStyle = {
      textAlign: "center"
  }

  const navigate = useNavigate();
  const handleHome = () => {
    navigate('/bonds', {state: {user: params["user"]}})
  }

  const ButtonStyle = {
    backgroundColor: '#007bff',
    color: '#ffffff',
    border: 'none',
    padding: '10px 20px',
    cursor: 'pointer',
  };

  return (<>
        <div style={{marginTop: '5%', marginLeft: "5%"}}>
          <BondCard bonds= {["test", "test2"]}/>
        </div>
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
                    <td style={TDStyle}>{bond["ISIN"]}</td>
                    <td style={TDStyle}>{bond["Type"]}</td>
                    <td style={TDStyle}>{bond["Issuer"]}</td>
                    <td style={TDStyle}>{bond["Maturity"]}</td>
                    <td style={TDStyle}>{bond["FaceValue"]}</td>
                    <td style={TDStyle}>{bond["BondCurrency"]}</td>
                    <td style={TDStyle}>{bond["Coupon"]}</td>
                    <td style={{textAlign: "center", color: bond["Status"]==="active" ? "green" : "red"}}>{bond["Status"]}</td>
                </tr>
            )}
        </table>
        <div style={{marginLeft: "45%", backgroundColor:"#5885AF", marginRight: "20%"}}><h1>Transations by ISIN - {params["date"]} - {params["user"]}</h1></div>
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
                    <td style={TDStyle}>{bond["ISIN"]}</td>
                    <td style={TDStyle}>{bond["BookID"]}</td>
                    <td style={TDStyle}>{bond["Client"]}</td>
                    <td style={{textAlign: "center", color: bond["TradeStatus"]==="open" ? "green" : "red"}}>{bond["TradeStatus"]}</td>
                    <td style={TDStyle}>{bond["Quantity"]}</td>
                    <td style={TDStyle}>{bond["UnitPrice"]}</td>
                    <td style={TDStyle}>{bond["TradeCurrency"]}</td>
                    <td style={TDStyle}>{bond["Buysell"]}</td>
                    <td style={TDStyle}>{bond["TradeDate"]}</td>
                    <td style={TDStyle}>{bond["SettlementDate"]}</td>
                </tr>
            )}
        </table>

      <Button onClick={handleHome} style={{ color: "white", background: "silver" }}>Home Page</Button>
      <Button onClick={handleHome} style={ButtonStyle}>Home Page</Button>
      </>
  )
}


export default BondDetailPage;
