
import React from 'react';
import { useState } from 'react';
import "bootstrap/dist/css/bootstrap.css";
import "react-bootstrap-table-next/dist/react-bootstrap-table2.min.css";
import BootstrapTable from "react-bootstrap-table-next";
import paginationFactory from "react-bootstrap-table2-paginator";




const columns = [
  {
    dataField: "isin",
    text: "ISIN",
    sort: true
  },
  {
    dataField: "type",
    text: "Bond Type",

  },
  {
    dataField: "issuer",
    text: "Issue"
  },
  {
    dataField: "maturity",
    text: "Maturity",
    sort: true
  },
  
  {
    dataField: "faceValue",
    text: "FaceValue",

  },
  {
    dataField: "currency",
    text: "Currency",
   
  },
  {
    dataField: "coupon",
    text: "coupon",
   
  },
  {
    dataField: "status",
    text: "status",
   
  }
];







const BondTable = ({ data}) => {

  return (
    
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

export default BondTable;