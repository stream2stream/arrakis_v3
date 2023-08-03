import React from 'react'
import BondCard from './BondCard'
import {Container, Row, Col} from 'react-bootstrap'

const HomePage = (props) => {
  // let bonds = ["bond 1", "bond 2", "bond 3", "bond 4"];
  return (
    <div>
        <Container>
          <Row>
            <Col>
            <h1 style= {{textAlign: 'center'}}> Bond Market Value Appreciation</h1>
            </Col>
          </Row>
        </Container>
        <Container style={{display: "flex", alignItems: "center", justifyContent: "center", marginTop: "15%"}}>
            {props.dates.map(date => <BondCard bonds={date}/>)}
        </Container>
    </div>
  )
}

export default HomePage