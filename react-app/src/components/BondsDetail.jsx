import React from 'react';

const BondsDetail = (props) => {

  return (
    <div>
      
      <p><strong>ISIN:</strong> {props.info.isin}</p>
      <p><strong>Bond Currency:</strong> {props.info.currency}</p>
      <p><strong>CUSIP:</strong> {props.info.cusip}</p>
      <p><strong>Face Value:</strong> {props.info.faceValue}</p>
      <p><strong>Issuer Name:</strong> {props.info.issuerName}</p>
      <p><strong>Bond Maturity Date:</strong> {props.info.maturityDate}</p>
      <p><strong>Status:</strong> {props.info.status}</p>
      <p><strong>Type:</strong> {props.info.type}</p>
    </div>
  );
};

export default BondsDetail;
