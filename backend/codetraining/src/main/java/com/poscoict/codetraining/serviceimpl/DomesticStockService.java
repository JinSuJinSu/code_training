package com.poscoict.codetraining.serviceimpl;

import com.poscoict.codetraining.domain.*;
import com.poscoict.codetraining.dto.OrderDto;
import com.poscoict.codetraining.dto.StockDto;
import com.poscoict.codetraining.dto.StockMarketDto;
import com.poscoict.codetraining.enumration.OrderStatus;
import com.poscoict.codetraining.mapper.OrderMapper;
import com.poscoict.codetraining.mapper.StockMarketMapper;
import com.poscoict.codetraining.repository.DomesticStockRepository;
import com.poscoict.codetraining.service.StockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DomesticStockService implements StockService {

    private final DomesticStockRepository domesticStockRepository;

    //    @Autowired
//    public DomesticStockService(StockRepository stockRepository) {
//        this.stockRepository = stockRepository;
//    }

    @Override
    public List<StockDto> getStockList(String text) {
        ItemStandard itemStandard = domesticStockRepository.findStandard("국내주식");
        Long id = itemStandard.getId();
        List<Stock> StockList = domesticStockRepository.getStockList(text,id);
        List<StockDto> stockDTO = StockList.stream()
                .map(m -> new StockDto(m))
                .collect(Collectors.toList());
        return stockDTO;
    }

    @Override
    public List<StockMarketDto> getStockMarketList(String text) {
        ItemStandard itemStandard = domesticStockRepository.findStandard("국내주식");
        Long id = itemStandard.getId();
        List<StockMarket> StockMarketList = domesticStockRepository.getStockMarketList(text, id);
        List<StockMarketDto> stockMarketDto = StockMarketList.stream()
                .map(m -> new StockMarketDto(m))
                .collect(Collectors.toList());
        return stockMarketDto;
    }

    @Override
    @Transactional
    public void insertStock(StockMarketDto stockMarketDto) {
        StockMarket stockMarket = StockMarketMapper.INSTANCE.toEntity(stockMarketDto);
        ItemStandard itemStandard = domesticStockRepository.findStandard("국내주식");
        Long id = itemStandard.getId();
        StockMarket finalStockMarket = new StockMarket().builder()
                .item(new Item().builder()
                        .name(stockMarket.getItem().getName())
                        .price(stockMarket.getItem().getPrice())
                        .count(stockMarket.getItem().getCount())
                        .moneyUnit("원")
                        .build())
                .itemStandard(new ItemStandard().builder()
                        .id(id)
                        .build())
                .build();
        domesticStockRepository.insertStock(finalStockMarket);
    }

    @Override
    public Stock findStock(Long id) {
        return null;
    }

    @Override
    @Transactional
    // 주식 주문하기
    public void orderStock(OrderDto orderDto) {
        Order order = OrderMapper.INSTANCE.toEntity(orderDto);
        Order finalOrder = new Order().builder()
                .item(new Item().builder()
                        .name(order.getItem().getName())
                        .price(order.getItem().getPrice())
                        .count(order.getItem().getCount())
                        .moneyUnit("원")
                        .build())
                .user(new User().builder()
                        .userId(order.getUser().getUserId())
                        .build())
                .status(OrderStatus.ORDER)
                .build();
        domesticStockRepository.orderStock(order);
        String stockName = orderDto.getName();
        long orderCount = orderDto.getCount();
        domesticStockRepository.orderUpdateStock(stockName, orderCount);
    }

    // 매수 주문 완료된 주식 조회
    public List<OrderDto> findOrders(String userId){
        List<Order> orderList = domesticStockRepository.findOrders(userId);
        List<OrderDto> orderDtoList = orderList.stream()
                .map(m -> OrderMapper.INSTANCE.toDto(m))
                .collect(Collectors.toList());
        return orderDtoList;
    }
}
