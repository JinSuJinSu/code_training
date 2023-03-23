package com.poscoict.codetraining.repository;

import com.poscoict.codetraining.domain.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository
@Slf4j
public class DomesticStockRepository{

    @PersistenceContext
    private EntityManager em;

    // 국내주식 목록 조회
    public List<Stock> getStockList(String text, Long id, Long userTransaction) {
        return em.createQuery("select stock from Stock stock " +
                                "join stock.user user " +
                                "join stock.itemStandard itemStandard " +
                                "where user.id=:userTransaction " +
                                "and itemStandard.id=:id and stock.item.name like : text",
                        Stock.class)
                .setParameter("userTransaction",userTransaction)
                .setParameter("id",id)
                .setParameter("text","%" + text + "%")
                .getResultList();
    }

    // 국내주식 시장현황 조회
    public List<StockMarket> getStockMarketList(String text, Long id) {
        return em.createQuery("select stockMarket from StockMarket stockMarket " +
                                "join stockMarket.itemStandard itemStandard " +
                                "where itemStandard.id=:id and stockMarket.item.name like : text",
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


    // 주식 추가하기
    public void insertStock(StockMarket stockMarket) {
        em.persist(stockMarket);
    }

    // 주식 매수 주문하기
    public void orderStock(Order order) {
        em.persist(order);
    }


    // 매수 주문한 주식 업데이트 하기
    public int orderUpdateStock(String stockName, long orderCount) {
        return em.createQuery("update StockMarket stockMarket " +
                                "set stockMarket.orderCount = stockMarket.orderCount + :orderCount " +
                                "where stockMarket.item.name=:name")
                .setParameter("name",stockName)
                .setParameter("orderCount",orderCount)
                .executeUpdate();
    }
    // 유저별 주문 정보 조회하기
    public List<Order> findOrders(String userId){
        return em.createQuery("select order from Order order " +
                                "where order.user.userId=:userId",
                        Order.class)
                .setParameter("userId",userId)
                .getResultList();
    }


    // 유저 정보 조회(테스트용)
    public User findUser(String userId) {
        return em.createQuery("select user from User user " +
                                "where user.userId=:userId",
                        User.class)
                .setParameter("userId",userId)
                .getSingleResult();
    }


    // 주식 정보 조회(테스트용)
    public Stock findStock(String stockName) {
        return em.createQuery("select stock from Stock stock" +
                                "where stock.item.name=:name",
                        Stock.class)
                .setParameter("name",stockName)
                .getSingleResult();
    }

    // 주식 시작정보 조회(테스트용)
    public StockMarket findStockMarket(String stockName) {
        return em.createQuery("select stockMarket from StockMarket stockMarket " +
                                "where stockMarket.item.name=:name",
                        StockMarket.class)
                .setParameter("name",stockName)
                .getSingleResult();
    }

    // 주문 정보 조회(테스트용)
    public Order findOrder(String stockName) {
        return em.createQuery("select order from Order order " +
                                "where order.item.name=:name",
                        Order.class)
                .setParameter("name",stockName)
                .getSingleResult();
    }



}
