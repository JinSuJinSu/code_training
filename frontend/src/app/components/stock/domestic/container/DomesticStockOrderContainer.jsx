import React from 'react';
import { useState } from 'react';
import DomesticStockOrderView from '../view/DomesticStockOrderView';
import { DomesticStockStore } from '../store/DomesticStockStore';

const DomesticStockOrderContainer = () => {
  const [searchValue, setSearchValue] = useState('');

  const handleChange = event => {
    setSearchValue(event.target.value);
  }

  const onSearch = () =>{
    const searchText = searchValue === '' ? 'ALL' : searchValue
    DomesticStockStore.showDomesticStock(searchText)
  }

  const inputSearch = (event) => {
    if (event.key === 'Enter'){
      event.preventDefault();
      onSearch();
    }
  }

  return (
    <DomesticStockOrderView
    searchValue={searchValue}
    handleChange={handleChange}
    onSearch={onSearch}
    inputSearch={inputSearch}
    />
  )
};

export default DomesticStockOrderContainer;
