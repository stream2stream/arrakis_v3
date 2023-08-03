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
import { red } from '@mui/material/colors';
import FavoriteIcon from '@mui/icons-material/Favorite';
import ShareIcon from '@mui/icons-material/Share';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import MoreVertIcon from '@mui/icons-material/MoreVert';
import BondCardTable from './BondCardTable';
import Row from "react-bootstrap/Row";
import { format } from 'date-fns';

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

export default function BondCard({ date, bond }) {
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

  return (
    <Card sx={{ maxWidth: 450 }}>
      <CardHeader title={date} />
      <CardContent>
        <BondCardTable bond={bond} />
      </CardContent>
    </Card>
  );
}