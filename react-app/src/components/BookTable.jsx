
import React from 'react';

const BookTable = ({ data }) => {
  return (
    <table>
      <thead>
            <th>Id</th>
            <th>Book Name</th>
         
      </thead>
      <tbody>
        {data.map((index) => (
           <tr key={index.id}>
           <td>{index.id}</td>
          <td >{index.bookName}</td>
        
         </tr>
        ))}
      </tbody>
    </table>
  );
};

export default BookTable;