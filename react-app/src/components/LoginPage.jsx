import React from 'react';
import { Container, Row, Col, Form, Button } from 'react-bootstrap';

const LoginPage = () => {
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
                                <Form.Control type="text" placeholder="Enter your username" />
                            </Form.Group>
                            <br/>

                            <Form.Group controlId="formEmail">
                                <Form.Label>Email - </Form.Label>
                                <Form.Control type="email" placeholder="Enter your email" />
                            </Form.Group>
                            <br />

                            <Button variant="primary" type="submit">
                                Login
                            </Button>
                        </div>
                    </Form>
        </Container>
        </>
    );
};

export default LoginPage;