package com.poscoict.codetraining.repository;

import com.poscoict.codetraining.domain.Item;
import com.poscoict.codetraining.domain.ItemStandard;
import com.poscoict.codetraining.domain.Stock;
import com.poscoict.codetraining.domain.StockMarket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class OverseasStockRepositoryTest {

    @Autowired
    private EntityManager em;

    // 주식 데이터 삽입 메서드
    private Stock createStock(String stockName,
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

    // 데이터 규격 삽입 메서드
    private ItemStandard createItemStandard(
            String ItemCategory, String ItemName, String countryCode, String standardUnit) {

        ItemStandard itemStandard =
                new ItemStandard().builder()
                        .category(ItemCategory)
                        .name(ItemName)
                        .countryCode(countryCode)
                        .standardUnit(standardUnit)
                        .build();
        return itemStandard;
    }

    // 데이터시장 삽입 메서드
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

    @BeforeEach
    public void init() {
        // 아이템 규격 생성
        ItemStandard itemStandard1 =
                createItemStandard("주식", "국내주식","KO","주");
        em.persist(itemStandard1);
        ItemStandard itemStandard2 =
                createItemStandard("주식", "해외주식","US","주");
        em.persist(itemStandard2);
        itemStandard2 = em.find(ItemStandard.class, 2L);

        // 주식 데이터 생성
        Stock stock11 =
                createStock("자바컴퍼니", 1000L, 20L,"달러",itemStandard2);
        em.persist(stock11);

        Stock stock12 =
                createStock("주식회사리액트", 900L, 15L,"달러",itemStandard2);
        em.persist(stock12);

        Stock stock13 =
                createStock("MSA엔지니어링", 800L,15L,"달러",itemStandard2);
        em.persist(stock13);

        StockMarket stockMarket11 =
                createStockMarket("자바컴퍼니", 1000L, 20L,"달러",itemStandard2);
        em.persist(stockMarket11);

        StockMarket stockMarket12 =
                createStockMarket("주식회사리액트", 900L, 15L,"달러",itemStandard2);
        em.persist(stockMarket12);

        StockMarket stockMarket13 =
                createStockMarket("MSA엔지니어링", 800L,15L,"달러",itemStandard2);
        em.persist(stockMarket13);
    }

    @Test
    @DisplayName("해외주식 조회 테스트")
    @Rollback(false)
    void searchStock(){
        // given
        List<Stock> StockList1 = em.createQuery("select stock from Stock stock " +
                                "where stock.itemStandard.id=:id and stock.item.name like : text",
                        Stock.class)
                .setParameter("id",2L)
                .setParameter("text","%" + "" + "%")
                .getResultList();

        List<Stock> StockList2 = em.createQuery("select stock from Stock stock " +
                                "where stock.itemStandard.id=:id and stock.item.name like : text",
                        Stock.class)
                .setParameter("id",2L)
                .setParameter("text","%" + "MSA" + "%")
                .getResultList();
        // when
        int size1 = StockList1.size();
        int size2 = StockList2.size();
        //then
        assertThat(size1).isEqualTo(3);
        assertThat(size2).isEqualTo(1);

    }

    @Test
    @DisplayName("해외주식시장 조회 테스트")
    @Rollback(false)
    void searchStockMarket(){
        // given
        List<StockMarket> StockList1 =em.createQuery("select stockMarket from StockMarket stockMarket " +
                                "where stockMarket.itemStandard.id=:id and stockMarket.item.name like : text",
                        StockMarket.class)
                .setParameter("id",2L)
                .setParameter("text","%" + "" + "%")
                .getResultList();

        List<StockMarket> StockList2 = em.createQuery("select stockMarket from StockMarket stockMarket " +
                                "where stockMarket.itemStandard.id=:id and stockMarket.item.name like : text",
                        StockMarket.class)
                .setParameter("id",2L)
                .setParameter("text","%" + "MSA" + "%")
                .getResultList();
        // when
        int size1 = StockList1.size();
        int size2 = StockList2.size();
        //then
        assertThat(size1).isEqualTo(3);
        assertThat(size2).isEqualTo(1);

    }

}