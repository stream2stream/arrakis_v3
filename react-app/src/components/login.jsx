import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { login } from "../services/TradeServices";

const Login = ({userID, setUserID}) => {
    const [username, setUsername] = useState("")
    const [password, setPassword] = useState("")
    const [usernameError, setUsernameError] = useState("")
    const [passwordError, setPasswordError] = useState("")
    
    const navigate = useNavigate();
        
    const onButtonClick = () => {
        setUsernameError("")
        setPasswordError("")

        if ("" === username) {
            setUsernameError("please enter your username")
            return
        }

        if (!/^[A-Za-z0-9]*$/.test(username)) {
            setUsernameError("invalid username")
            return
        }

        if ("" === password) {
            setPasswordError("please enter your password")
            return
        }

        login(username, password)
            .then(res => {
                console.log("Login response: " + res.data);
                setUserID(res.data);
                navigate("/home")
            })
            .catch(err => {
                console.log("Login error response: " + err);
                setUserID(0);
        })
    }

    return <div className={"mainContainer"}>
        <div className={"titleContainer"}>
            <div>Login</div>
        </div>
        <br />
        <div className={"inputContainer"}>
            <input
                value={username}
                placeholder="username"
                onChange={ev => setUsername(ev.target.value)}
                className={"inputBox"} />
            <label className="errorLabel">{usernameError}</label>
        </div>
        <br />
        <div className={"inputContainer"}>
            <input
                value={password}
                placeholder="password"
                type="password"
                onChange={ev => setPassword(ev.target.value)}
                className={"inputBox"} />
            <label className="errorLabel">{passwordError}</label>
        </div>
        <br />
        <div className={"inputContainer"}>
            <input
                className={"inputButton"}
                type="button"
                onClick={onButtonClick}
                value={"Log in"} />
        </div>
    </div>
}

export default Login