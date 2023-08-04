
import React from 'react';

import { useState } from 'react';
import "bootstrap/dist/css/bootstrap.css";
import "react-bootstrap-table-next/dist/react-bootstrap-table2.min.css";
import BootstrapTable from "react-bootstrap-table-next";
import paginationFactory from "react-bootstrap-table2-paginator";

const BookTable = ({ data }) => {

  const columns = [
    {
      dataField: "id",
      text: "Id",
      sort: true
    },
    {
      dataField: "bookName",
      text: "Book Name",
  
    },
    
  ];
  return (
    // <table>
    //   <thead>
    //         <th>Id</th>
    //         <th>Book Name</th>
         
    //   </thead>
    //   <tbody>
    //     {data.map((index) => (
    //        <tr key={index.id}>
    //        <td>{index.id}</td>
    //       <td >{index.bookName}</td>
        
    //      </tr>
    //     ))}
    //   </tbody>
    // </table>


    <div className="App">
      <BootstrapTable
        bootstrap4
        keyField="id"
        data={data}
        columns={columns}
        pagination={paginationFactory({ sizePerPage: 5 })}
      />
    </div>
  );
};

export default BookTable;