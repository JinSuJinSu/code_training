import { AssetStore } from "app/components/asset/store/AssetStore";
import { DomesticStockStore } from "app/components/stock/domestic/store/DomesticStockStore";

const AppStore = () => {
  return { AssetStore, DomesticStockStore };
};

export default AppStore;
