import * as React from 'react';
import Box from '@mui/material/Box';
import Table from '@mui/material/Table';
import TableContainer from '@mui/material/TableContainer';
import TablePagination from '@mui/material/TablePagination';
import Paper from '@mui/material/Paper';

import AssetTableHeaderView from './AssetTableHeaderView'
import AssetTableBodyView from './AssetTableBodyView';
// This method is created for cross-browser compatibility, if you don't
// need to support IE11, you can use Array.prototype.sort() directly

const AssetTableView = ({
    rows,
    page,
    rowsPerPage,
    handleClick,
    handleSelectAllClick,
    handleChangePage,
    handleChangeRowsPerPage,
    selected,
    isSelected, 
  }) => {
  return (
    <Box sx={{ width: '100%' }}>
      <Paper sx={{ width: '100%', mb: 2 }}>
        <TableContainer>
          <Table sx={{ minWidth: 750 }} aria-labelledby="tableTitle">
            <AssetTableHeaderView
              numSelected={selected.length}
              onSelectAllClick={handleSelectAllClick}
              rowCount={rows.length}
            />
            <AssetTableBodyView
            rows={rows}
            page={page}
            rowsPerPage={rowsPerPage}
            handleClick={handleClick}
            isSelected={isSelected}
            />
          </Table>
        </TableContainer>
        <TablePagination
          rowsPerPageOptions={[5, 10, 25]}
          component="div"
          count={rows.length}
          rowsPerPage={rowsPerPage}
          page={page}
          onPageChange={handleChangePage}
          onRowsPerPageChange={handleChangeRowsPerPage}
        />
      </Paper>
    </Box>
  );
}
export default AssetTableView;
