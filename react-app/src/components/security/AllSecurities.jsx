import React from 'react'
import Table from 'react-bootstrap/Table';
import { useState, useEffect } from 'react';
import SecurityDetails from './SecurityDetails';
import { auth } from '../../firebase';
import { getAllSecurities, getUserFromEmail } from '../../services/security-service';
import DateRangePickerOverlay from '../includes/DateRangePickerOverlay';
import { useLocalStore } from "mobx-react-lite";
import { CheckboxDropdown } from '../includes/CheckBoxDropDown';
import { Button } from "react-bootstrap";


const AllSecurities = (props) => {
    const [securities, setSecurities] = useState([]);
    const [error, setError] = useState("");
    const [loaded, setLoaded] = useState(false);
    const [user, setUser] = useState(null);


    const issuerMethod = () => {
        console.log("donnee")
    }
    const issuer = useLocalStore(() => ({
        title: "select issuer",
        method: issuerMethod,
        items: [
            { id: "em", label: "Exact Mass", checked: true },
            { id: "f", label: "Formula", checked: true },
            { id: "mw", label: "Molecular Weight", checked: true },
            { id: "cp1", label: "Custom Property 1", checked: true },
            { id: "cp2", label: "Custom Property 2", checked: true }
        ]
    }));

    const typeMethod = () => {
        console.log("type")
    }
    const type = useLocalStore(() => ({
        title: "select type",
        method: typeMethod,
        items: [
            { id: "em", label: "Exact Mass", checked: true },
            { id: "f", label: "Formula", checked: true },
            { id: "mw", label: "Molecular Weight", checked: true },
            { id: "cp1", label: "Custom Property 1", checked: true },
            { id: "cp2", label: "Custom Property 2", checked: true }
        ]
    }));

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

        },
            [user]
        );

        const applyFilter = (e) => {
            e.preventDefault();
        }

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
                            <div className="date-range-container">
                                <DateRangePickerOverlay />
                            </div>
                            {
                                props.allFilters ? (
                                    <><div className="issuer-name-container">
                                        <div><span className="filter-label">Issuer Name</span></div>
                                        <CheckboxDropdown info={issuer} />
                                    </div>


                                        <div className="type-container">
                                            <div><span className="filter-label">Type</span></div>
                                            <CheckboxDropdown info={type} />
                                        </div>
                                    </>) : <></>
                            }

                            <div className="apply-filter-btn-container">
                                <Button id='btn-filter-white' onClick={applyFilter}>
                                    apply
                                </Button>
                            </div>

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