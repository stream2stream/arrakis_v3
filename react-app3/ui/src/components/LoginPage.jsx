import React, { useState } from 'react';
import { withRouter } from 'react-router-dom'; // Import withRouter from react-router-dom
import Page4 from './Page4';

const LoginPage = ({ history }) => { // Pass the 'history' prop from withRouter
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [loggedIn, setLoggedIn] = useState(false);

  const handleEmailChange = (e) => {
    setEmail(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // Perform authentication here (e.g., send email and password to a backend)
    // For simplicity, we'll assume the login is successful with any non-empty email and password
    if (email.trim() !== '' && password.trim() !== '') {
      setLoggedIn(true);
      history.push('/main'); // Redirect to the main content page after successful login
    } else {
      alert('Invalid credentials. Please try again.');
    }
  };

  if (loggedIn) {
    return <Page4 />;
  }

  return (
    <div>
      <h1>Login Page</h1>
      <form onSubmit={handleSubmit}>
        {/* ... Login form elements (email, password, and submit button) ... */}
      </form>
    </div>
  );
};

export default withRouter(LoginPage); // Wrap LoginPage with withRouter
