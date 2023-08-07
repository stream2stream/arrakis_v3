

import React from "react";
import './App.css';
import Page4 from "./components/Page4";
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import LoginPage from './components/LoginPage';
const App = () => {
  return (<div className="App">
     <Router>
      <Switch>
      <Route exact path="/login" component={LoginPage} />
        <Route exact path="/main" component={Page4} />
        {/* Add other routes for different pages if needed */}
      </Switch>
    </Router> 
  <Page4/>
</div>);
};

export default App;

