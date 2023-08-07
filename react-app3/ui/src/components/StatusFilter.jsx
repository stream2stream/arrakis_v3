import React from 'react';
import Dropdown from 'react-bootstrap/Dropdown';



{/*import React from 'react';
import Dropdown from 'react-bootstrap/Dropdown';
const StatusFilter = ({ filter, onFilterChange }) => {
  // Your filter options
  const filterOptions = ['All', 'Active', 'Inactive'];

  return (
    <div className="StatusFilter">
      {/*<DropdownButton id="filter-dropdown" title={`Status: ${filter}`}>
        {filterOptions.map((option) => (
          <Dropdown.Item key={option} eventKey={option} onSelect={onFilterChange}>
            {option}
          </Dropdown.Item>
        ))
        </DropdownButton>

     <Dropdown>
      <Dropdown.Toggle variant="success" id="dropdown-basic">
        Dropdown Button
      </Dropdown.Toggle>

       <Dropdown.Menu>
        <Dropdown.Item href="#/action-1">All</Dropdown.Item>
        <Dropdown.Item href="#/action-2">Active</Dropdown.Item>
        <Dropdown.Item href="#/action-3">Inactive</Dropdown.Item>
      </Dropdown.Menu>
    </Dropdown>  
    </div>
  );
};

export default StatusFilter;
*/}


function StatusFilter() {
  return (
    <>
    <Dropdown>
      <Dropdown.Toggle variant="success" id="dropdown-basic">
        STATUS
      </Dropdown.Toggle>

      <Dropdown.Menu>
        <Dropdown.Item href="#/action-1">All</Dropdown.Item>
        <Dropdown.Item href="#/action-2">Active</Dropdown.Item>
        <Dropdown.Item href="#/action-3">Inactive</Dropdown.Item>
      </Dropdown.Menu>
    </Dropdown></>
  );
}

export default StatusFilter;