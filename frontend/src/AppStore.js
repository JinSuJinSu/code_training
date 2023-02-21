import { AssetStore } from "app/components/asset/store/AssetStore";
import { DomesticStockStore } from "app/components/stock/domestic/store/DomesticStockStore";
import { OverseasStockStore } from "app/components/stock/overseas/store/OverseasStockStore";
import { DomesticStockMarketStore } from "app/components/stock/domestic-market/store/DomesticStockMarketStore";
import { OverseasStockMarketStore } from "app/components/stock/overseas-market/store/OverseasStockMarketStore";

const AppStore = () => {
  return {
    AssetStore,
    DomesticStockStore,
    OverseasStockStore,
    DomesticStockMarketStore,
    OverseasStockMarketStore,
  };
};

export default AppStore;
