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

const SteelMaking1stRefiningApp = () => {
  return (
    <Container>
      <SimpleCard title="제강 1차정련">
        <div>제강 1차정련</div>
      </SimpleCard>
    </Container>
  );
};

export default SteelMaking1stRefiningApp;
