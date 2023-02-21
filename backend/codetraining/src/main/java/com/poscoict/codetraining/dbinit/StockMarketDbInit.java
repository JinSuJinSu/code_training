package com.poscoict.codetraining.dbinit;

import com.poscoict.codetraining.domain.Item;
import com.poscoict.codetraining.domain.ItemStandard;
import com.poscoict.codetraining.domain.Stock;
import com.poscoict.codetraining.domain.StockMarket;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Component
@Transactional
@RequiredArgsConstructor
@Slf4j
public class StockMarketDbInit {

    private final EntityManager em;

    public void dbInit() {
        ItemStandard itemStandard1 = em.find(ItemStandard.class, 1L);
        ItemStandard itemStandard2 = em.find(ItemStandard.class, 2L);

        StockMarket stock1 =
                createStockMarket("니나브ICT", 10000L, 20L,"원",itemStandard1);
        em.persist(stock1);

        StockMarket stock2 =
                createStockMarket("샤나전자", 9000L, 15L,"원",itemStandard1);
        em.persist(stock2);

        StockMarket stock3 =
                createStockMarket("크리스틴엔지니어링", 8000L,15L,"원",itemStandard1);
        em.persist(stock3);

        StockMarket stock4 =
                createStockMarket("베아트리스CNC", 7000L,13L,"원",itemStandard1);
        em.persist(stock4);

        StockMarket stock5 =
                createStockMarket("실리안전자", 4000L, 20L,"원",itemStandard1);
        em.persist(stock5);

        StockMarket stock6 =
                createStockMarket("라우리엘전자", 4800L, 14L,"원",itemStandard1);
        em.persist(stock6);

        StockMarket stock7 =
                createStockMarket("에아달린테크", 5500L, 17L,"원",itemStandard1);
        em.persist(stock7);

        StockMarket stock8 =
                createStockMarket("마리마리", 6500L, 17L,"원",itemStandard1);
        em.persist(stock8);

        StockMarket stock9 =
                createStockMarket("나기니아네트워크", 8000L, 12L,"원",itemStandard1);
        em.persist(stock9);

        StockMarket stock10 =
                createStockMarket("니나브", 15000L, 11L,"원",itemStandard1);
        em.persist(stock10);

        StockMarket stock11 =
                createStockMarket("자바컴퍼니", 1000L, 20L,"달러",itemStandard2);
        em.persist(stock11);

        StockMarket stock12 =
                createStockMarket("주식회사리액트", 900L, 15L,"달러",itemStandard2);
        em.persist(stock12);

        StockMarket stock13 =
                createStockMarket("MSA엔지니어링", 800L,15L,"달러",itemStandard2);
        em.persist(stock13);

        StockMarket stock14 =
                createStockMarket("도커컨테이너필드", 700L,13L,"달러",itemStandard2);
        em.persist(stock14);

        StockMarket stock15 =
                createStockMarket("파이썬자동차", 400L, 20L,"달러",itemStandard2);
        em.persist(stock15);

        StockMarket stock16 =
                createStockMarket("파이썬전자", 480L, 14L,"달러",itemStandard2);
        em.persist(stock16);

        StockMarket stock17 =
                createStockMarket("파이썬테크", 550L, 17L,"달러",itemStandard2);
        em.persist(stock17);

        StockMarket stock18 =
                createStockMarket("코틀린코틀린", 650L, 17L,"달러",itemStandard2);
        em.persist(stock18);

        StockMarket stock19 =
                createStockMarket("주피터네트워크", 800L, 12L,"달러",itemStandard2);
        em.persist(stock19);

        StockMarket stock20 =
                createStockMarket("주피터코퍼레이션", 1500L, 11L,"달러",itemStandard2);
        em.persist(stock20);
    }

    private StockMarket createStockMarket(String stockName,
                                          Long stockPrice,
                                          Long stockCount,
                                          String moneyUnit,
                                          ItemStandard itemStandard) {

        StockMarket stock =
                new StockMarket().builder()
                        .item(new Item().builder()
                                .name(stockName)
                                .price(stockPrice)
                                .count(stockCount)
                                .moneyUnit(moneyUnit)
                                .build())
                        .itemStandard(itemStandard)
                        .orderCount(0)
                        .build();
        return stock;
    }

}
