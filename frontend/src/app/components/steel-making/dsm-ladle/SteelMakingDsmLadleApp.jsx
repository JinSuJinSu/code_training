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

const SteelMakingDsmLadleApp = () => {
  return (
    <Container>
      <SimpleCard title="제강 수강래들">
        <div>제강 수강래들</div>
      </SimpleCard>
    </Container>
  );
};

export default SteelMakingDsmLadleApp;
