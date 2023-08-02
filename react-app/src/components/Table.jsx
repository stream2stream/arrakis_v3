function Table({ tableData }) {
    return (
      <table className="table">
        <thead>
          <tr>
            <th>ISIN</th>
            <th>Type</th>
            <th>Issuer</th>
            <th>Maturity</th>
            <th>Face Value</th>
            <th>Currency</th>
            <th>Coupon %</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
          {tableData.map((data, index) => {
            return (
              <tr key={index}>
               
                <td>{data.ISIN}</td>
                <td>{data.Type}</td>
                <td>{data.Issuer}</td>
                <td>{data.Maturity}</td>
                <td>{data.Maturity}</td>
                <td>{data.Currency}</td>
                <td>{data.Coupon}</td>
                <td>{data.Status}</td>
              </tr>
            );
          })}
        </tbody>
      </table>
    );
  }
  export default Table;