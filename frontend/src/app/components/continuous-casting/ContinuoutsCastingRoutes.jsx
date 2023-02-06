import Loadable from 'app/layouts/Loadable';
import { lazy } from 'react';

const ContinuoutsCastingInstructionApp = Loadable(
  lazy(() => import('./instruction/ContinuoutsCastingInstructionApp'))
);
const ContinuoutsCastingPerformanceApp = Loadable(
  lazy(() => import('./performance/ContinuoutsCastingPerformanceApp'))
);

const ContinuoutsCastingRoutes = [
  {
    path: '/continuous-casting/instruction',
    element: <ContinuoutsCastingInstructionApp />,
  },
  {
    path: '/continuous-casting/performance',
    element: <ContinuoutsCastingPerformanceApp />,
  },
];

export default ContinuoutsCastingRoutes;
