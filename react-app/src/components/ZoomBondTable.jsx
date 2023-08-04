import * as React from 'react';
import Paper from '@mui/material/Paper';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TablePagination from '@mui/material/TablePagination';
import TableRow from '@mui/material/TableRow';
import { getMaturedBondsByBondTypeAndDate  } from '../services/BondService';
import { useLocation } from 'react-router';
import BondCardTable from './BondCardTable';
import Tooltip from '@mui/material/Tooltip';
import Typography from '@mui/material/Typography';

const columns = [
  { id: 'isin', label: 'ISIN', minWidth: 170 },
  { id: 'type', label: 'Type', minWidth: 100 },
  {
    id: 'issuerID',
    label: 'Issuer',
    minWidth: 170,
    align: 'right',
    format: (value) => value.toLocaleString('en-US'),
  },
  {
    id: 'bondMaturityDate',
    label: 'Maturity Date',
    minWidth: 170,
    align: 'right',
    format: (value) => value.toLocaleString('en-US'),
  },
  {
    id: 'faceValue',
    label: 'Face Value',
    minWidth: 170,
    align: 'right',
    format: (value) => value.toFixed(2),
  },
  {
    id: 'bondCurrency',
    label: 'Currency',
    minWidth: 170,
    align: 'right',
    format: (value) => value.toFixed(2),
  },
  {
    id: 'couponPercent',
    label: 'Coupon %',
    minWidth: 170,
    align: 'right',
    format: (value) => value.toFixed(2),
  },
  {
    id: 'status',
    label: 'Status',
    minWidth: 170,
    align: 'right',
    format: (value) => value.toFixed(2),
  },
  {
    id: 'cusip',
    label: 'CUSIP',
    minWidth: 170,
    align: 'right',
    format: (value) => value.toFixed(2),
  },
];

const issuerName = 'Example';

export default function StickyHeadTable() {
  const [page, setPage] = React.useState(0);
  const [rowsPerPage, setRowsPerPage] = React.useState(10);
  const [rows, setRows] = React.useState([]);
  const location = useLocation();
  const bondType = location?.state?.type;
  const bondDate = location?.state?.date;
  
  React.useEffect(( ) => {
    console.log(bondType);
    console.log(bondDate); 
    const fetchData = async () => {
      try {
        if (bondType) {
          const maturedBonds = await getMaturedBondsByBondTypeAndDate(bondType, bondDate);
          setRows(maturedBonds);
        }
      } catch (error) {
        console.error('Error fetching bonds:', error);
      }
    };
    fetchData();
  }, [bondType, bondDate]);

  const handleChangePage = (event, newPage) => {
    setPage(newPage);
  };

  const handleChangeRowsPerPage = (event) => {
    setRowsPerPage(+event.target.value);
    setPage(0);
  };

  return (
    <div style={{ width: '100%' }}>
      <Paper sx={{ width: '100%', overflow: 'hidden' }}>
        {/* Set a fixed height for the table container */}
        <TableContainer sx={{ maxHeight: 400, overflowY: 'auto' }}>
          <Table stickyHeader aria-label="sticky table">
            <TableHead>
              <TableRow>
                {columns.map((column) => (
                  <TableCell
                    key={column.id}
                    align={column.align}
                    style={{ minWidth: column.minWidth }}
                  >
                    {column.label}
                  </TableCell>
                ))}
              </TableRow>
            </TableHead>
            <TableBody>
              {rows
                .slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage)
                .map((row) => {
                  return (
                    <TableRow hover role="checkbox" tabIndex={-1} key={row.isin}>
                      {columns.map((column) => {
                        const value = row[column.id];
                        return (
                          <TableCell key={column.id} align={column.align}>
                            {column.id === 'issuerID' ? (
                              <Tooltip
                                title={<Typography variant="subtitle1">{issuerName}</Typography>}
                              >
                                <span style={{ fontSize: '16px' }}>{value}</span>
                              </Tooltip>
                            ) : (
                              column.format && typeof value === 'number'
                                ? column.format(value)
                                : value
                            )}
                          </TableCell>
                        );
                      })}
                    </TableRow>
                  );
                })}
            </TableBody>
          </Table>
        </TableContainer>
        {/* Rest of the code */}
      </Paper>
    </div>
  );
}