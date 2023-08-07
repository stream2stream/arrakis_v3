import React from 'react';
import '../styles/layout.css'; 
import AllBooks from './AllBooks'
import AllBonds from './AllBonds'
import DateBox from './DateBox'
import Calendar from './Calendar';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';

const Home = () => {
      return (

            <div className="container">
                <Navbar expand="lg" className="bg-body-tertiary">
        <Container>
          <Navbar.Brand href="#home">Bond overview</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <Nav.Link href="#link">User Bonds</Nav.Link>
            </Nav>        
          </Navbar.Collapse>
        </Container>    
        </Navbar>
             
                <div className="left-column">
                    <div className='box'>
                       <DateBox></DateBox>
                    </div>
                    <div className='bidnumber'>

                    </div>
               
                </div>
                    
                <div className='table-container'>
                  <div className="right-column">
                    <Calendar />
                    <table>
                       
                         <AllBonds></AllBonds>
             
                    </table>
                       
                <div className="space-between-tables" />
                    <table>
                        <AllBooks></AllBooks>
                    </table>
                    </div>
                </div>  
                
                </div>                          
      );
      };

      export default Home;

                                    

