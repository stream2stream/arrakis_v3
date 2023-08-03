import React from "react";
import ZoomBondTable from "../components/ZoomBondTable";
import ZoomTradeTable from "../components/ZoomTradeTable";
import Box from '@mui/material/Box';
import '../App.css';
import Toolbar from '@mui/material/Toolbar';
import Row from "react-bootstrap/Row";
import Typography from '@mui/material/Typography';

const ZoomBond = () => {
  return (
    <Box component="main" sx={{ flexGrow: 1, p: 3 }}>
       
           <Row>
                <div style={{ display: "flex", flexDirection: "column", alignItems: "center" }}>
                <div style={{ margin: "20px 0" }}>This is the ZoomBondTable</div>
               
                     <ZoomBondTable/>
            
                <div style={{ margin: "20px 0" }}>This is the ZoomTradeTable.</div>
              
                   <ZoomTradeTable/>
            
                </div>
            </Row>
    </Box>
  );
};

export default ZoomBond;
