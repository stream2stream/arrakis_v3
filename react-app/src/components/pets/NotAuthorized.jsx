import { NavLink } from 'react-router-dom'

const NotAuthorized = () => {
    return (
        <>
            <div className="container">
                <h1>Not Authorized</h1>
                <p>You are not authorized to view this page.</p>
            </div>

            <div className="login">
                <NavLink to="/login">
                    <p>Login</p>
                </NavLink>
            </div>
        </>
    );
}

export default NotAuthorized;