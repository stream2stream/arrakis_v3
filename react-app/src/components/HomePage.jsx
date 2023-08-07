import React, {useEffect, useState} from 'react'
import BondCard from './BondCard'
import {Container, Row, Col} from 'react-bootstrap'
import {useSnapCarousel} from 'react-snap-carousel'
import {Link, useLocation, useNavigate} from "react-router-dom";
import {getBookingId, getMaturityDates, getTradesFromBookingId} from "../services/BondServices";

const HomePage = (props) => {
    const {scrollRef} = useSnapCarousel();
    const location = useLocation();
    const navigate = useNavigate();
    let user = location.state;
    const [maturityDates, setMaturityDates] = useState([]);
    const [bonds, setBonds] = useState([]);
    const [bookingId, setBookingId] = useState("");

    useEffect(() => {
        getBookingId(user['user']).then((res) => {
            setBookingId(res.data);
            getMaturityDates(res.data).then(res2 => {
                let dates = res2.data;
                dates.forEach((date, i) => {dates[i] = date.substring(0,10)});
                dates = [...new Set(dates)];
                setMaturityDates(dates);
            }).then(() => {
                getTradesFromBookingId(res.data).then(res2 => {
                    console.log("BOND INFO ------------------");
                    let bondInfo = [];
                    res2.data.forEach(data => {
                        let splitData = data.split(',');
                        bondInfo[bondInfo.length] = splitData;
                    })
                    console.log(bondInfo);
                    setBonds(bondInfo);
                });
            });
        });
    }, []);

    const getBonds = (date, bondsArray) => {
        let result = [];
        for(let i = 0; i < bondsArray.length; i++) {
            if(bondsArray[i][1].substring(0,10) === date) {
                result[result.length] = bondsArray[i][0];
            }
        }
        return result;
    }

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
                                            <BondCard user={user['user']} date={date} bonds={getBonds(date, bonds)}/>
                                         </li>)}
            </ul>
        </div>
        );

}

export default HomePage