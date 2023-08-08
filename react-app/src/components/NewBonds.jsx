import React, { useState, useEffect } from "react";
import { findBonds } from "../services/BondServices";
import { Table } from "react-bootstrap";
import "./NewBonds.css"

export const NewBonds = () => {
    const [bonds, setBonds] = useState([]);
    const [deBonds, setDeBonds] = useState([]);

    const getDeBonds = () => {
        const temp = bonds.map(bond => (
            <tr key={bond.id}>
                {Object.values(bond).map((value, index) => (
                    <td key={index}>{value}</td>
                ))}
            </tr>
        ));
        setDeBonds(temp);
    };

    useEffect(() => {
        getDeBonds();
    }, [bonds]);

    useEffect(() => {
        getSecuritiesFromAPI();
    },
        []
    )

    const getSecuritiesFromAPI = () => {
        findBonds()
            .then(res => {
                setBonds(res.data);
            })
            .catch(err => {
                setBonds([]);
                console.log(err);
            })
    }
    return (
        <>
            <div class="table-container">
                <Table responsive className="smaller-table">
                    <thead>
                        {bonds.length > 0 && Object.keys(bonds[0]).map((bondKey, index) => (
                            <th key={index}>{bondKey}</th>
                        ))}
                    </thead>
                    <tbody>
                        {deBonds.length !== 0 && deBonds}
                    </tbody>
                </Table>
            </div>
        </>
    );
}
export default NewBonds;