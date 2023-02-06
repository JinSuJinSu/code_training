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

const RolllingPerformanceApp = () => {
  return (
    <Container>
      <SimpleCard title="압연 실적등록">
        <div>압연 실적등록</div>
      </SimpleCard>
    </Container>
  );
};

export default RolllingPerformanceApp;
