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
import { getBondHolderNameById } from '../services/BondService';


export const DialogBox = forwardRef((props, ref) => {
  const [open, setOpen] = React.useState(false);
  const [fullWidth, setFullWidth] = React.useState(true);
  const [maxWidth, setMaxWidth] = React.useState('xl');
  const [bondHolderName, setBondHolderName] = useState('');


  const openDialog = (name) => {
    setBondHolderName(name);
    handleClickOpen();
  };

  useEffect(() => {
    // Fetch the bond holder name when the component mounts or when bondHolderName prop changes.
    if (props.bondHolderName) {
      fetchBondHolderName();
    }
  }, [props.bondHolderName]);

  const fetchBondHolderName = async () => {
    try {
      const name = await getBondHolderNameById(props.bondHolderName);
      setBondHolderName(name);
    } catch (error) {
      console.error('Error fetching bond holder name:', error);
    }
  };

  React.useImperativeHandle(ref, () => ({
    openDialog: (name) => {
      setOpen(true);
      setBondHolderName(name);
    },
  }));

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const handleMaxWidthChange = (event) => {
    setMaxWidth(
      // @ts-expect-error autofill of arbitrary value is not handled.
      event.target.value,
    );
  };

  const handleFullWidthChange = (event) => {
    setFullWidth(event.target.checked);
  };

  return (
    <React.Fragment>
      <Dialog
        fullWidth={fullWidth}
        maxWidth={maxWidth}
        open={open}
        onClose={handleClose}
      >
        <DialogTitle>Bond Holder Name</DialogTitle>
        <DialogContent>
          <DialogContentText>
            {bondHolderName}
          </DialogContentText>
          <Box
            noValidate
            component="form"
            sx={{
              display: 'flex',
              flexDirection: 'column',
              m: 'auto',
              width: 'fit-content',
            }}
          >
           
          </Box>
        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose}>Close</Button>
        </DialogActions>
      </Dialog>
    </React.Fragment>
  );
});