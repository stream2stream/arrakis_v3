import React from "react";
import "../App.css";

const BondDetail = (props) => {
  return (
    <>
    <div className="card my-3">
      <div className="card-body">
        <h1 className="card-title">{props.info.issuerName}</h1>
        <p className="card-text">
          Face Value: {props.info.faceValue} &emsp; Coupon:{" "}
          {props.info.couponPercent} &emsp; Maturity Date:{" "}
          {props.info.bondMaturityDate} &emsp; ISIN: {props.info.isin}
        </p>
      </div>
    </div>
    </>
  );
};

export default BondDetail;

//isin, issuer_name, bond_maturity_date, coupon_percent, face_value
