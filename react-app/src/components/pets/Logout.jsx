import { NavLink } from "react-router-dom"
import { getAuth } from 'firebase/auth';

const Logout = () => {
    var userAuth = getAuth();
    userAuth.signOut();
    return (
        <div>
            <p>You have been signed out.</p>

            <NavLink to="/">Sign in</NavLink>
        </div>
    )
}

export default Logout