import React from "react";
import MaturingBondsList from './MaturingBondsList';
// import MaturingBond from "./MaturingBond";
import moment from "moment";

const AllMaturingBonds = (dateBonds) => {
  //Hardcoded date, later user can select
  var date = "2020/01/01";
  var arr = [-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5];

  const formatDate = (timestamp) => {
    const date = new Date(timestamp);
    const formattedDate = date.toLocaleDateString();
    return formattedDate;
  };

  return arr.map((num) => (

    <table className="table table-striped">
      <thead>
        <tr>
          <th scope="col">ISIN</th>
          <th scope="col">Type</th>
          <th scope="col">Issuer</th>
          <th scope="col">Maturity</th>
          <th scope="col">Face Value</th>
          <th scope="col">Currency</th>
          <th scope="col">Coupon %</th>
          <th scope="col">Status</th>
        </tr>
      </thead>
    </table>

    // <MaturingBond
    //   info={moment(date, "YYYY-MM-DD").add(num, "d").toDate()}
    //   key={num}
    // />
  ));
};

export default AllMaturingBonds;
