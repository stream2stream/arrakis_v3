import React from 'react'
import MaturingBond from './MaturingBond';
import { getBondsByDates } from '../../services/BondServices';
import moment from 'moment';

const AllMaturingBonds = () => {

    //Hardcoded date, later user can select
    var date = "2020/01/01";
    return (
        arr.map(num =>(     
            <MaturingBond info={moment(date, 'YYYY-MM-DD').add(num, 'd').toDate()} key={num} />
        ))
      )
}

export default AllMaturingBonds