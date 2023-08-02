import React, { useState, useEffect } from "react";
import { getAllBonds } from '../services/TradeServices';

const trades = [
    { coupon_percent: 4.37, bond_currency: "USD", CUSIP: null, face_value: 1000, isin: "XS1988387210", issuer_name: "BNPParibasIssu 4,37% Microsoft Corp (USD)", bond_maturity_date: "5/8/2021", status: "active", type: "CORP" },
    { coupon_percent: 4.38, bond_currency: "USD", cusip: null, face_value: 1000, isin: "XS1988387210", issuer_name: "BNPParibasIssu 4,37% Microsoft Corp (USD)", bond_maturity_date: "5/8/2021", status: "active", type: "CORP" }
]
// coupon_percent	bond_currency	cusip	face_value (mn)	isin	issuer_name	bond_maturity_date	status	type
// 4.37	USD		1000	XS1988387210	BNPParibasIssu 4,37% Microsoft Corp (USD)	5/8/2021	active	CORP
// 4.37	USD		1000	XS1988387210	BNPParibasIssu 4,37% Microsoft Corp (USD)	5/8/2021	active	CORP


export const Bonds = () => {
    
    const [bonds,setBonds] = useState([]);
    useEffect(()=>{
        getBondsFromAPI();}, 
        []
    );
    const getBondsFromAPI = ()=>{
        getAllBonds()
            .then(res => {
                console.log(res.data);
                setBonds(res.data);
            })
            .catch(err => {
                setBonds([]);
                console.log(err);
        })
    }
    
    const createRow = (data) => {     
        return <tr>
            <td>{data.coupon_percent}</td>
            <td>{data.bond_currency}</td>
            <td>{data.cusip}</td>
            <td>{data.face_value}</td>
            <td>{data.isin}</td>
            <td>{data.issuer_name}</td>
            <td>{data.bond_maturity_date}</td>
            <td>{data.status}</td>
            <td>{data.type}</td>
        </tr>
            
        }
    
  return (
    <div>
        <table>
            <tbody>
                <tr>
                    <th>Coupon Percent</th>
                    <th>Bond Currency</th>
                    <th>CUSIP</th>
                    <th>Face Value</th>
                    <th>ISIN</th>
                    <th>Issuer Name</th>
                    <th>Bond Maturity</th>
                    <th>Status</th>
                    <th>Type</th>
                </tr>
                {bonds.map(row => createRow(row))}
            </tbody>
            
        </table>
        
    </div>
  )
}

export default Bonds
