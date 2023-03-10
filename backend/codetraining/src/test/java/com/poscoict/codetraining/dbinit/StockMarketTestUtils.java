package com.poscoict.codetraining.dbinit;

import com.poscoict.codetraining.domain.Item;
import com.poscoict.codetraining.domain.ItemStandard;
import com.poscoict.codetraining.domain.Stock;
import com.poscoict.codetraining.domain.StockMarket;
import com.poscoict.codetraining.repository.DomesticStockRepository;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.persistence.EntityManager;

public class StockMarketTestUtils {

    public static void addStockMarket(
        TestEntityManager em, DomesticStockRepository domesticStockRepository,
        String stockType){

        ItemStandard itemStandard;
        StockMarket stock1 = null;
        StockMarket stock2 = null;
        StockMarket stock3 = null;

        if(stockType.equals("국내주식")){
            itemStandard = domesticStockRepository.findStandard("국내주식");
            stock1 = createStockMarket("니나브ICT", 10000L, 20L,"원",itemStandard);
            stock2 = createStockMarket("샤나전자", 9000L, 15L,"원",itemStandard);
            stock3 = createStockMarket("크리스틴엔지니어링", 8000L,15L,"원",itemStandard);
        }

        if(stockType.equals("해외주식")){
            itemStandard = domesticStockRepository.findStandard("해외주식");
            stock1 = createStockMarket("자바컴퍼니", 1000L, 20L,"달러",itemStandard);
            stock2 = createStockMarket("주식회사리액트", 900L, 15L,"달러",itemStandard);
            stock3 = createStockMarket("MSA엔지니어링", 800L,15L,"달러",itemStandard);
        }
        em.persist(stock1);
        em.persist(stock2);
        em.persist(stock3);

    }

    private static StockMarket createStockMarket(String stockName,
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
