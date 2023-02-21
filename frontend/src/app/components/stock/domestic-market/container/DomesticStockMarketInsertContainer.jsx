import React from 'react'
import DomesticStockMarketInsertView from '../view/DomesticStocMarketkInsertView'

const DomesticStockMarketInsertContainer = () => {

  const [open, setOpen] = React.useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  return (
    <DomesticStockMarketInsertView
    open={open}
    setOpen={setOpen}
    handleOpen={handleOpen}
    handleClose={handleClose}
    />
  )
}

export default DomesticStockMarketInsertContainer