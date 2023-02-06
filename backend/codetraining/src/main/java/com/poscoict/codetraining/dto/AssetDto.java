package com.poscoict.codetraining.dto;

import com.poscoict.codetraining.domain.Asset;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AssetDto {
    private long id;
    private String name;
    private long price;

    public AssetDto(Asset asset) {
        id = asset.getId();
        name = asset.getName();
        price = asset.getPrice();
    }
}
