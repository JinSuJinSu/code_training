package com.poscoict.codetraining.mapper;

import com.poscoict.codetraining.domain.Item;
import com.poscoict.codetraining.domain.Item.ItemBuilder;
import com.poscoict.codetraining.domain.StockMarket;
import com.poscoict.codetraining.domain.StockMarket.StockMarketBuilder;
import com.poscoict.codetraining.dto.StockMarketDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-08T21:01:37+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
public class StockMarketMapperImpl implements StockMarketMapper {

    @Override
    public StockMarket toEntity(StockMarketDto dto) {
        if ( dto == null ) {
            return null;
        }

        StockMarketBuilder stockMarket = StockMarket.builder();

        stockMarket.item( stockMarketDtoToItem( dto ) );
        stockMarket.id( dto.getId() );
        stockMarket.orderCount( dto.getOrderCount() );

        return stockMarket.build();
    }

    protected Item stockMarketDtoToItem(StockMarketDto stockMarketDto) {
        if ( stockMarketDto == null ) {
            return null;
        }

        ItemBuilder item = Item.builder();

        item.name( stockMarketDto.getName() );
        item.price( stockMarketDto.getPrice() );
        item.count( stockMarketDto.getCount() );

        return item.build();
    }
}
