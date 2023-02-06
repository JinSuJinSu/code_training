import Loadable from 'app/layouts/Loadable';
import { lazy } from 'react';

const ShipmentInstructionApp = Loadable(lazy(() => import('./instruction/ShipmentInstructionApp')));
const ShipmentPerformanceApp = Loadable(lazy(() => import('./performance/ShipmentPerformanceApp')));

const ShipmentRoutes = [
  {
    path: '/shipment/instruction',
    element: <ShipmentInstructionApp />,
  },
  {
    path: '/shipment/performance',
    element: <ShipmentPerformanceApp />,
  },
];

export default ShipmentRoutes;
