import React from 'react'
import Table from 'react-bootstrap/Table';
import { useState, useEffect } from 'react';
import SecurityDetails from './SecurityDetails';

const dummy = [
    {
        id:'id',
        isin:111,
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
    return (
        <div>
        <h3> Securities</h3>
        <Table striped bordered hover>
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
                <tr>
                    <td>1</td>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                </tr>
            </tbody>
        </Table>
        </div>
    )
}

export default AllSecurities