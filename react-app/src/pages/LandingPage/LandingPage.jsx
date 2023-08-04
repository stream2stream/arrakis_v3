import { useState } from "react";
import { TablePagination } from "@mui/material";
import "./LandingPage.css";
import * as React from "react";
import PropTypes from "prop-types";
import Box from "@mui/material/Box";
import Collapse from "@mui/material/Collapse";
import IconButton from "@mui/material/IconButton";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Typography from "@mui/material/Typography";
import Paper from "@mui/material/Paper";
import KeyboardArrowDownIcon from "@mui/icons-material/KeyboardArrowDown";
import KeyboardArrowUpIcon from "@mui/icons-material/KeyboardArrowUp";
import { Link, Route, BrowserRouter as Router, Routes } from "react-router-dom";
import DetailPage from "../DetailPage/DetailPage";
import NavBar from "../../components/NavBar/NavBar";
// const LandingPage = () => {
//   const [selectedISIN, setSelectedISIN] = useState(null);

//   const [page, setPage] = useState(0);
//   const [rowsPerPage, setRowsPerPage] = useState(5);

//   const rows = [
//       {
//         ISIN: "US0378331005",
//         CUSIP: "037833100",
//         Issue_Name: "Apple Inc.",
//         Maturity_Date: "01/01/2025",
//         Coupon: "2.45%",
//         Type: "Corporate Bond",
//         Face_Value: "$1000",
//         Currency: "USD",
//         Status: "Active"
//       },
//       // Adaugă mai multe obiecte de acest gen pentru a reprezenta fiecare rând din tabel.
//   ];

//   // Presupunem că ai un array de tranzacții similar
//   const transactions = [
//       {
//         ISIN: "US0378331005",
//         TransactionID: "123456",
//         Date: "01/01/2023",
//         Amount: "1000"
//       },
//       // ...
//   ];

//   const handleChangePage = (event, newPage) => {
//     setPage(newPage);
// };

// const handleChangeRowsPerPage = (event) => {
//     setRowsPerPage(+event.target.value);
//     setPage(0);
// };

// return (
//     <div>
//         <TableContainer component={Paper} className="table">
//         <Table>
//             <TableHead className="header" >
//             <TableRow>
//                 <TableCell>ISIN</TableCell>
//                 <TableCell>CUSIP</TableCell>
//                 <TableCell>Issue Name</TableCell>
//                 <TableCell>Maturity Date</TableCell>
//                 <TableCell>Coupon</TableCell>
//                 <TableCell>Type</TableCell>
//                 <TableCell>Face Value</TableCell>
//                 <TableCell>Currency</TableCell>
//                 <TableCell>Status</TableCell>
//             </TableRow>
//             </TableHead>
//             <TableBody>
//             {rows.slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage).map((row, index) => (
//                 <TableRow key={index} onClick={() => setSelectedISIN(row.ISIN)}>
//                 <TableCell>{row.ISIN}</TableCell>
//                 <TableCell>{row.CUSIP}</TableCell>
//                 <TableCell>{row.Issue_Name}</TableCell>
//                 <TableCell>{row.Maturity_Date}</TableCell>
//                 <TableCell>{row.Coupon}</TableCell>
//                 <TableCell>{row.Type}</TableCell>
//                 <TableCell>{row.Face_Value}</TableCell>
//                 <TableCell>{row.Currency}</TableCell>
//                 <TableCell>{row.Status}</TableCell>
//                 </TableRow>
//             ))}
//             </TableBody>
//             <TablePagination
//                 rowsPerPageOptions={[5, 10, 25]}
//                 component="div"
//                 count={rows.length}
//                 rowsPerPage={rowsPerPage}
//                 page={page}
//                 onPageChange={handleChangePage}
//                 onRowsPerPageChange={handleChangeRowsPerPage}
//             />

//         </Table>
//         </TableContainer>

//         {selectedISIN && (
//         <TableContainer component={Paper} className='table'>
//             <Table>
//             <TableHead>
//                 <TableRow>
//                 <TableCell>Transaction ID</TableCell>
//                 <TableCell>Date</TableCell>
//                 <TableCell>Amount</TableCell>
//                 </TableRow>
//             </TableHead>
//             <TableBody>
//                 {transactions.filter(t => t.ISIN === selectedISIN).map((transaction, index) => (
//                 <TableRow key={index}>
//                     <TableCell>{transaction.TransactionID}</TableCell>
//                     <TableCell>{transaction.Date}</TableCell>
//                     <TableCell>{transaction.Amount}</TableCell>
//                 </TableRow>
//                 ))}
//             </TableBody>
//             </Table>
//         </TableContainer>
//         )}
//     </div>
// );
// }

function createData(
  ISIN,
  CUSIP,
  Issue_Name,
  Maturity_Date,
  Coupon,
  Type,
  Face_Value,
  Currency,
  Status
) {
  return {
    ISIN,
    CUSIP,
    Issue_Name,
    Maturity_Date,
    Coupon,
    Type,
    Face_Value,
    Currency,
    Status,
    history: [
      {
        transactionId: "123456",
        date: "2023-01-01",
        amount: 1000,
      },
      {
        transactionId: "789012",
        date: "2023-02-01",
        amount: 2000,
      },
    ],
  };
}

