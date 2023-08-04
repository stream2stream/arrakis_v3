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
const books2 = [{
  "id":1,
  "name":"Anyone"


},

{
  "id":2,
  "name":"somethingo"


}, ]

  return (
    <div>
      <BooksDetails data={books}></BooksDetails>
    </div>
    
  )
}

export default AllBooks



