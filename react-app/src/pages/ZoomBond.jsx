import React from "react";
import ZoomBondTable from "../components/ZoomBondTable";
import ZoomTradeTable from "../components/ZoomTradeTable";


const ZoomBond = () => {
  return (
    <div>
      <div>This is the ZoomBondTable</div>
      <ZoomBondTable /> {/* Render the ZoomBondTable component */}
      <div>This is the ZoomTradeTable.</div>
      <ZoomTradeTable /> {/* Render the ZoomBondTable component */}
    </div>
  );
};

export default ZoomBond;
