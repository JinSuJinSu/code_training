package com.poscoict.codetraining.serviceimpl;

import com.poscoict.codetraining.domain.Asset;
import com.poscoict.codetraining.dto.AssetDto;
import com.poscoict.codetraining.repository.AssetRepository;
import com.poscoict.codetraining.service.AssetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;

//    @Autowired
//    public AssetServiceImpl(AssetRepository assetRepository) {
//        this.assetRepository = assetRepository;
//    }
    @Override
    public List<AssetDto> getAsset() {
        List<Asset> AssetList = assetRepository.getAsset();
        List<AssetDto> assetDTO = AssetList.stream()
                .map(m -> new AssetDto(m))
                .collect(Collectors.toList());
        return assetDTO;
    }
}
