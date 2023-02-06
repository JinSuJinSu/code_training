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

const RolllingInstructionApp = () => {
  return (
    <Container>
      <SimpleCard title="압연 작업지시">
        <div>압연 작업지시</div>
      </SimpleCard>
    </Container>
  );
};

export default RolllingInstructionApp;
