import { useRoutes } from 'react-router-dom';
import { MatxTheme } from './layouts';
import { SettingsProvider } from './contexts/SettingsContext';
import routes from './routes';


const App = () => {
  const content = useRoutes(routes);

  return (
        <SettingsProvider>
          <MatxTheme>
            {content}
          </MatxTheme>
        </SettingsProvider>
  );
};

export default App;
