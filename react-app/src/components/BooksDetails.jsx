import React from 'react'
import BookTable  from './BookTable'

const BooksDetails = ({data}) => {
  return (
    <div>
      <BookTable data={data}></BookTable>
    </div>
  )
}

export default BooksDetails
