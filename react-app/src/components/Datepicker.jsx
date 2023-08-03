import React, { useState } from "react";
import DatePicker from "react-datepicker";

import "react-datepicker/dist/react-datepicker.css";
import Button from 'react-bootstrap/Button';

// CSS Modules, react-datepicker-cssmodules.css
import 'react-datepicker/dist/react-datepicker-cssmodules.css';

const Datepicker = () => {
  const [startDate, setStartDate] = useState(new Date());
  return (
    <>
    <Button variant="primary">Today</Button>
    <DatePicker selected={startDate} onChange={(date) => setStartDate(date)} />
    </>
  );

};

export default Datepicker;