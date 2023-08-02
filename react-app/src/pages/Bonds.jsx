import * as React from 'react';
import Box from '@mui/material/Box';

import Toolbar from '@mui/material/Toolbar';

import Typography from '@mui/material/Typography';
import BondCard from '../components/BondCard';

function Bonds() {
  return (
    <Box component="main" sx={{ flexGrow: 1, p: 3 }}>
        <Toolbar />
       
      
        <BondCard/>
        <BondCard/>
      </Box>
  )
}

export default Bonds