import React, { useState } from "react";
import { DateRange } from "react-date-range";
import "react-date-range/dist/styles.css"; // main css file
import "react-date-range/dist/theme/default.css"; // theme css file
import { Button, Container, Form } from "react-bootstrap";

const DateRangePickerOverlay = () => {
  const [state, setState] = useState([
    {
      startDate: new Date(),
      endDate: null,
      key: "selection",
    },
  ]);

  const [show, setShow] = useState(false);

  const handleFocus = () => {
    setShow(true);
  };

  const handleSelect = () => {
    setShow(false);
  };

  const handleRangeChange = (item) => {
    setState([item.selection]);
    handleSelect();
  };
  const close = () => {
    setShow(false);
  };

  return (
    <Container className="date-form-picker-container">
      <Form className="date-range-form">
        <Form.Group className="date-range-form-group">
          <Form.Label><span className="filter-label">Start Date</span></Form.Label>
          <Form.Control id="date-range-text-box"
            type="text"
            onFocus={handleFocus}
            value={
              state[0].startDate ? state[0].startDate.toLocaleDateString() : ""
            }
            readOnly
          />
        </Form.Group>
        <Form.Group>
          <Form.Label><span className="filter-label">End Date</span></Form.Label>
          <Form.Control id="date-range-text-box"
            type="text"
            onFocus={handleFocus}
            value={
              state[0].endDate ? state[0].endDate.toLocaleDateString() : ""
            }
            readOnly
          />
        </Form.Group>
      </Form>
      {show && (
        <div className="date-picker-container">
        <Button className="date-picker-close-btn" onClick={close} >X</Button>
        <DateRange
          editableDateInputs={true}
          onChange={handleRangeChange}
          moveRangeOnFirstSelection={false}
          ranges={state}
        />
        </div>
      )}
      {/* <Button onClick={handleSelect}>Select Dates</Button>
      {state[0].startDate && state[0].endDate && (
        <p>
          Selected range: {state[0].startDate.toLocaleDateString()} -{" "}
          {state[0].endDate.toLocaleDateString()}
        </p>
      )} */}
      
    </Container>
  );
};

export default DateRangePickerOverlay;
