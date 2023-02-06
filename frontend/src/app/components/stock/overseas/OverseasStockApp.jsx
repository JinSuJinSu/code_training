import { styled } from '@mui/material';
import SimpleCard from 'app/layouts/SimpleCard';

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

const OverseasStockApp = () => {
  return (
    <Container>
      <SimpleCard title="해외주식 재산현황">
        <div>해외주식 재산이다옹</div>
      </SimpleCard>
    </Container>
  );
};

export default OverseasStockApp;
