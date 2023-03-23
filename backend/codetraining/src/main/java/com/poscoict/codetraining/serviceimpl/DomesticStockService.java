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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        User user = domesticStockRepository.findUser("hjs429");
        Long userTransaction = user.getId(); // getId를 넣었지만 pk는 유저ID가 아닌 유저 Transaction을 사용한다.

        List<Stock> StockList = domesticStockRepository.getStockList(text,id,userTransaction);
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
        StockMarket finalStockMarket = new StockMarket().builder()
                .item(new Item().builder()
                        .name(stockMarket.getItem().getName())
                        .price(stockMarket.getItem().getPrice())
                        .count(stockMarket.getItem().getCount())
                        .moneyUnit("원")
                        .build())
                .itemStandard(itemStandard)
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
        // 날짜 패턴 적용하기
        LocalDateTime dateTime = LocalDateTime.now();
        Order order = OrderMapper.INSTANCE.toEntity(orderDto);
        User user = domesticStockRepository.findUser("hjs429");

        Order finalOrder = new Order().builder()
                .item(new Item().builder()
                        .name(order.getItem().getName())
                        .price(order.getItem().getPrice())
                        .count(order.getItem().getCount())
                        .moneyUnit("원")
                        .build())
                .user(user)
                .status(OrderStatus.ORDER)
                .orderDate(dateTime)
                .build();
        domesticStockRepository.orderStock(finalOrder);
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
