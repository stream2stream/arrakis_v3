import React from 'react'
import {useState} from 'react';
import Securities from './security/Securities';
import Trades from './trade/Trades';

const DashBoard = () => {
  const types = ["Bonds", "Trades", "User Management", "Settings"];
  const [active, setActive] = useState(types[0]);

  return (
    <>
      <div className="tabs">
        <div className="tabs-nav">
          {types.map((type) => (
            <div
              className={`${active === type ? "nav-item active" : "nav-item"}`}
              id={type}
              key={type}
              onClick={() => setActive(type)}
            >
              {type}
            </div>
          ))}
        </div>
        <div className="tabs-content">
          {active === "Bonds" && <div className="tab-1"> <Securities /> </div>}
          {active === "Trades" && <div className="tab-2"> <Trades/> </div>}
          {active === "User Management" && <div className="tab-3"> User Management </div>}
          {active === "Settings" && <div className="tab-4"> Settings </div>}
        </div>
      </div>
    </>
    
  )
}

export default DashBoard