import React from 'react'
import Table from 'react-bootstrap/Table';
import { useState, useEffect } from 'react';
import SecurityDetails from './SecurityDetails';
import DateRangePickerOverlay from '../includes/DateRangePickerOverlay';
import { useLocalStore } from "mobx-react-lite";
import { CheckboxDropdown } from '../includes/CheckBoxDropdown';

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

    useEffect(() => {

    }, []);

    const issuerMethod= ()=>{
        console.log("donnee")
    }
    const issuer = useLocalStore(() => ({
        title:"issuer",
        method: issuerMethod,
        items: [
          { id: "em", label: "Exact Mass", checked: true },
          { id: "f", label: "Formula", checked: true },
          { id: "mw", label: "Molecular Weight", checked: true },
          { id: "cp1", label: "Custom Property 1", checked: true },
          { id: "cp2", label: "Custom Property 2", checked: true }
        ]
      }));

      const typeMethod= ()=>{
        console.log("type")
    }
    const type = useLocalStore(() => ({
        title:"type",
        method: typeMethod,
        items: [
          { id: "em", label: "Exact Mass", checked: true },
          { id: "f", label: "Formula", checked: true },
          { id: "mw", label: "Molecular Weight", checked: true },
          { id: "cp1", label: "Custom Property 1", checked: true },
          { id: "cp2", label: "Custom Property 2", checked: true }
        ]
      }));


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

                    <div className="issuer-name-container">
                        <CheckboxDropdown info={issuer} />
                    </div>

                    <div className="type-container">
                        <CheckboxDropdown info={type} />
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
        </>
    )
}

export default AllSecurities