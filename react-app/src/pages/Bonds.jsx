import * as React from 'react';
import Box from '@mui/material/Box';
import '../App.css';
import Toolbar from '@mui/material/Toolbar';
import Row from "react-bootstrap/Row";
import Typography from '@mui/material/Typography';
import BondCard from '../components/BondCard';

function Bonds() {
  return (
    <Box component="main" sx={{ flexGrow: 1, p: 3 }}>
        <Toolbar />
       
        <Row>
            <div className="container">
                <BondCard className="container"/>
            </div>
            <div className="container">
                <BondCard/>
            </div>
            <div className="container">
                <BondCard className="container"/>
            </div>
            <div className="container">
                <BondCard/>
            </div>
            <div className="container">
                <BondCard className="container"/>
            </div>
            <div className="container">
                <BondCard/>
            </div>
            
        </Row>
      </Box>
  )
}

export default Bonds