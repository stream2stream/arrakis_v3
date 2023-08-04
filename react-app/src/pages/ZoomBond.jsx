import React from "react";
import ZoomBondTable from "../components/ZoomBondTable";
import ZoomTradeTable from "../components/ZoomTradeTable";
import Box from '@mui/material/Box';
import '../App.css';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import { useEffect, useState } from "react";
import { styled } from '@mui/material/styles';
import Card from '@mui/material/Card';
import CardHeader from '@mui/material/CardHeader';
import CardMedia from '@mui/material/CardMedia';
import CardContent from '@mui/material/CardContent';
import CardActions from '@mui/material/CardActions';
import Collapse from '@mui/material/Collapse';
import Avatar from '@mui/material/Avatar';
import IconButton from '@mui/material/IconButton';
import { red } from '@mui/material/colors';
import FavoriteIcon from '@mui/icons-material/Favorite';
import ShareIcon from '@mui/icons-material/Share';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import MoreVertIcon from '@mui/icons-material/MoreVert';
import Row from "react-bootstrap/Row";

const ZoomBond = () => {
  const [expanded, setExpanded] = React.useState(false);

  const handleExpandClick = () => {
    setExpanded(!expanded);
  };
  return (
    <Box component="main" sx={{ flexGrow: 1, p: 3 }}>
        <Toolbar />
           <Row className="row">
              <div style={{ display: "flex", flexDirection: "column", alignItems: "center" }}>
                <div style={{ margin: "20px 0" }}>BOND TABLE</div>
                
                  <ZoomBondTable/>
              
                <div style={{ margin: "20px 0" }}>TRADE TABLE</div>
              
                <ZoomTradeTable/>
            
              </div>
                
            </Row>
    </Box>
  );
};


export default ZoomBond;
