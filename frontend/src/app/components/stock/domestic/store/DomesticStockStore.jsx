import axios from 'axios';
import { observable, runInAction } from 'mobx';
import { numberLogic } from '../model/DomesticStockModel';

const DomesticStockStore = observable({
  rows : [],
  showDomesticStock() {
    axios.get(`/api/stock/domestic`)
    .then((response) => {
      runInAction(()=>{
      this.rows = numberLogic(response.data);
    })
  })
  },
});

export { DomesticStockStore };
