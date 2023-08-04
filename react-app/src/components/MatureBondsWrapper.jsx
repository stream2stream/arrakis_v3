import React from 'react'
import AllMaturingBonds from './AllMaturingBonds'
import { useState } from 'react';
import { useRef } from 'react';

const MatureBondsWrapper = () => {
    const [checked, setChecked] = useState(false);

    const ref = useRef();

    const handleChange = () => {
      var c = !checked;
      setChecked(c);
      ref.current.getBondsByDateFromAPI();
    };

  return (
    <>
    <div>
        <label>
          <input type="checkbox" checked={checked} onChange={handleChange} />
          Show only my books 
        </label>
    </div>

    <div>
      <AllMaturingBonds
      info={checked} key={"key"}/>
    </div>
    </>
  )
}

export default MatureBondsWrapper