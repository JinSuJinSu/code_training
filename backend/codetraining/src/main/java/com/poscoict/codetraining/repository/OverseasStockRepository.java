package com.poscoict.codetraining.repository;

import com.poscoict.codetraining.domain.Stock;
import com.poscoict.codetraining.domain.StockMarket;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class OverseasStockRepository {

    @PersistenceContext
    private EntityManager em;

    // 해외주식 목록 조회
    public List<Stock> getStockList(String text) {
        return em.createQuery("select stock from Stock stock " +
                                "where stock.itemStandard.id=:id and stock.item.name like : text",
                        Stock.class)
                .setParameter("id",2L)
                .setParameter("text","%" + text + "%")
                .getResultList();
    }

    // 해외주식 시장현황 조회
    public List<StockMarket> getStockMarketList(String text) {
        return em.createQuery("select stockMarket from StockMarket stockMarket " +
                                "where stockMarket.itemStandard.id=:id and stockMarket.item.name like : text",
                        StockMarket.class)
                .setParameter("id",2L)
                .setParameter("text","%" + text + "%")
                .getResultList();
    }

    public void insertStock(String name, Long price) {

    }

    public Stock findStock(Long id) {
        return null;
    }
}
