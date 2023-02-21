package com.poscoict.codetraining.service;

import com.poscoict.codetraining.domain.Item;
import com.poscoict.codetraining.domain.ItemStandard;
import com.poscoict.codetraining.domain.Stock;
import com.poscoict.codetraining.domain.StockMarket;
import com.poscoict.codetraining.repository.DomesticStockRepository;
import com.poscoict.codetraining.serviceimpl.DomesticStockService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DomesticStockServiceTest {

    @Mock
    DomesticStockRepository domesticStockRepository;

    @InjectMocks
    private DomesticStockService domesticStockService;

    // 주식 데이터 삽입 메서드
    private Stock createStock(String stockName,
                              Long stockPrice,
                              Long stockCount,
                              String moneyUnit,
                              ItemStandard itemStandard) {

        Stock stock =
                new Stock().builder()
                        .item(new Item().builder()
                                .name(stockName)
                                .price(stockPrice)
                                .count(stockCount)
                                .moneyUnit(moneyUnit)
                                .build())
                        .itemStandard(itemStandard)
                        .build();
        return stock;
    }

    // 데이터 규격 삽입 메서드
    private ItemStandard createItemStandard(
            String ItemCategory, String ItemName, String countryCode, String standardUnit) {

        ItemStandard itemStandard =
                new ItemStandard().builder()
                        .category(ItemCategory)
                        .name(ItemName)
                        .countryCode(countryCode)
                        .standardUnit(standardUnit)
                        .build();
        return itemStandard;
    }

    // 데이터시장 삽입 메서드
    private StockMarket createStockMarket(String stockName,
                                          Long stockPrice,
                                          Long stockCount,
                                          String moneyUnit,
                                          ItemStandard itemStandard) {

        StockMarket stock =
                new StockMarket().builder()
                        .item(new Item().builder()
                                .name(stockName)
                                .price(stockPrice)
                                .count(stockCount)
                                .moneyUnit(moneyUnit)
                                .build())
                        .itemStandard(itemStandard)
                        .orderCount(0)
                        .build();
        return stock;
    }





}