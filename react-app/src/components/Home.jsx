import React from 'react';
import '../styles/layout.css'; 
import AllBooks from './AllBooks'
import AllBonds from './AllBonds'
import DateBox from './DateBox'
const Home = () => {
      return (
            <div className="container">
             
                <div className="left-column">
                    <div className='box'>
                       <DateBox></DateBox>
                    </div>
                    <div className='bidnumber'>

                    </div>
               
                </div>
                    
                <div className='table-container'>
                  <div className="right-column">
                    <table>
                         <AllBonds></AllBonds>
                    </table>
                       
                <div className="space-between-tables" />
                    <table>
                        <AllBooks></AllBooks>
                    </table>
                    </div>
                </div>  
                
                </div>                          
      );
      };

      export default Home;

                                    

