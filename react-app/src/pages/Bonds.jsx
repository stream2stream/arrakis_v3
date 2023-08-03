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
const data = [
    {"date": "03/08/2023", "typeOfBondsAndMaturedOnThisDay": [{'typeOfBond': 'GOVN', 'NumberOfBondMatured': 2}, {'typeOfBond': 'CORP', 'NumberOfBondMatured': 3}]},
    {"date": "03/08/2023", "typeOfBondsAndMaturedOnThisDay": [{'typeOfBond': 'GOVN', 'NumberOfBondMatured': 2}, {'typeOfBond': 'CORP', 'NumberOfBondMatured': 3}]}
]

function Bonds() {
  const [bondsData, setBondsData] = new React.useState([]);
  const [date] = useOutletContext();

  const getBonds = ()=> {
    getAllBonds().then((data) => {
        console.log(data)
    })
    .catch((error) => console.error("Error fetching bonds:", error));
  }

  const getBondsByDate = () => {
    console.log('gets bond data');

    console.log(date);
    let newDate = new Date(date);
    newDate = format(newDate, 'dd-MM-yyyy')
    console.log(newDate);
    getAllBondsForBusinessDaysBeforeAndAfter(newDate).then((data) => {
        console.log(data)
    }).catch((error) => {
        console.log(error)
    })
  }  
  useEffect(() => {
    try {
        getBondsByDate();
    } catch (e) {
        console.log('Error')
        }
    
  })
 
  return (
   
    <Box component="main" sx={{ flexGrow: 1, p: 3 }}>
       
        <Toolbar />
 
        <Row className="row">
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