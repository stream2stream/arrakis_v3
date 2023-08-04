import { useState, useEffect } from "react";
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

import NavBar from "../../components/NavBar/NavBar";
import axios from "axios";


function createData(
  ISIN,
  CUSIP,
  Issue_Name,
  Maturity_Date,
  Coupon,
  Type,
  Face_Value,
  Currency,
  Status,
  transactions
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
    transactions
  };
}

function Row(props) {
  const { row } = props;
  const [open, setOpen] = React.useState(false);

  const showCollapse = row.transactions && row.transactions.length > 0;

  return (
    <React.Fragment>
      <TableRow sx={{ "& > *": { borderBottom: "unset" } }}>
        <TableCell>
        {showCollapse && (
          <IconButton
            aria-label="expand row"
            size="small"
            onClick={() => setOpen(!open)}
          >
            {open ? <KeyboardArrowUpIcon /> : <KeyboardArrowDownIcon />}
          </IconButton>
           )}
        </TableCell>
        <TableCell component="th" scope="row">
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
      {showCollapse && (
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
                    <TableCell>Currency</TableCell>
                    <TableCell>Status</TableCell>
                    <TableCell>Unit Price</TableCell>
                    <TableCell>Quantity</TableCell>
                    <TableCell>Buy/Sell</TableCell>
                    <TableCell>Trade Date</TableCell>
                    <TableCell>Settlement Date</TableCell>
                    <TableCell>Book ID</TableCell>
                    <TableCell>Security ID</TableCell>
                    <TableCell>Counterparty ID</TableCell>
                  </TableRow>
                </TableHead>
                <TableBody>
                  {row.transactions.map((transaction) => (
                    <TableRow key={transaction.id}>
                      <TableCell>{transaction.id}</TableCell>
                      <TableCell>{transaction.currency}</TableCell>
                      <TableCell>{transaction.status}</TableCell>
                      <TableCell>{transaction.unitPrice}</TableCell>
                      <TableCell>{transaction.quantity}</TableCell>
                      <TableCell>{transaction.buySell}</TableCell>
                      <TableCell>{transaction.tradeDate}</TableCell>
                      <TableCell>{transaction.settlementDate}</TableCell>
                      <TableCell>{transaction.book_id}</TableCell>
                      <TableCell>{transaction.security_id}</TableCell>
                      <TableCell>{transaction.counterparty_id}</TableCell>
                    </TableRow>
                  ))}
                </TableBody>
              </Table>
            </Box>
          </Collapse>
        </TableCell>
      </TableRow>
       )}
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
        
      })
    ).isRequired,
  }).isRequired,
};

const LandingPage = () => {
  const [page, setPage] = React.useState(0);
  const [rowsPerPage, setRowsPerPage] = React.useState(5);
  const [rows, setRows] = useState([]);

  useEffect(() => {
    // Fetch the data from the API endpoint using Axios
    axios
      .get("http://localhost:8080/api/v1/bonds_transactions")
      .then((response) => {
        const data = response.data;
        // Map the API response to match the structure of createData
        const mappedRows = data.map((item) => {
          const { security, transactions } = item;
          const {
            id,
            isin,
            cusip,
            issuerName,
            maturityDate,
            coupon,
            type,
            faceValue,
            currency,
            status,
          } = security;

          // Map the transactions to history
          const history = transactions.map((transaction) => ({
            id: transaction.id,
           currency: transaction.currency,
           status: transaction.status,
           unitPrice:transaction.unitPrice,
           quantity : transaction.quantity,
           buySell : transaction.buySell,
           tradeDate : transaction.tradeDate,
           settlementDate : transaction.settlementDate,
           book_id : transaction.book_id,
           security_id: transaction.security_id,
           counterparty_id : transaction.counterparty_id
          }));

          return createData(
            isin,
            cusip || "", // Handle null or undefined CUSIP
            issuerName,
            maturityDate,
            coupon,
            type,
            faceValue,
            currency,
            status,
            history
          );
        });

        console.log(mappedRows);
        setRows(mappedRows);
      })
      .catch((error) => {
        console.error("Error fetching data:", error);
      });
  }, []);

  const handleChangePage = (event, newPage) => {
    setPage(newPage);
  };

  const handleChangeRowsPerPage = (event) => {
    setRowsPerPage(parseInt(event.target.value, 10));
    setPage(0);
  };

  return (
    <>
      <NavBar />
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
                <Row key={row.id} row={row} />
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
