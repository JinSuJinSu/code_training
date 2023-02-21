import axios from 'axios';
import { observable, runInAction } from 'mobx';
import { numberLogic } from '../model/DomesticStockModel';

const DomesticStockStore = observable({
  rows : [],
  showDomesticStock(text='ALL') {
    axios.get(`/api/stock/domestic/${text}`)
    .then((response) => {
      runInAction(()=>{
      this.rows = numberLogic(response.data);
    })
  })
  },
});

export { DomesticStockStore };
