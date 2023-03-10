package com.poscoict.codetraining.dto;

import com.poscoict.codetraining.domain.Asset;
import com.poscoict.codetraining.domain.StockMarket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StockMarketDto{

    private long id;
    private String name;
    private long price;
    private long count;
    private long totalPrice;
    private long orderCount;
    private String moneyUnit;

    public StockMarketDto(StockMarket stockMarket) {
        id = stockMarket.getId();
        name = stockMarket.getItem().getName();
        price = stockMarket.getItem().getPrice();
        count = stockMarket.getItem().getCount();
        orderCount = stockMarket.getOrderCount();
        moneyUnit = stockMarket.getItem().getMoneyUnit();
    }
}
