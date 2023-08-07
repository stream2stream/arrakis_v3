
import React, { useState, useEffect } from 'react';
import axios from 'axios';

const Booklist = () => {
  const [buttons, setButtons] = useState([]);

  useEffect(() => {
    // Make a GET request to your Spring Boot backend endpoint
    axios.get('YOUR_SPRING_BOOT_ENDPOINT_URL')
      .then((response) => {
        setButtons(response.data);
      })
      .catch((error) => {
        console.error('Error fetching data:', error);
      });
  }, []);

  return (
    <div>
      <h1>Bond User Book List</h1>
      <div>
        {buttons.map((button) => (
          <a href={button.link} key={button.id}>
            <button>{button.name}</button>
          </a>
        ))}
      </div>
    </div>
  );
};

export default Booklist;