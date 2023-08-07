//import React from "react";
import React, { useState } from 'react';
import StatusFilter from './StatusFilter';

const Page4 = () => {
  const [filter, setFilter] = useState('All');
  const columns = [
    "ISIN",
    "Type",
    "Issuer",
    "Maturity",
    "Face Value",
    "Currency",
    "Coupon %",
    "Status",
  ];

  const data = [
    {
      ISIN: "US1234567890",
      Type: "Bond",
      Issuer: "ABC Corp",
      Maturity: "2025-08-01",
      "Face Value": "1000",
      Currency: "USD",
      "Coupon %": "5.00",
      Status: "Active",
    },
    {
      ISIN: "GB9876543210",
      Type: "Equity",
      Issuer: "XYZ Inc",
      Maturity: "N/A",
      "Face Value": "N/A",
      Currency: "GBP",
      "Coupon %": "N/A",
      Status: "Inactive",
    },
   
    {
      ISIN: "US1234567890",
      Type: "Bond",
      Issuer: "ABC Corp",
      Maturity: "2025-08-01",
      "Face Value": "1000",
      Currency: "USD",
      "Coupon %": "5.00",
      Status: "Active",
    },
    {
      ISIN: "GB9876543210",
      Type: "Equity",
      Issuer: "XYZ Inc",
      Maturity: "N/A",
      "Face Value": "N/A",
      Currency: "GBP",
      "Coupon %": "N/A",
      Status: "Inactive",
    },
   
  ];

  // Function to handle filter change
  const handleFilterChange = (selectedFilter) => {
    setFilter(selectedFilter);
    console.log("hello");
    console.log(selectedFilter)
  };

  // Filtered data based on the selected filter
  const filteredData =
    filter === 'All'
     ? data
       :data.filter((item) => item.Status === filter);

  return (
    <div>
      <h2>Page4</h2>
      <div>
      <StatusFilter filter={filter} onFilterChange={handleFilterChange} />
      </div>
      <table>
        <thead>
          <tr>
            {columns.map((column, index) => (
              <th key={index}>{column}</th>
            ))}
          </tr>
        </thead>
        <tbody>
          {data.map((row, rowIndex) => (
          <tr key={rowIndex}>
            {columns.map((column) => (
              <td key={column}>{row[column]}</td>
            ))}
          </tr>
        ))}
        </tbody>
      </table>
    </div>
  );
};

export default Page4;


// You can add data to the table body dynamically later using state, props, or by fetching data from an API, depending on your application's needs.






