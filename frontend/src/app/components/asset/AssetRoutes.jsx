import Loadable from 'app/layouts/Loadable';
import { lazy } from 'react';

const AssetApp = Loadable(
  lazy(() => import('./AssetApp'))
);

const assetRoutes = [
  { path: '/asset', 
    element: <AssetApp /> },
];

export default assetRoutes;
