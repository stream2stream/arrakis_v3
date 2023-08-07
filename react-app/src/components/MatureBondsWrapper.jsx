import React from 'react'
import AllMaturingBonds from './AllMaturingBonds'
import { useState } from 'react';
import DatePicker from "react-datepicker";

const MatureBondsWrapper = () => {
    const [checked, setChecked] = useState(false);
    const [date, setDate] = useState(new Date());


    const handleChange = () => {
      var c = !checked; 
      setChecked(c);
    };

  return (
    <>
    <div>
        <label>
          <input type="checkbox" checked={checked} onChange={handleChange} />
          Show only my books 
        </label>
        <label>
          <DatePicker selected={date} onChange={(date) => setDate(date)} />
        </label>
    </div>

    <div>
      <AllMaturingBonds
      info={checked} key={"key"}/>
    </div>
    </>
  )
}

export default MatureBondsWrapper