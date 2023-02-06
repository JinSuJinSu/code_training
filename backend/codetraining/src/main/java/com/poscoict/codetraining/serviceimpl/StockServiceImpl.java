package com.poscoict.codetraining.serviceimpl;

import com.poscoict.codetraining.domain.Stock;
import com.poscoict.codetraining.dto.StockDto;
import com.poscoict.codetraining.repository.StockRepository;
import com.poscoict.codetraining.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    //    @Autowired
//    public StockServiceImpl(StockRepository stockRepository) {
//        this.stockRepository = stockRepository;
//    }
    @Override
    public List<StockDto> getStock() {
        List<Stock> StockList = stockRepository.getStock();
        List<StockDto> stockDTO = StockList.stream()
                .map(m -> new StockDto(m))
                .collect(Collectors.toList());
        return stockDTO;
    }
}
