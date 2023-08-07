import React, { useState, useEffect } from "react";
import { findBookusers } from "../services/BookuserServices";

export const Bookusers = () => {
    const [bookusers, setBookusers] = useState([]);

    useEffect(() => {
        findBookusers()
            .then(({data}) => {
            setBookusers(data);
            });
    }, []);
  return (
    <>
        { bookusers.map(bookuser => 
        <div >
            <div>ID: {bookuser.user_id}</div>
            <div>Name: {bookuser.book_id} </div>
        </div>) 
        }
    </>
  )
};
