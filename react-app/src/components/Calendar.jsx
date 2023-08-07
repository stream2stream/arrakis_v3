import React from 'react';
import Form from 'react-bootstrap/Form';
import { useState } from 'react';
import { checkDateBonds } from '../services/marturity-service';
import BondTable from './BondTable';
import AllBonds from './AllBonds';

const Calendar = () => {

  const [date, setDate] = useState(new Date());   
  const [bonds, setBonds] = useState([]);


  const updateDate = (event) => {
    setDate(event.target.value)

    checkDateBonds(date)
        .then(res => {
            setBonds(res.data);
        })
        .catch(err => {
            setBonds([]);
        console.log(err);
        })
  } 

  return (
    <div>
        <Form.Control type = "date" value = {date} onChange = {updateDate} />
        <BondTable data = {bonds} />
    </div>
  )
}

export default Calendar
