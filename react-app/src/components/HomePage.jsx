import React, {useEffect, useState} from 'react'
import BondCard from './BondCard'
import {Container, Row, Col} from 'react-bootstrap'
import {useSnapCarousel} from 'react-snap-carousel'
import {Link, useLocation, useNavigate} from "react-router-dom";
import {getBookingId, getMaturityDates} from "../services/BondServices";

const HomePage = (props) => {
    const {scrollRef} = useSnapCarousel();
    const location = useLocation();
    const navigate = useNavigate();
    let user = location.state;
    // let maturityDates = [];
    const bonds = new Map();
    const [maturityDates, setMaturityDates] = useState([]);

    useEffect(() => {
        getBookingId(user['user']).then((res) => {
            getMaturityDates(res.data).then(res2 => {
                let dates = res2.data;
                dates.forEach((date, i) => {dates[i] = date.substring(0,10)});
                dates = [...new Set(dates)];
                setMaturityDates(dates);
            });
        })
    }, []);

  return(
        <div>
            {(user === null || user.user === "") && navigate("/") }
            <Container>
              <Row>
                <Col>
                <h1 style= {{textAlign: 'center'}}> Bond Market Value Appreciation</h1>
                </Col>
              </Row>
            </Container>
            <ul id="scrollbar" ref={scrollRef} style={{display:'flex', overflow: 'auto', marginTop: '15%'}}>
                {maturityDates.map(date => <li style={{width: '300px',
                                                     height: '250px',
                                                     flexShrink: 0,
                                                     display: 'flex',
                                                     justifyContent: 'center',
                                                     alignItems: 'center'}}>
                                            <BondCard date={date} bonds={["bond 1", "bond 2", "bond 3"]}/>
                                         </li>)}
            </ul>
        </div>
        );

}

export default HomePage