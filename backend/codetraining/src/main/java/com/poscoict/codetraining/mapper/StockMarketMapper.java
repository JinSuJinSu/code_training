package com.poscoict.codetraining.mapper;

import com.poscoict.codetraining.domain.StockMarket;
import com.poscoict.codetraining.dto.StockMarketDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface StockMarketMapper {
    StockMarketMapper INSTANCE = Mappers.getMapper(StockMarketMapper.class);
    @Mapping(source = "name", target = "item.name")
    @Mapping(source = "price", target = "item.price")
    @Mapping(source = "count", target = "item.count")
    StockMarket toEntity(StockMarketDto dto);
}
