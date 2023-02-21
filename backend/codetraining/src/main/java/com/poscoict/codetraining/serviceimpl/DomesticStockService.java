package com.poscoict.codetraining.serviceimpl;

import com.poscoict.codetraining.domain.ItemStandard;
import com.poscoict.codetraining.domain.Stock;
import com.poscoict.codetraining.domain.StockMarket;
import com.poscoict.codetraining.dto.StockDto;
import com.poscoict.codetraining.dto.StockMarketDto;
import com.poscoict.codetraining.repository.DomesticStockRepository;
import com.poscoict.codetraining.service.StockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
    public void insertStock(String name, Long price) {

    }

    @Override
    public Stock findStock(Long id) {
        return null;
    }
}
