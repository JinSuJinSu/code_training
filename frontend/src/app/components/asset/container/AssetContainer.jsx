import React from 'react';
import { useEffect } from 'react';
import { observer } from 'mobx-react-lite';
import AssetTableView from '../view/AssetTableView';
import AppStore from 'AppStore';

const AssetContainer = observer(() => {
  const [selected, setSelected] = React.useState([]);
  const [page, setPage] = React.useState(0);
  const [rowsPerPage, setRowsPerPage] = React.useState(5);
  const { AssetStore } = AppStore();

  useEffect(() => {
    AssetStore.setAsset();
  }, []);

  const handleSelectAllClick = (event) => {
    if (event.target.checked) {
      const newSelected = AssetStore.rows.map((n) => n.id);
      // const newSelected = rows.map((n) => n.id);
      setSelected(newSelected);
      return;
    }
    setSelected([]);
  };

  const handleClick = (event, id) => {
    const selectedIndex = selected.indexOf(id);
    let newSelected = [];

    if (selectedIndex === -1) {
      newSelected = newSelected.concat(selected, id);
    } else if (selectedIndex === 0) {
      newSelected = newSelected.concat(selected.slice(1));
    } else if (selectedIndex === selected.length - 1) {
      newSelected = newSelected.concat(selected.slice(0, -1));
    } else if (selectedIndex > 0) {
      newSelected = newSelected.concat(
        selected.slice(0, selectedIndex),
        selected.slice(selectedIndex + 1)
      );
    }

    setSelected(newSelected);
  };

  const handleChangePage = (event, newPage) => {
    setPage(newPage);
  };

  const handleChangeRowsPerPage = (event) => {
    setRowsPerPage(parseInt(event.target.value, 10));
    setPage(0);
  };

  const isSelected = (id) => selected.indexOf(id) !== -1;
  return (
    <AssetTableView
      rows={AssetStore.rows}
      // rows={rows}
      page={page}
      setPage={setPage}
      rowsPerPage={rowsPerPage}
      setRowsPerPage={setRowsPerPage}
      handleClick={handleClick}
      handleSelectAllClick={handleSelectAllClick}
      handleChangePage={handleChangePage}
      handleChangeRowsPerPage={handleChangeRowsPerPage}
      selected={selected}
      isSelected={isSelected}
    />
  );
});

export default AssetContainer;
