package com.poscoict.codetraining;


import com.poscoict.codetraining.dbinit.AssetDbInit;
import com.poscoict.codetraining.dbinit.ItemStandardDbInit;
import com.poscoict.codetraining.dbinit.StockDbInit;
import com.poscoict.codetraining.dbinit.StockMarketDbInit;
import com.poscoict.codetraining.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final ItemStandardDbInit itemStandardDbInit;
    private final StockDbInit stockDbInit;
    private final StockMarketDbInit stockMarketDbInit;
    private final AssetDbInit assetDbInit;

    @PostConstruct
    public void init() {
        itemStandardDbInit.dbInit();
        stockDbInit.dbInit();
        stockMarketDbInit.dbInit();
        assetDbInit.dbInit();
    }

}