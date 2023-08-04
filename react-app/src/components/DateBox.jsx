
import { useState } from "react";
import { useEffect } from "react";
const DateBox = () => {
    const [formattedDate, setFormattedDate] = useState('');
  
    useEffect(() => {
      updateDate();
    }, []);
  
    const updateDate = () => {
      const currentDate = new Date();
      const options = {
        weekday: 'long', // 'short', 'narrow'
        year: 'numeric',
        month: 'long', // 'short', 'narrow'
        day: 'numeric'
      };
      setFormattedDate(currentDate.toLocaleDateString('en-US', options));
    };
  
    return (
      <div className="box">
        <div className="header">Date</div>
        <div className="content">{formattedDate}</div>
      </div>
    );
  };
  
export default DateBox
  

  
  
  
  
  
  