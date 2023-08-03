import React, {useEffect} from 'react'
import BondCard from './BondCard'
import {Container, Row, Col} from 'react-bootstrap'
import {useSnapCarousel} from 'react-snap-carousel'
import {Link, useLocation, useNavigate} from "react-router-dom";

const HomePage = (props) => {
    const {scrollRef} = useSnapCarousel();
    const location = useLocation();
    const navigate = useNavigate();
    let user = location.state;

  return(
        <div>
            {user === null || user.user === "" ? navigate("/") : console.log("Successfully Logged In") }
            <Container>
              <Row>
                <Col>
                <h1 style= {{textAlign: 'center'}}> Bond Market Value Appreciation</h1>
                </Col>
              </Row>
            </Container>
            <ul id="scrollbar" ref={scrollRef} style={{display:'flex', overflow: 'auto', marginTop: '15%'}}>
                {props.dates.map(date => <li style={{width: '300px',
                                                     height: '250px',
                                                     flexShrink: 0,
                                                     display: 'flex',
                                                     justifyContent: 'center',
                                                     alignItems: 'center'}}>
                                            <BondCard bonds={date}/>
                                         </li>)}
            </ul>
        </div>
        );

}

export default HomePage