package com.poscoict.codetraining.controller;

import com.poscoict.codetraining.dto.StockDto;
import com.poscoict.codetraining.dto.StockMarketDto;
import com.poscoict.codetraining.serviceimpl.DomesticStockService;
import com.poscoict.codetraining.serviceimpl.OverseasStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock")
@RequiredArgsConstructor
public class StockController {

    private final DomesticStockService domesticStockService;
    private final OverseasStockService overseasStockService;

//    @Autowired
//    public StockController(StockService stockService) {
//        this.stockService = stockService;
//    }

    // 국내주식 데이터 조회
    @GetMapping("/domestic/{text}")
    public List<StockDto> getDomesticStockList(@PathVariable("text") String text ) {
        String filteredText = text.equals("ALL") ? "" : text; // 검색 조건을 한번 로직 처리
        List<StockDto> stockDtoList = domesticStockService.getStockList(filteredText);
        return stockDtoList;
    }


    // 국내 주식시장 데이터 조회
    @GetMapping("/domestic/market")
    public List<StockMarketDto> getDomesticStockMarket(
            @RequestParam(value="text", defaultValue="") String text){
        List<StockMarketDto> stockDtoMarketList = domesticStockService.getStockMarketList(text);
        return stockDtoMarketList;
    }

    // 국내 주식시장 주식 삽입
    @PostMapping("/domestic/market")
    public void InsertDomesticStock(
            @RequestParam(value="name", defaultValue="") String name,
            @RequestParam(value="price", defaultValue="") Long price){
        domesticStockService.insertStock(name,price);
    }

    // 해외주식 데이터 조회
    @GetMapping("/overseas/{text}")
    public List<StockDto> getOverseasStockList(@PathVariable("text") String text ) {
        String filteredText = text.equals("ALL") ? "" : text; // 검색 조건을 한번 로직 처리
        List<StockDto> stockDtoList = overseasStockService.getStockList(filteredText);
        return stockDtoList;
    }

    // 해외 주식시장 데이터 조회
    @GetMapping("/overseas/market")
    public List<StockMarketDto> getOverseasStockMarket(String text) {
        List<StockMarketDto> stockDtoMarketList = overseasStockService.getStockMarketList(text);
        return stockDtoMarketList;
    }
}