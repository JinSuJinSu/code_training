import Loadable from 'app/layouts/Loadable';
import { lazy } from 'react';

const SteelMakingstructionApp = Loadable(
  lazy(() => import('./instruction/SteelMakingstructionApp'))
);
const SteelMakingPerformanceApp = Loadable(
  lazy(() => import('./performance/SteelMakingPerformanceApp'))
);
const SteelMakingPreTreatmentApp = Loadable(
  lazy(() => import('./pre-treatment/SteelMakingPreTreatmentApp'))
);
const SteelMaking1stRefiningApp = Loadable(
  lazy(() => import('./1st-refining/SteelMaking1stRefiningApp'))
);
const SteelMaking2ndRefiningApp = Loadable(
  lazy(() => import('./2nd-refining/SteelMaking2ndRefiningApp'))
);
const SteelMakingDsmLadleApp = Loadable(lazy(() => import('./dsm-ladle/SteelMakingDsmLadleApp')));
const SteelMakingRefractoryApp = Loadable(
  lazy(() => import('./refractory/SteelMakingRefractoryApp'))
);

const SteelMakingRoutes = [
  {
    path: '/steel-making/instruction',
    element: <SteelMakingstructionApp />,
  },
  {
    path: '/steel-making/performance',
    element: <SteelMakingPerformanceApp />,
  },
  {
    path: '/steel-making/pre-treatment',
    element: <SteelMakingPreTreatmentApp />,
  },
  {
    path: '/steel-making/1st-refining',
    element: <SteelMaking1stRefiningApp />,
  },
  {
    path: '/steel-making/2nd-refining',
    element: <SteelMaking2ndRefiningApp />,
  },
  {
    path: '/steel-making/dsm-ladle',
    element: <SteelMakingDsmLadleApp />,
  },
  {
    path: '/steel-making/refractory',
    element: <SteelMakingRefractoryApp />,
  },
];

export default SteelMakingRoutes;
