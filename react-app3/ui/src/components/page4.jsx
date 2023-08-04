import React from "react";

const Page4 = () => {
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
   
  ];

  return (
    <div>
      <h2>Page4</h2>
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






