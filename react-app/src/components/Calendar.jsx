import React from 'react';
import Form from 'react-bootstrap/Form';
import { useState } from 'react';
import { checkDateBonds } from '../services/marturity-service';
import BondTable from './BondTable';
import AllBonds from './AllBonds';

const Calendar = () => {

  const [date, setDate] = useState([]);   
  const [bonds, setBonds] = useState([]);


  const updateDate = (event) => {
    setDate(event.target.value)

    checkDateBonds(date)
        .then(res => {
            console.log('data returned from Springboot get API');
            setBonds(res.data);
        })
        .catch(err => {
            console.log('when no data returned from Springboot get API')
            setBonds([]);
        console.log(err);
        })
  } 


  return (
    <div>
        <Form.Control type="date" name="datepic" placeholder="DateRange"
        value={date} onChange={updateDate} />
        <BondTable data = {bonds} />
    </div>
  )
}

export default Calendar
