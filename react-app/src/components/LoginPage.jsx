import React, {useEffect, useState} from 'react';
import { Container, Row, Col, Form, Button } from 'react-bootstrap';
import {useNavigate} from 'react-router-dom';
import {findUsers} from "../services/BondServices";

const LoginPage = () => {

    const [user, setUser] = useState("");
    const [email, setEmail] = useState("");
    let users = [];

    const navigate = useNavigate();

    const handleSubmit = (e) => {
        getUsersFromAPI().then(res => {
            users = (res["data"]);
        }).then(() => {
            console.log("names " + users);
            if (users.length === 0) {
                console.log("ERROR HAS OCCURRED ON SUBMISSION");
                return;
            }
            for (let i = 0; i < users.length; i++) {
                if (user.toLowerCase() == users[i]["userName"].toLowerCase()) {
                    console.log("SUCCESSFUL LOGIN");
                    navigate('/bonds', {state: {user: user}});
                }
            }
        });
        e.preventDefault();
    }

    useEffect(() => {
        getUsersFromAPI().then(res => {
            users = (res["data"]);
        }).then(() => {console.log(users);});
    }, []);

    const getUsersFromAPI = async () => {
        return await findUsers();
    }


    return (<>
        <Container>
            <Row>
                <Col>
                    <h1 style= {{textAlign: 'center'}}> Bond Market Value Appreciation</h1>
                </Col>
            </Row>
        </Container>
        <Container style={{ display: 'flex', justifyContent: 'center', alignItems: 'center'}}>
                    <Form style={{marginTop: '30vh', border: '2px solid', borderRadius: 10, boxShadow: '2px 2px 20px'}}>
                        <div style={{paddingTop: 40, paddingBottom: 40, paddingLeft: 20, paddingRight: 20}}>
                            <Form.Group controlId="formUsername">
                                <Form.Label>Username - </Form.Label>
                                <Form.Control type="text" placeholder="Enter your username" onChange={(e) => setUser(e.target.value)} />
                            </Form.Group>
                            <br/>

                            <Form.Group controlId="formEmail">
                                <Form.Label>Email - </Form.Label>
                                <Form.Control type="email" placeholder="Enter your email" onChange={(e) => setEmail(e.target.value)}/>
                            </Form.Group>
                            <br />

                            <Button variant="primary" onClick={handleSubmit}>
                                Login
                            </Button>
                        </div>
                    </Form>
        </Container>
        </>
    );
};

export default LoginPage;