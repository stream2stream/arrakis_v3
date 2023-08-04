import * as React from 'react';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
import FormControl from '@mui/material/FormControl';
import FormControlLabel from '@mui/material/FormControlLabel';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import Select from '@mui/material/Select';
import Switch from '@mui/material/Switch';
import { forwardRef, useRef, useState, useEffect } from 'react';
import ZoomBond from '../pages/ZoomBond';
import { getBondHolderNameById, getStatsByBondHolderID } from '../services/BondService';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';

export const DialogBox = forwardRef((props, ref) => {
  const [open, setOpen] = React.useState(false);
  const [fullWidth, setFullWidth] = React.useState(true);
  const [maxWidth, setMaxWidth] = React.useState('xl');
  const [bondHolderName, setBondHolderName] = useState('');
  const [bondHolderStats, setBondHolderStats] = useState(null);

  useEffect(() => {
    if (props.bondHolderName) {
      fetchBondHolderName();
      fetchBondHolderStats();
    }
  }, [props.bondHolderName]);

  const fetchBondHolderStats = async () => {
    try {
      const stats = await getStatsByBondHolderID(props.bondHolderName);
      setBondHolderStats(stats);
    } catch (error) {
      console.error("Error fetching bond holder stats:", error);
      setBondHolderStats(null);
    }
  };

  const fetchBondHolderName = async () => {
    try {
      const name = await getBondHolderNameById(props.bondHolderName);
      setBondHolderName(name);
    } catch (error) {
      console.error('Error fetching bond holder name:', error);
      setBondHolderName(''); // Reset bondHolderName if there's an error
    }
  };

  useEffect(() => {
    setOpen(false); // Reset open state when the component mounts or bondHolderName prop changes
  }, [props.bondHolderName]);

  React.useImperativeHandle(ref, () => ({
    openDialog: (name) => {
      fetchBondHolderName(); // Fetch bond holder name when opening the dialog
      setOpen(true);
    },
  }));

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
    setBondHolderName(''); // Reset bondHolderName when the dialog is closed
  };

  return (
    <React.Fragment>
      <Dialog
        fullWidth
        maxWidth="sm"
        open={open}
        onClose={handleClose}
      >
        <DialogTitle>Bond Holder Name: {bondHolderName}</DialogTitle>
        <DialogContent>
          <TableContainer>
            <Table>
              <TableBody>
                <TableRow>
                  <TableCell component="th" scope="row">
                    Number of Bonds:
                  </TableCell>
                  <TableCell>{bondHolderStats?.bondHolderNumberOfBonds}</TableCell>
                </TableRow>
                <TableRow>
                  <TableCell component="th" scope="row">
                    Current Position:
                  </TableCell>
                  <TableCell>{bondHolderStats?.bondHolderCurrentPosition} USD</TableCell>
                </TableRow>
              </TableBody>
            </Table>
          </TableContainer>
        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose}>Close</Button>
        </DialogActions>
      </Dialog>
    </React.Fragment>
  );
});