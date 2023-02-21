import React from 'react'
import { Button, Modal, Box, Typography } from '@mui/material'
import { modalStyle } from '../render/StyleContainer'
import styled from '@emotion/styled';

const DomesticStockMarketInsertView = ({
  open,
  setOpen,
  handleOpen,
  handleClose
}) => {
  const MarginStyle = styled('mark')(({ theme }) => ({
  marginLeft: '2em',
}));
  return (
  <>
    <Button 
    variant="contained" 
    size="large"
    onClick={handleOpen}
    >
      항목추가
    </Button>
    <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box sx={modalStyle}>
          <Typography id="modal-modal-description" sx={{ mt: 2 }}>
            모달 입력 해라....
          </Typography>
          
          <Button 
            variant="contained" 
            size="large"
            >
              Insert
          </Button>
          <MarginStyle>
            <Button 
              variant="contained" 
              size="large"
              onClick={handleClose}
              >
                Close
            </Button>
          </MarginStyle>
        </Box>

    </Modal>
  </>
  )
}

export default DomesticStockMarketInsertView