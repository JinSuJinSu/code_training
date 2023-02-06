import Loadable from 'app/layouts/Loadable';
import { lazy } from 'react';

const DomesticStockApp = Loadable(
  lazy(() => import('./domestic/DomesticStockApp'))
);
const OverseasStockApp = Loadable(
  lazy(() => import('./overseas/OverseasStockApp'))
);

const StockRoutes = [
  {
    path: '/stock/domestic',
    element: <DomesticStockApp />,
  },
  {
    path: '/stock/overseas',
    element: <OverseasStockApp />,
  },
];

export default StockRoutes;
