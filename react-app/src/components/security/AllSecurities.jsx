import React from 'react'
import Table from 'react-bootstrap/Table';
import { useState, useEffect } from 'react';
import SecurityDetails from './SecurityDetails';
import { getAllSecurities } from '../../services/security-service';

const dummy = [
    {
        id: 'id',
        isin: 111,
        cusip: 222,
        issuerName: 'Just Bond',
        maturityDate: '02.03.2020',
        coupon: 0.2,
        type: 'GOVN',
        faceValue: 'dunno',
        currency: 'USD',
        status: 'active'

    }
]

const AllSecurities = () => {
    const [securities, setSecurities] = useState([]);
    const [error, setError] = useState("");
    const [loaded, setLoaded] = useState(false);


    const getAllSecuritiesFromAPI = () => {
        getAllSecurities([1])
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
        getAllSecuritiesFromAPI();
    },
        []
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
    if (!loaded) {
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
                            dummy.map(security => (
                                < SecurityDetails info={security} key={security.id} />
                            ))
                        }
                    </tbody>
                </Table>
            </div>
        )
    }
}

export default AllSecurities