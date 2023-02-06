import Loadable from 'app/layouts/Loadable';
import { lazy } from 'react';

const ProductionCompletionApp = Loadable(lazy(() => import('./productionCompletionApp')));

const productionCompletionRoutes = [
  {
    path: '/production/completion',
    element: <ProductionCompletionApp />,
  },
];

export default productionCompletionRoutes;
