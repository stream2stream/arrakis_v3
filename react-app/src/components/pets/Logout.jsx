import { NavLink } from "react-router-dom"

const Logout = () => {
    return (
        <div>
            <p>You have been signed out.</p>

            <NavLink to="/">Sign in</NavLink>
        </div>
    )
}

export default Logout