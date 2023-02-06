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

const ContinuoutsCastingPerformanceApp = () => {
  return (
    <Container>
      <SimpleCard title="연주 실적등록">
        <div>연주 실적등록</div>
      </SimpleCard>
    </Container>
  );
};

export default ContinuoutsCastingPerformanceApp;
