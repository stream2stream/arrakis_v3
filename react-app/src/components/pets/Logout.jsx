import { NavLink } from "react-router-dom"
import { getAuth } from 'firebase/auth';

const Logout = () => {
    var userAuth = getAuth();
    userAuth.signOut();
    return (
        <div className="container text-center">
            <p className="my-3">You have been signed out.</p>
            <NavLink to="/" className="btn btn-primary">
                Sign in
            </NavLink>
        </div>
    )
}

export default Logout