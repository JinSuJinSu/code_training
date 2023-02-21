import SimpleCard from 'app/layouts/SimpleCard';
import DomesticStockTableContainer from './container/DomesticStockTableContainer';
import DomesticStockSearchContainer from './container/DomesticStockSearchContainer';
import { StyleContainer } from './render/StyleContainer';

const DomesticStockApp = () => {
  return (
    <StyleContainer>
      <SimpleCard title="국내주식 재산현황">
        <DomesticStockSearchContainer/>
        <DomesticStockTableContainer/>
      </SimpleCard>
    </StyleContainer>
  );
};

export default DomesticStockApp;
