import { getBondsByDate } from "../services/BondServices";
import { forwardRef, useImperativeHandle, useState } from "react";
import { useEffect } from "react";

const MaturingBondsList = (props) => {
  const [bonds, setDateBonds] = useState([]);

  useEffect(() => {
    getBondsByDateFromAPI();
  }, []);



  const getBondsByDateFromAPI = () => {
    getBondsByDate(props.props)
      .then((res) => {
        setDateBonds(res.data);
      })
      .catch((err) => {
        setDateBonds([]);
        console.log(err);
      });
  };



  const formatDate = (timestamp) => {
    const date = new Date(timestamp);
    const formattedDate = date.toLocaleDateString();
    return formattedDate;
  };



  return (
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
      <tbody>
        {bonds.map((row, index) => (
          <tr key={index}>
            <td>{row.isin}</td>
            <td>{row.type}</td>
            <td>{row.issuerName}</td>
            <td>{formatDate(row.bondMaturityDate)}</td>
            <td>{row.faceValue}</td>
            <td>{row.bondCurrency}</td>
            <td>{row.couponPercent}</td>
            <td>{row.status}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
};

export default MaturingBondsList;
