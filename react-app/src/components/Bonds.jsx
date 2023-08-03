import React, { useState, useEffect } from "react";
import { getAllBonds, getAllBondsMaturity } from '../services/TradeServices';


// const trades = [
//     { coupon_percent: 4.37, bond_currency: "USD", CUSIP: null, face_value: 1000, isin: "XS1988387210", issuer_name: "BNPParibasIssu 4,37% Microsoft Corp (USD)", bond_maturity_date: "5/8/2021", status: "active", type: "CORP" },
//     { coupon_percent: 4.38, bond_currency: "USD", cusip: null, face_value: 1000, isin: "XS1988387210", issuer_name: "BNPParibasIssu 4,37% Microsoft Corp (USD)", bond_maturity_date: "5/8/2021", status: "active", type: "CORP" }
// ]
// coupon_percent	bond_currency	cusip	face_value (mn)	isin	issuer_name	bond_maturity_date	status	type
// 4.37	USD		1000	XS1988387210	BNPParibasIssu 4,37% Microsoft Corp (USD)	5/8/2021	active	CORP
// 4.37	USD		1000	XS1988387210	BNPParibasIssu 4,37% Microsoft Corp (USD)	5/8/2021	active	CORP


export const Bonds = () => {
    
    const [bonds,setBonds] = useState([]);
    const [bondsMaturity,setBondsMaturity] = useState([]);
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
        getAllBondsMaturity()
            .then(res => {
                console.log(res.data);
                setBondsMaturity(res.data);
            })
            .catch(err => {
                setBondsMaturity([]);
                console.log(err);
        })
    }
    
    const createRow = (data) => {     
        return <tr>
            <td>{data.couponPercent}</td>
            <td>{data.bondCurrency}</td>
            <td>{data.cusip}</td>
            <td>{data.faceValue}</td>
            <td>{data.isin}</td>
            <td>{data.issuerName}</td>
            <td>{data.bondMaturity}</td>
            <td>{data.status}</td>
            <td>{data.type}</td>
        </tr>
            
        }
    
  return (
    <><div>
        <table>
            <thead>
                <tr><th colSpan="9">All Bonds</th></tr>
            </thead>
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
    <div class="space"></div>
    <div>
    <table>
        <thead>
            <tr><th colSpan="9">All Bonds Within 5 Days</th></tr>
        </thead>
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
            {bondsMaturity.map(row => createRow(row))}
        </tbody>
        
    </table>

    </div> </>
  )
}

export default Bonds
