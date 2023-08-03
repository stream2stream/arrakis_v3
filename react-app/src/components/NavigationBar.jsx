import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Container from '@mui/material/Container';
import Button from '@mui/material/Button';
import { Tab, Tabs } from '@mui/material';
import { useState } from 'react';
// import {CustomTabPanel} from '@mui/material';

const pages = ['Home', 'Books', 'Upcoming'];

function handleBarClick(params) {
    console.log(params);
  }

function NavigationBar() {

    const [selectedTab, setSelectedTab] = useState(0);

    const handleTabChange = (event, newValue) => {
        setSelectedTab(newValue);
        console.log(newValue);
    };

    const TabPanel = ({value, index}) => {
        console.log();
    }

  return (
    <>
    <AppBar position="static"  sx={{ 'background-color': '#627d97'}}>
        <Container maxWidth="xl">
            <Box sx={{ flexGrow: 1, display: { xs: 'none', md: 'flex', 'justify-content': 'space-around' } }}>
                <Tabs value={selectedTab} onChange={handleTabChange}>
                    <Tab label={pages[0]} />
                    <Tab label={pages[1]}  />
                    <Tab label={pages[2]}  />
                </Tabs>
            </Box>
        </Container>
    </AppBar>
    <TabPanel value={selectedTab} index={0}/>
    <TabPanel value={selectedTab} index={1}/>
    <TabPanel value={selectedTab} index={2}/>
     </>
   );
}
export default NavigationBar;