package com.poscoict.codetraining.dto;

import com.poscoict.codetraining.domain.Asset;
import com.poscoict.codetraining.domain.Stock;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StockDto {

    private long id;
    private String name;
    private long price;
    private long count;
    private long totalPrice;

    public StockDto(Stock stock) {
        id = stock.getId();
        name = stock.getName();
        price = stock.getPrice();
        count = stock.getCount();
        totalPrice = stock.getTotalPrice();
    }
}
