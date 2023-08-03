import React, { useState } from 'react'
import LoginForm from './auth/LoginForm'
import DashBoard from './DashBoard'
import { useEffect } from 'react'
import { auth } from '../firebase'
import { onAuthStateChanged } from 'firebase/auth'



const Body = (props) => {
    const [currentUser, setCurrentUser] = useState(null)
    
    useEffect(()=>{
        onAuthStateChanged(auth, (user) => {
            if (user) {
                setCurrentUser(user)
              // User is signed in, see docs for a list of available properties
              // https://firebase.google.com/docs/reference/js/firebase.User
              const uid = user.uid;
              // ...
              console.log("uid", uid)
            } else {
              setCurrentUser(null);
              console.log("user is logged out")
            }
          })});
    const setUser= ()=> {
        props.setUser();
    }
    return (
        <>
            {currentUser? <DashBoard /> : <LoginForm setUser={setUser} />}
        </>
    )
}

export default Body