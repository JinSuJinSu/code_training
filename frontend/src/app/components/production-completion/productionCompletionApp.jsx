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

const productionCompletionApp = () => {
  return (
    <Container>
      <SimpleCard title="생산완료 철강 목록">
        <div>생산완료 철강 목록</div>
      </SimpleCard>
    </Container>
  );
};

export default productionCompletionApp;
