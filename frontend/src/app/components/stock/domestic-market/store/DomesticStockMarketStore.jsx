import axios from 'axios';
import { observable, runInAction } from 'mobx';
import { numberLogic } from '../model/DomesticStockMarketModel';

const DomesticStockMarketStore = observable({
  rows : [],
  showDomesticStockMarket(text="") {
    axios.get(`/api/stock/domestic/market?text=${text}`)
    .then((response) => {
      runInAction(()=>{
      this.rows = numberLogic(response.data);
    })
  })
  },
});

export { DomesticStockMarketStore };
