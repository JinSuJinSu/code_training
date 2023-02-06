package com.poscoict.codetraining.controller;

import com.poscoict.codetraining.dto.AssetDto;
import com.poscoict.codetraining.serviceimpl.AssetServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AssetController {

    private final AssetServiceImpl assetService;

//    @Autowired
//    public AssetController(AssetService assetService) {
//        this.assetService = assetService;
//    }

    @GetMapping("/asset")
    public List<AssetDto> getStorage() {
        List<AssetDto> assetDtoList = assetService.getAsset();
        return assetDtoList;
    }
}