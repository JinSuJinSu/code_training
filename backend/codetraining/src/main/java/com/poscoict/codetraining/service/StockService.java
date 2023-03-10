package com.poscoict.codetraining.service;

import com.poscoict.codetraining.domain.Stock;
import com.poscoict.codetraining.dto.OrderDto;
import com.poscoict.codetraining.dto.StockDto;
import com.poscoict.codetraining.dto.StockMarketDto;

import java.util.List;

public interface StockService {

    List<StockDto> getStockList(String text);

    List<StockMarketDto> getStockMarketList(String text);

    void insertStock(StockMarketDto stockMarket);

    // 특정 주식 조회
    Stock findStock(Long id);
    
    // 주식 주문
    void orderStock(OrderDto orderDto);
}
