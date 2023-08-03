import * as React from 'react';
import Box from '@mui/material/Box';
import '../App.css';
import Toolbar from '@mui/material/Toolbar';
import Row from "react-bootstrap/Row";
import Typography from '@mui/material/Typography';
import BondCard from '../components/BondCard';
import { useOutletContext } from "react-router-dom";
import { useEffect } from 'react';
import  {getAllBondsForBusinessDaysBeforeAndAfter, getAllBonds} from '../services/BondService';
import { format } from 'date-fns';
import { useState } from 'react';


function Bonds() {
    const [bonds, setBonds] = useState([]);
    const [bondsData, setBondsData] = new React.useState([]);
    const [date] = useOutletContext();
  
    const getBonds = ()=> {
      getAllBonds().then((data) => {
          console.log(data)
      })
      .catch((error) => console.error("Error fetching bonds:", error));
    }
  
    const getBondsByDate = () => {    
      let newDate = new Date(date);
      newDate = format(newDate, 'dd-MM-yyyy');
      getAllBondsForBusinessDaysBeforeAndAfter(newDate).then((data) => {
          setBonds(data);
      }).catch((error) => {
          console.log(error)
      })
    }  

    useEffect(() => {
       console.log(date)
        try {
            getBondsByDate();
        } catch (error) {
            console.error("Error fetching bonds:", error);
        }
          
    }, [date]);

    return (
        <Box component="main" sx={{ flexGrow: 1, p: 3 }}>
            <Toolbar />
            <Row className="row">
                  {bonds.map((bond, index) => (
                    <div className="container" key={index}>
                      <BondCard key={index} bond={bond} date={date} /> 
                    </div>
                  ))}
            </Row>
        </Box>
      );
      
}

export default Bonds