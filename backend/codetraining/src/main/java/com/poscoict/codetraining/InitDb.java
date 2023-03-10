package com.poscoict.codetraining;


import com.poscoict.codetraining.dbinit.*;
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
    private final UserDbInit userDbInit;

    @PostConstruct
    public void init() {
        itemStandardDbInit.dbInit();
        stockDbInit.dbInit();
        stockMarketDbInit.dbInit();
        assetDbInit.dbInit();
        userDbInit.dbInit();

    }

}