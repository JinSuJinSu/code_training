import axios from 'axios';
import { observable, runInAction } from 'mobx';
import { numberLogic } from '../model/AssetModel';

const AssetStore = observable({
  rows : [],
  setAsset() {
    axios.get(`/api/asset`)
    .then((response) => {
      runInAction(()=>{
      this.rows = numberLogic(response.data);
    })
  })
  },
});

export { AssetStore };
