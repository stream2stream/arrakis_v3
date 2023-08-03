import * as React from 'react';

import Drawer from '@mui/material/Drawer';
import AppBar from '@mui/material/AppBar';
import CssBaseline from '@mui/material/CssBaseline';
import Toolbar from '@mui/material/Toolbar';
import List from '@mui/material/List';
import Typography from '@mui/material/Typography';
import Divider from '@mui/material/Divider';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import AccountBalanceWalletIcon from '@mui/icons-material/AccountBalanceWallet';
import MailIcon from '@mui/icons-material/Mail';
import Bonds from './Bonds';
import { BrowserRouter as Router, Routes, Route, Navigate, Outlet } from "react-router-dom";
import Box from '@mui/material/Box';
import ZoomBond from './ZoomBond';
import { useNavigate } from 'react-router-dom';
import AdbIcon from '@mui/icons-material/Adb';
import DB from '../images/DB3.png';

const drawerWidth = 160;

export default function Home() {
  const navigate = useNavigate();
  const onClickSidebarOption = (data) =>{
    console.log(data);
    navigate("/home/" + data);
  }

  return (
    <>
    <Box sx={{ display: 'flex' }}>
      <CssBaseline />
      <AppBar  position="fixed" sx={{ zIndex: (theme) => theme.zIndex.drawer + 1 }}>
        <Toolbar className="navbar">
          <Box
            component="img"
            sx={{
            height: 44,
            paddingRight: 1
            }}
            alt="Your logo."
            src={DB}
        />
      
        </Toolbar>
      </AppBar>
      <Drawer
        variant="permanent"
        sx={{
          width: drawerWidth,
          flexShrink: 0,
          [`& .MuiDrawer-paper`]: { width: drawerWidth, boxSizing: 'border-box' },
        }}
      >
        <Toolbar />
        <Box sx={{ overflow: 'auto' }}>
          <List>
            {['Bonds'].map((text, index) => (
              
              <ListItem key={text} disablePadding  onClick={()=> {onClickSidebarOption(text)}}>
                <ListItemButton>
                  <ListItemIcon>
                    {index % 2 === 0 ? <AccountBalanceWalletIcon /> : <AccountBalanceWalletIcon />}
                  </ListItemIcon>
                  <ListItemText primary={text} />
                </ListItemButton>
              </ListItem>
            ))}
          </List>
        </Box>
      </Drawer>
      <Outlet />
      
    </Box>
    
  </>
  );
}