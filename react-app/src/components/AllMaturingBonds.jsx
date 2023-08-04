import React from "react";
import MaturingBond from "./MaturingBond";
import moment from "moment";

const AllMaturingBonds = () => {
  //Hardcoded date, later user can select
  var date = "2021/08/05";
  var arr = [-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5];

  return arr.map((num) => (
    <MaturingBond
      info={moment(date, "YYYY-MM-DD").add(num, "d").toDate()}
      key={num}
    />
  ));
};

export default AllMaturingBonds;
