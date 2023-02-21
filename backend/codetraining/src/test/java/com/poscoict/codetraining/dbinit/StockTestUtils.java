package com.poscoict.codetraining.dbinit;

import com.poscoict.codetraining.domain.Item;
import com.poscoict.codetraining.domain.ItemStandard;
import com.poscoict.codetraining.domain.Stock;
import com.poscoict.codetraining.repository.DomesticStockRepository;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.persistence.EntityManager;

public class StockTestUtils {

    public static void addStock(
            TestEntityManager em, DomesticStockRepository domesticStockRepository,
            String stockType) {

        ItemStandard itemStandard;
        Stock stock1 = null;
        Stock stock2 = null;
        Stock stock3 = null;

        if(stockType.equals("국내주식")){
            itemStandard = domesticStockRepository.findStandard("국내주식");
            stock1 = createStock("니나브ICT", 10000L, 20L,"원",itemStandard);
            stock2 = createStock("샤나전자", 9000L, 15L,"원",itemStandard);
            stock3 = createStock("크리스틴엔지니어링", 8000L,15L,"원",itemStandard);
        }

        if(stockType.equals("해외주식")){
            itemStandard = domesticStockRepository.findStandard("해외주식");
            stock1 = createStock("자바컴퍼니", 1000L, 20L,"달러",itemStandard);
            stock2 = createStock("주식회사리액트", 900L, 15L,"달러",itemStandard);
            stock3 =  createStock("MSA엔지니어링", 800L,15L,"달러",itemStandard);
        }
        em.persist(stock1);
        em.persist(stock2);
        em.persist(stock3);
    }

    // 테스트 완료 후 객체 삭제
    public static void deleteStock(EntityManager em,
                                          DomesticStockRepository domesticStockRepository, String stockName) {
        Stock stock = domesticStockRepository.findStock(stockName);
        em.remove(stock);
    }


    private static Stock createStock(String stockName,
                                     Long stockPrice,
                                     Long stockCount,
                                     String moneyUnit,
                                     ItemStandard itemStandard) {

        Stock stock =
                new Stock().builder()
                        .item(new Item().builder()
                                .name(stockName)
                                .price(stockPrice)
                                .count(stockCount)
                                .moneyUnit(moneyUnit)
                                .build())
                        .itemStandard(itemStandard)
                        .build();
        return stock;
    }

}
