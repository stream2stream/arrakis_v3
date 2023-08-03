import React from "react";
import MaturingBond from "./MaturingBonds";
import moment from "moment";

const AllMaturingBonds = () => {
  //Hardcoded date, later user can select
  var date = "2020/01/01";
  var arr = [-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5];

  return arr.map((num) => (
    <MaturingBond
      info={moment(date, "YYYY-MM-DD").add(num, "d").toDate()}
      key={num}
    />
  ));
};

export default AllMaturingBonds;
