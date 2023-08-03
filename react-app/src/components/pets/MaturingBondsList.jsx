import BondDetail from './BondDetail';
import { getBondsByDate } from '../../services/BondServices';
import { useState } from 'react'
import { useEffect } from 'react'
const MaturingBondsList = (props) => {
    const [dateBonds, setDateBonds] = useState([]);

    useEffect(()=>{
      getBondsByDateFromAPI();},
      []
    );
  
    const getBondsByDateFromAPI = ()=>{
      getBondsByDate(props)
      .then(res => {
        setDateBonds(res.data);
        console.log(res);
      })
      .catch(err => {
        setDateBonds([]);
        console.log(err);
      })
    }
  

    return (
      dateBonds.map(bond => (
        <>
          <BondDetail info={bond} key={bond.isin.toString()} />
        </>
      ))
    )
}

export default MaturingBondsList