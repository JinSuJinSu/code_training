import { styled } from '@mui/material';
import SimpleCard from 'app/layouts/SimpleCard';
import DomesticStockContainer from './container/DomesticStockContainer';

const Container = styled('div')(({ theme }) => ({
  margin: '30px',
  [theme.breakpoints.down('sm')]: {
    margin: '16px',
  },
  '& .breadcrumb': {
    marginBottom: '30px',
    [theme.breakpoints.down('sm')]: {
      marginBottom: '16px',
    },
  },
}));

const DomesticStockApp = () => {
  return (
    <Container>
      <SimpleCard title="국내주식 재산현황">
        <DomesticStockContainer/>
      </SimpleCard>
    </Container>
  );
};

export default DomesticStockApp;
