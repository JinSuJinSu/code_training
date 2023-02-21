package com.poscoict.codetraining.serviceimpl;

import com.poscoict.codetraining.domain.Stock;
import com.poscoict.codetraining.dto.StockDto;
import com.poscoict.codetraining.dto.StockMarketDto;
import com.poscoict.codetraining.repository.OverseasStockRepository;
import com.poscoict.codetraining.service.StockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OverseasStockService implements StockService {

    private final OverseasStockRepository overseasStockRepository;
    @Override
    public List<StockDto> getStockList(String text) {
        return null;
    }

    @Override
    public List<StockMarketDto> getStockMarketList(String text) {
        return null;
    }

    @Override
    public void insertStock(String name, Long price) {

    }

    @Override
    public Stock findStock(Long id) {
        return null;
    }
}
