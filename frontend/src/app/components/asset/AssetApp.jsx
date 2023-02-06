import SimpleCard from 'app/layouts/SimpleCard';
import { StyleContainer } from './render/StyleContainer';
import AssetContainer from './container/AssetContainer';

const AssetApp = () =>{
  return (
    <StyleContainer>
      <SimpleCard title="나의 현재 자산">
        {/* <div>여기서부터 시작이다</div> */}
        <AssetContainer />
      </SimpleCard>
    </StyleContainer>
  );
};

export default AssetApp;
