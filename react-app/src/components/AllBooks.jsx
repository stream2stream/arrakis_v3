import React from 'react'
import BooksDetails from './BooksDetails'
import { useState } from 'react';
import { useEffect } from 'react';
import {getAllBooks} from '../services/book-service';




const AllBooks = () => {

const [books,setBooks] = useState([]);

useEffect(()=>{
  getBooksFromAPI();}, 
  []
);



const getBooksFromAPI = ()=>{

  getAllBooks()
  .then(res => {
    console.log('data returned from Springboot get API')
   
      setBooks(res.data);
  })
  .catch(err => {
    console.log('when no data returned from Springboot get API')
      setBooks([]);
      console.log(err);
  })

}
// const bonds = [{
//   "id":1,
//   "isin":100,
//   "type":"Sell",
//   "issuer":"Someone",
//   "maturity":15/10/2023,
//   "faceValue": 10.33,
//   "currency": "USD",
//   "coupon":1,
//   "status":"Active"


// },

// {
//   "id":2,
//   "isin":200,
//   "type":"Sell",
//   "issuer":"Someone",
//   "maturity":15/10/2023,
//   "faceValue": 10.33,
//   "currency": "USD",
//   "coupon":1,
//   "status":"Active"


// }
// ]

  return (
    <div>
      <BooksDetails data={books}></BooksDetails>
    </div>
    
  )
}

export default AllBooks



