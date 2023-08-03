import React from 'react'
import Card from 'react-bootstrap/Card';

const BondCard= (props) =>{
  return (
    <Card style={{ width: '18rem', backgroundColor: 'lightblue', border: '5px solid', borderRadius: '10px', borderColor: 'teal', boxShadow: '5px 5px 20px', marginLeft: "25px", marginRight: "25px"}}>
      <Card.Body>
        <Card.Title>Maturity Date</Card.Title>
        {props.bonds.map((bond, i) => (i < 4 ? <Card.Text>{bond} </Card.Text> : ""))}
        <Card.Link href="#">Bond Details</Card.Link>
      </Card.Body>
    </Card>
  );
}

export default BondCard;