import React from 'react'
import BondCard from './BondCard'
import {Container, Row, Col} from 'react-bootstrap'

const HomePage = () => {
  let bonds = ["bond 1", "bond 2", "bond 3", "bond 4"]
  return (
    <div>
        <Container>
          <Row>
            <Col>
            <h1 style= {{textAlign: 'center'}}> Bond Market Value Appreciation</h1>
            </Col>
          </Row>
        </Container>
        <BondCard bonds = {bonds}/>
    </div>
  )
}

export default HomePage