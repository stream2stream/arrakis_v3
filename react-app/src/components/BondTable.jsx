import "bootstrap/dist/css/bootstrap.css";
import React, { useState, useEffect } from 'react';
import BootstrapTable from "react-bootstrap-table-next";
import paginationFactory from "react-bootstrap-table2-paginator";
import filterFactory, { textFilter } from 'react-bootstrap-table2-filter';
import { findCounterParty } from "../services/BondServices";

const BondTable = ({ data }) => {
  const [processedData, setProcessedData] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      const newData = await Promise.all(data.map(async bond => {
        const map = {
          "isin": bond["isin"].toString()
        };
        try {
          const res = await findCounterParty(map);
          return { ...bond, Counter_Party: res.data[0] };
        } catch (err) {
          console.log(err);
          return bond;
        }
      }));
      setProcessedData(newData);
    };
    
    fetchData();
  }, [data]);

  const columns = [{
    dataField: "isin",
    text: "ISIN",
    sort: true,
    filter: textFilter(),
  }, {
    dataField: "cusip",
    text: "CUSIP",
    sort: true,
    filter: textFilter(),
  }, {
    dataField: "type",
    text: "Bond Type",
  }, {
    dataField: "issuer_name",
    text: "Issuer",
    headerStyle: { width: '200px' },
    style: { width: '200px' },
  }, {
    dataField: "maturity_date",
    text: "Maturity Date",
    sort: true,
    headerStyle: { width: '150px' },
    style: { width: '150px' },
  }, {
    dataField: "face_value",
    text: "FaceValue",
  }, {
    dataField: "currency",
    text: "Currency",
  }, {
    dataField: "coupon",
    text: "Coupon",
  }, {
    dataField: "status",
    text: "Status",
  },{
    dataField: "Counter_Party",
    text: "Counter Party",
  }
  ];

  return (
    <div>
      <BootstrapTable
        keyField="id"
        data={processedData}
        columns={columns}
        filter={filterFactory()}
        pagination={paginationFactory({ sizePerPage: 5 })}
      />
    </div>
  );
};

export default BondTable;
