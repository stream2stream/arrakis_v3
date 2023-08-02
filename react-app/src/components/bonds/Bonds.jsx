import React, { useState, useEffect } from "react";
import { findBonds } from "../../services/BondServices";
import { Button, Card, Table } from "react-bootstrap";
import styles from "./Bonds.module.css";

const dummyData = [
  {
    "trade_type": "buy",
    "trade_currency": "USD",
    "quantity": 50,
    "trade_settlement_date": "04/08/2021",
    "trade_status": "open",
    "trade_date": "13/05/2021",
    "unit_price": 90,
    "coupon_percent": 4.37,
    "bond_currency": "USD",
    "cusip": "",
    "face_value (mn)": 1000,
    "isin": "XS1988387210",
    "issuer_name": "BNPParibasIssu 4,37% Microsoft Corp (USD)",
    "bond_maturity_date": "05/08/2023",
    "status": "active",
    "type": "CORP",
    "book_name": "trading_book_1",
    "bond_holder": "AZ Holdings Inc"
  },
  {
    "trade_type": "sell",
    "trade_currency": "GBP",
    "quantity": 40,
    "trade_settlement_date": "04/08/2021",
    "trade_status": "open",
    "trade_date": "04/02/2021",
    "unit_price": 89.56,
    "coupon_percent": 4.37,
    "bond_currency": "USD",
    "cusip": "",
    "face_value (mn)": 1000,
    "isin": "XS1988387211",
    "issuer_name": "BNPParibasIssu 4,37% Microsoft Corp (USD)",
    "bond_maturity_date": "05/08/2023",
    "status": "active",
    "type": "CORP",
    "book_name": "trading_book_1",
    "bond_holder": "AZ Holdings Inc"
  },
  {
    "trade_type": "buy",
    "trade_currency": "USD",
    "quantity": 1000,
    "trade_settlement_date": "23/08/2021",
    "trade_status": "open",
    "trade_date": "13/05/2021",
    "unit_price": 105.775,
    "coupon_percent": 3.15,
    "bond_currency": "USD",
    "cusip": "123456780",
    "face_value (mn)": 900,
    "isin": "USN0280EAR64",
    "issuer_name": "Airbus 3.15%  USD",
    "bond_maturity_date": "12/07/2021",
    "status": "active",
    "type": "CORP",
    "book_name": "trading_book_2",
    "bond_holder": "Acme co"
  }
];

export const Bonds = () => {
  const [bonds, setBonds] = useState(dummyData);
  const isin = new Set();

  // get bonds values
  const deBonds = [];

  for (let i = 0; i < bonds.length; i++) {

    //get the filtered bonds based on maturity date
    let rawDate = bonds[i]["bond_maturity_date"].split("/");
    let maturityDate = new Date(rawDate[2], rawDate[1] - 1, rawDate[0]).getTime();
    let nowDate = new Date();
    if (Math.abs((nowDate - maturityDate) / 3600000) <= 7 * 24) {
      isin.add(bonds[i]["isin"])
    }

    //get all the values of bonds
    deBonds.push(<>
      {Object.values(bonds[i]).map((value, index) => (
        <td key={index}>{value}</td>
      ))}
    </>);
  }

  useEffect(() => {
    setBonds(findBonds)
  }, [])

  return (
    <>
      <Table responsive>
        <thead>
          <tr>{Object.keys(bonds[0]).map((bondKey, index) => (
            <th key={index}>{bondKey}</th>
          )
          )}</tr>
        </thead>
        <tbody>
          {deBonds.map(ele => <tr>{ele}</tr>)}
        </tbody>
      </Table>
      <Card className={styles.card}>
        <Card.Header>Bonds due for maturity within 5 business days</Card.Header>
        <Card.Body>
          <Card.Title>The required bonds are shown below: </Card.Title>
          {[...isin].map(ele => <Card.Text>{ele}</Card.Text>)}
        </Card.Body>
      </Card>
    </>
  );
}
export default Bonds;
