import DataTable from 'react-data-table-component';
import { Link } from 'react-router-dom'; 


const columns = [
    {
        name: 'ISIN',
        selector: row => row.isin,
        cell: row => (<a href={row.isin} target="_blank" rel="noopener noreferrer"> {row.isin} </a> ),
    },
    {
        name: 'Maturity Date',
        selector: row => row.maturityDate,
    },
    {
        name: 'Client name',
        selector: row => row.clientName,
    },
    {
        name: 'Issuer',
        selector: row => row.issuer,
    },
    {
        name: 'Type',
        selector: row => row.type,
    },
    {
        name: 'Currency',
        selector: row => row.currency,
    },
    {
        name: 'CUSIP',
        selector: row => row.cusip,
    }
];
const data = [
    {
        isin: 1,
        maturityDate: 2,
        clientName: 3,
        issuer: 4,
        type: 5,
        currency: 6,
        cusip: 7
    },
]
function Table() {
    return (
        <DataTable
            columns={columns}
            data={data}
        />
    );
};

export default Table;