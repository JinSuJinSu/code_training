import Loadable from 'app/layouts/Loadable';
import { lazy } from 'react';

const RolllingInstructionApp = Loadable(lazy(() => import('./instruction/RolllingInstructionApp')));
const RolllingPerformanceApp = Loadable(lazy(() => import('./performance/RolllingPerformanceApp')));

const RolllingRoutes = [
  {
    path: '/rolling/instruction',
    element: <RolllingInstructionApp />,
  },
  {
    path: '/rolling/performance',
    element: <RolllingPerformanceApp />,
  },
];

export default RolllingRoutes;
