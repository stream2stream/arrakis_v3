import React from 'react'
import LoginForm from './auth/LoginForm'
import DashBoard from './DashBoard'

const Body = (props) => {
    const setUser= ()=> {
        props.setUser();
    }
    return (
        <>
            {props.user? <DashBoard /> : <LoginForm setUser={setUser} />}
        </>
    )
}

export default Body