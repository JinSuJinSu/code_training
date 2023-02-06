package com.poscoict.codetraining.controller;

import com.poscoict.codetraining.dto.StockDto;
import com.poscoict.codetraining.serviceimpl.StockServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stock")
@RequiredArgsConstructor
public class StockController {

    private final StockServiceImpl stockService;

//    @Autowired
//    public StockController(StockService stockService) {
//        this.stockService = stockService;
//    }

    @GetMapping("/domestic")
    public List<StockDto> getStorage() {
        List<StockDto> stockDtoList = stockService.getStock();
        return stockDtoList;
    }
}