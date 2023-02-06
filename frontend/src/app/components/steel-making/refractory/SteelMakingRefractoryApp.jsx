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

const SteelMakingRefractoryApp = () => {
  return (
    <Container>
      <SimpleCard title="제강 내화물">
        <div>제강 내화물</div>
      </SimpleCard>
    </Container>
  );
};

export default SteelMakingRefractoryApp;
