import assetRoutes from './components/asset/AssetRoutes';
import StockRoutes from './components/stock/StockRoutes';
import ContinuoutsCastingRoutes from './components/continuous-casting/ContinuoutsCastingRoutes';
import RolllingRoutes from './components/rollling/RolllingRoutes';
import ShipmentRoutes from './components/shipment/ShipmentRoutes';
import SteelMakingRoutes from './components/steel-making/SteelMakingRoutes';
import productionCompletionRoutes from './components/production-completion/productionCompletionRoutes';
import { Navigate } from 'react-router-dom';
import MatxLayout from './layouts/MatxLayout/MatxLayout';

const routes = [
  {
    element: (
        <MatxLayout />
    ),
    children: [
      ...assetRoutes,
      ...StockRoutes,
      ...ContinuoutsCastingRoutes,
      ...RolllingRoutes,
      ...ShipmentRoutes,
      ...productionCompletionRoutes,
      ...SteelMakingRoutes,
    ],
  },
  { path: '/', element: <Navigate to="/asset" /> },
];

export default routes;
