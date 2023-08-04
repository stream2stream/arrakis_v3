import * as React from 'react';
import { useEffect, useState } from "react";
import { styled } from '@mui/material/styles';
import Card from '@mui/material/Card';
import CardHeader from '@mui/material/CardHeader';
import CardMedia from '@mui/material/CardMedia';
import CardContent from '@mui/material/CardContent';
import CardActions from '@mui/material/CardActions';
import Collapse from '@mui/material/Collapse';
import Avatar from '@mui/material/Avatar';
import IconButton from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import { red, green,orange } from '@mui/material/colors';
import FavoriteIcon from '@mui/icons-material/Favorite';
import ShareIcon from '@mui/icons-material/Share';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import MoreVertIcon from '@mui/icons-material/MoreVert';
import BondCardTable from './BondCardTable';
import Row from "react-bootstrap/Row";
import { format, compareAsc } from 'date-fns';


const ExpandMore = styled((props) => {
  const { expand, ...other } = props;
  return <IconButton {...other} />;
})(({ theme, expand }) => ({
  transform: !expand ? 'rotate(0deg)' : 'rotate(180deg)',
  marginLeft: 'auto',
  transition: theme.transitions.create('transform', {
    duration: theme.transitions.duration.shortest,
  }),
}));

export default function BondCard({ date, bond, currentDate }) {
  const [expanded, setExpanded] = React.useState(false);
  const [newDate, setDate ] = React.useState()
  const handleExpandClick = () => {
    setExpanded(!expanded);
  };
  
  useEffect(() => {
    date = setDate(formatDate(date));
  })

  const formatDate = (date) => {
    console.log(date)
    let newDate = new Date()
    try{
      newDate = format(new Date(date), 'dd MMM, YYY')
    }
    catch(error) {
      newDate = null;
    }
    return newDate;
  }
    // Compare the selected date with the current date
    const comparisonResult = compareAsc(new Date(date), new Date(currentDate));

    // Set the card background color based on the comparison result
    let cardColor;
    if (comparisonResult === 0) {
      cardColor = orange[500]; // Orange for the current date
    } else if (comparisonResult === -1) {
      cardColor = red[500]; // Red for dates before the current date
    } else {
      cardColor = green[500]; // Green for dates after the current date
    }
    
  return (
    <Card sx={{ maxWidth: 450, backgroundColor: cardColor }}>
        <CardHeader title={date} />
      <CardContent>
        <BondCardTable bond={bond} date={date} />
      </CardContent>
    </Card>
  );
}