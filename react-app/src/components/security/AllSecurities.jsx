import React from 'react'
import Table from 'react-bootstrap/Table';
import { useState, useEffect } from 'react';
import SecurityDetails from './SecurityDetails';
import { auth } from '../../firebase';
import { getAllSecurities, getUserFromEmail, getIssuerNames } from '../../services/security-service';
import DateRangePickerOverlay from '../includes/DateRangePickerOverlay';
import { useLocalStore } from "mobx-react-lite";
import { CheckboxDropdown } from '../includes/CheckBoxDropDown';
import { Button } from "react-bootstrap";
import { runInAction } from "mobx"
import BasicDropDown from '../includes/BasicDropdown';
import MyDateRangePicker from '../includes/MyDateRangePicker';

const AllSecurities = (props) => {
    //loading securities
    const [securities, setSecurities] = useState([]);
    const [error, setError] = useState("");
    const [loaded, setLoaded] = useState(false);
    const [user, setUser] = useState(null);

    //FILTER SECURITIES

    //first get list of issuers and types
    const setOfIssuerNames = new Set();
    setOfIssuerNames.add("BNPParibasIssu 4,37% Microsoft Corp (USD)")
    setOfIssuerNames.add("Airbus 3.15%  USD")
    setOfIssuerNames.add("UBS Facebook (USD)")
    setOfIssuerNames.add("Amazon")
    setOfIssuerNames.add("HM Treasury United Kingdon")
    setOfIssuerNames.add("TEMASEK FINL I LTD GLOBAL MEDIUM TERM NTS BOOK ENTRY REG S")
    setOfIssuerNames.add("First Norway Alpha Kl.IV")
    const [selectedIssuerNames, setSelectedIssuerNames] = useState(setOfIssuerNames)



    const [dateRange, setDateRange] = useState({
        startDate: null,
        endDate: null,
        key: "selection",
    });
    const setNewDateRange = (newDateRange) => {
        setDateRange(newDateRange);
    }

    const filterParams = {
        user: user,
        date_range: dateRange,
        issuer_names: selectedIssuerNames,
        types: []
    }

    const issuerMethod = (issuer) => {
        if(selectedIssuerNames.has(issuer)){
            selectedIssuerNames.delete(issuer);
            console.log("deleted")
        }else{
            selectedIssuerNames.add(issuer)
            console.log("added")
        }
        console.log(selectedIssuerNames)
        setSelectedIssuerNames(selectedIssuerNames)
    }


    const issuerItems = useLocalStore(() => ({
        title: "select issuer",
        method: issuerMethod,
        items: [...setOfIssuerNames].map(issuer => ({ id: issuer, label: issuer, checked: true }))
    }));

    const applyFilter = (e) => {
        e.preventDefault();
        console.log(filterParams)
    }

    const getUserFromEmailAPI = () => {
        getUserFromEmail(auth.currentUser.email)
            .then(res => {
                setUser(res.data);
                console.log(res.data)
            })
            .catch(err => {
                setError(err);
                console.log(err);
                setLoaded(false);
            })
    }

    const getAllSecuritiesFromAPI = () => {
        const userId = user.id;
        getAllSecurities(userId)
            .then(res => {
                setLoaded(true);
                setSecurities(res.data);
                setError('');

            })
            .catch(err => {
                setSecurities([]);
                setError(err);
                console.log(err);
                setLoaded(false);
            })
    }

    useEffect(() => {
        getUserFromEmailAPI();
    },
        []
    );
    useEffect(() => {
        if (!user) {
            return;
        }
        getAllSecuritiesFromAPI();
        //getIssuerNamesAPI();

    },
        [user]
    );
    useEffect(() => {
        filterParams.issuer_names = selectedIssuerNames
        if(dateRange.endDate && dateRange.startDate){
            filterParams.date_range = dateRange
            
        }else{
            
        }
        //console.log(filterParams)
        
    },
        [selectedIssuerNames, dateRange]
    );

    if (error && !loaded) {
        return (
            <div className='x'>
                <p>
                    ERROR LOADING SECURITIES
                </p>
            </div>
        )
    }
    if (!loaded && !error) {
        return (
            <div className='x'>
                <p>
                    LOADING SECURITIES
                </p>
            </div>
        )
    }
    if (loaded) {
        return (

            <>
                <div className='securities-filter-container'>

                    <div className='search-bar-container'>
                        <form className='search-form'>
                            <div className="mb-3">
                                <input type="text" className="form-control" placeholder="Search" />
                            </div>
                        </form>
                    </div>
                    <div className='vl-white'></div>

                    <div className='securities-attributes-container'>

                        {
                            props.allFilters ? (
                                <>
                                    <div className="date-range-container">
                                        <DateRangePickerOverlay method={setNewDateRange} />
                                    </div>

                                    <div className="issuer-name-container">
                                        <div><span className="filter-label">Issuer Name</span></div>
                                        <CheckboxDropdown info={issuerItems} />
                                    </div>
                                    {/* <div className="type-container">
                                        <div><span className="filter-label">Type</span></div>
                                        <CheckboxDropdown info={type} />
                                    </div> */
                                    }
                                    <div className="apply-filter-btn-container">
                                        <Button id='btn-filter-white' onClick={applyFilter}>
                                            apply
                                        </Button>
                                    </div>
                                </>) : <></>
                        }



                    </div>
                </div>

                <div className='all-securities-table-container'>
                    <Table striped bordered hover className='all-securities-table'>
                        <thead>
                            <tr>
                                <th>ISIN</th>
                                <th>CUSIP</th>
                                <th>Issuer Name</th>
                                <th>Maturity Date</th>
                                <th>Coupon</th>
                                <th>Type</th>
                                <th>Face Value</th>
                                <th>Currency</th>
                                <th>Status</th>
                            </tr>

                        </thead>
                        <tbody>
                            {
                                securities.map(security => (
                                    < SecurityDetails info={security} key={security.id} />
                                ))
                            }
                        </tbody>
                    </Table>
                </div>
            </>
        )
    }
}


export default AllSecurities