function Row(props) {
  const { row } = props;
  const [open, setOpen] = React.useState(false);

  return (

    <React.Fragment>
      <TableRow sx={{ "& > *": { borderBottom: "unset" } }}>
        <TableCell>
          <IconButton
            aria-label="expand row"
            size="small"
            onClick={() => setOpen(!open)}
          >
            {open ? <KeyboardArrowUpIcon /> : <KeyboardArrowDownIcon />}
          </IconButton>
        </TableCell>
        <TableCell component="th" scope="row">
          {/* {row.ISIN} */}
          <Link to={`/detail/${row.ISIN}`}>{row.ISIN}</Link>
        </TableCell>
        <TableCell>{row.CUSIP}</TableCell>
        <TableCell>{row.Issue_Name}</TableCell>
        <TableCell>{row.Maturity_Date}</TableCell>
        <TableCell>{row.Coupon}</TableCell>
        <TableCell>{row.Type}</TableCell>
        <TableCell>{row.Face_Value}</TableCell>
        <TableCell>{row.Currency}</TableCell>
        <TableCell>{row.Status}</TableCell>
      </TableRow>
      <TableRow>
        <TableCell style={{ paddingBottom: 0, paddingTop: 0 }} colSpan={10}>
          <Collapse in={open} timeout="auto" unmountOnExit>
            <Box sx={{ margin: 1 }}>
              <Typography variant="h6" gutterBottom component="div">
                Transaction History
              </Typography>
              <Table size="small" aria-label="purchases">
                <TableHead>
                  <TableRow>
                    <TableCell>Transaction ID</TableCell>
                    <TableCell>Date</TableCell>
                    <TableCell align="right">Amount</TableCell>
                  </TableRow>
                </TableHead>
                <TableBody>
                  {row.history.map((historyRow) => (
                    <TableRow key={historyRow.transactionId}>
                      <TableCell component="th" scope="row">
                        {historyRow.transactionId}
                      </TableCell>
                      <TableCell>{historyRow.date}</TableCell>
                      <TableCell align="right">{historyRow.amount}</TableCell>
                    </TableRow>
                  ))}
                </TableBody>
              </Table>
            </Box>
          </Collapse>
        </TableCell>
      </TableRow>
    </React.Fragment>
    
  );
}

Row.propTypes = {
  row: PropTypes.shape({
    ISIN: PropTypes.string.isRequired,
    CUSIP: PropTypes.string.isRequired,
    Issue_Name: PropTypes.string.isRequired,
    Maturity_Date: PropTypes.string.isRequired,
    Coupon: PropTypes.string.isRequired,
    Type: PropTypes.string.isRequired,
    Face_Value: PropTypes.string.isRequired,
    Currency: PropTypes.string.isRequired,
    Status: PropTypes.string.isRequired,
    history: PropTypes.arrayOf(
      PropTypes.shape({
        transactionId: PropTypes.string.isRequired,
        date: PropTypes.string.isRequired,
        amount: PropTypes.number.isRequired,
      })
    ).isRequired,
  }).isRequired,
};

const rows = [
  createData(
    "US0378331005",
    "037833100",
    "Apple Inc.",
    "2025-01-01",
    "2.45%",
    "Corporate Bond",
    "1000",
    "USD",
    "Active"
  ),
  // Add more rows here...
];

const LandingPage = () => {
  const [page, setPage] = React.useState(0);
  const [rowsPerPage, setRowsPerPage] = React.useState(5);

  const handleChangePage = (event, newPage) => {
    setPage(newPage);
  };

  const handleChangeRowsPerPage = (event) => {
    setRowsPerPage(parseInt(event.target.value, 10));
    setPage(0);
  };

  return (
    <>
    <NavBar/>
          <TableContainer component={Paper}>
            <Table aria-label="collapsible table">
              <TableHead>
                <TableRow>
                  <TableCell />
                  <TableCell>ISIN</TableCell>
                  <TableCell>CUSIP</TableCell>
                  <TableCell>Issue Name</TableCell>
                  <TableCell>Maturity Date</TableCell>
                  <TableCell>Coupon</TableCell>
                  <TableCell>Type</TableCell>
                  <TableCell>Face Value</TableCell>
                  <TableCell>Currency</TableCell>
                  <TableCell>Status</TableCell>
                </TableRow>
              </TableHead>
              <TableBody>
                {rows
                  .slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage)
                  .map((row) => (
                    <Row key={row.name} row={row} />
                  ))}
              </TableBody>
              <TablePagination
                rowsPerPageOptions={[5, 10, 25]}
                component="div"
                count={rows.length}
                rowsPerPage={rowsPerPage}
                page={page}
                onPageChange={handleChangePage}
                onRowsPerPageChange={handleChangeRowsPerPage}
              />
            </Table>
          </TableContainer>
          </>
  );
};

export default LandingPage;
