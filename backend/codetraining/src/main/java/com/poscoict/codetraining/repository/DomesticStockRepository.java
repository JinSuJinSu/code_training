package com.poscoict.codetraining.repository;

import com.poscoict.codetraining.domain.ItemStandard;
import com.poscoict.codetraining.domain.Stock;
import com.poscoict.codetraining.domain.StockMarket;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Slf4j
public class DomesticStockRepository{

    @PersistenceContext
    private EntityManager em;

    // 국내주식 목록 조회
    public List<Stock> getStockList(String text, Long id) {
        return em.createQuery("select stock from Stock stock " +
                                "where stock.itemStandard.id=:id and stock.item.name like : text",
                        Stock.class)
                .setParameter("id",id)
                .setParameter("text","%" + text + "%")
                .getResultList();
    }

    // 국내주식 시장현황 조회
    public List<StockMarket> getStockMarketList(String text, Long id) {
        return em.createQuery("select stockMarket from StockMarket stockMarket " +
                                "where stockMarket.itemStandard.id=:id and stockMarket.item.name like : text",
                        StockMarket.class)
                .setParameter("id",id)
                .setParameter("text","%" + text + "%")
                .getResultList();
    }

    // 규격 정보 조회(테스트용)
    public ItemStandard findStandard(String standardName) {
        return em.createQuery("select itemStandard from ItemStandard itemStandard " +
                        "where itemStandard.name=:name",
                ItemStandard.class)
                .setParameter("name",standardName)
                .getSingleResult();
    }

    // 주식 정보 조회(테스트용)
    public Stock findStock(String stockName) {
        return em.createQuery("select stock from Stock stock " +
                                "where stock.item.name=:name",
                        Stock.class)
                .setParameter("name",stockName)
                .getSingleResult();
    }

    public void insertStock(String name, Long price) {

    }



}
