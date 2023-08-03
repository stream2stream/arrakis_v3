import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Container from '@mui/material/Container';
import { Tab, Tabs } from '@mui/material';
import { useState } from 'react';

const pages = ['Home', 'Books', 'Upcoming'];

const NavigationBar = (props) => {

    const [selectedTab, setSelectedTab] = useState(0);

    const handleTabChange = (event, newValue) => {
        setSelectedTab(newValue);
        props.setTab(newValue);
        console.log(newValue);
    };

    const TabPanel = ({value, index}) => {
        console.log();
    }

  return (
    <>
    <AppBar position="static"  sx={{ 'background-color': '#e8f6ff'}}>
        <Container maxWidth="xl">
            <Box sx={{ flexGrow: 1, display: { xs: 'none', md: 'flex', 'justify-content': 'space-around' } }}>
                <Tabs value={selectedTab} onChange={handleTabChange} sx={{color: 'white'}}>
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