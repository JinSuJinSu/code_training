import React from 'react';
import { useEffect } from 'react';
import { observer } from 'mobx-react-lite';
import AppStore from 'AppStore';
import { columns } from '../render/DomesticStockMarketTableHeader';
import DomesticStockMarketTableView from '../view/DomesticStockMarketTableView';

const DomesticStockMarketTableContainer = observer(() => {

  const [pageSize, setPageSize] = React.useState(5);
  const height = 400;
  const pagingList = [5, 10, 20];
  
  const { DomesticStockMarketStore } = AppStore();

  useEffect(() => {
    DomesticStockMarketStore.showDomesticStockMarket();
  }, []);

  return (
    <DomesticStockMarketTableView
      height={height}
      rows={DomesticStockMarketStore.rows}
      columns={columns}
      pageSize={pageSize}
      setPageSize={setPageSize}
      pagingList={pagingList}
    />
  );
});

export default DomesticStockMarketTableContainer;
