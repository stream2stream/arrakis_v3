import React from 'react';
import '../styles/layout.css'; 
import AllBooks from './components/AllBooks'
const Home = () => {
      return (
            <div className="container">
                <div className="left-column">Left Column Content</div>
                    
                <div className="right-column">
                    <table>
                    <AllBooks></AllBooks>
                        </table>
                    

                    <table>
                        {/* Table 1 content */}
                    </table>
                   
                </div>  
                
                </div>                          
      );
      };

      export default Home;

                                    

