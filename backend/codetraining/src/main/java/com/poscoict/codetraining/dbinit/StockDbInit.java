package com.poscoict.codetraining.dbinit;

import com.poscoict.codetraining.domain.*;
import com.poscoict.codetraining.domain.Stock;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Component
@Transactional
@RequiredArgsConstructor
@Slf4j
public class StockDbInit {

    private final EntityManager em;

    public void dbInit() {
        ItemStandard itemStandard1 = em.find(ItemStandard.class, 1L);
        ItemStandard itemStandard2 = em.find(ItemStandard.class, 2L);
        User user = em.find(User.class, 1L);
        log.info("생성된 유저 : " + user);

        Stock stock1 =
                createStock("니나브ICT", 10000L, 20L,"원",itemStandard1, user);
        em.persist(stock1);

        Stock stock2 =
                createStock("샤나전자", 9000L, 15L,"원",itemStandard1, user);
        em.persist(stock2);

        Stock stock3 =
                createStock("크리스틴엔지니어링", 8000L,15L,"원",itemStandard1, user);
        em.persist(stock3);

        Stock stock4 =
                createStock("베아트리스CNC", 7000L,13L,"원",itemStandard1, user);
        em.persist(stock4);

        Stock stock5 =
                createStock("실리안전자", 4000L, 20L,"원",itemStandard1, user);
        em.persist(stock5);

        Stock stock6 =
                createStock("라우리엘전자", 4800L, 14L,"원",itemStandard1, user);
        em.persist(stock6);

        Stock stock7 =
                createStock("에아달린테크", 5500L, 17L,"원",itemStandard1, user);
        em.persist(stock7);

        Stock stock8 =
                createStock("마리마리", 6500L, 17L,"원",itemStandard1, user);
        em.persist(stock8);

        Stock stock9 =
                createStock("나기니아네트워크", 8000L, 12L,"원",itemStandard1, user);
        em.persist(stock9);

        Stock stock10 =
                createStock("니나브", 15000L, 11L,"원",itemStandard1, user);
        em.persist(stock10);

        Stock stock11 =
                createStock("자바컴퍼니", 1000L, 20L,"달러",itemStandard2, user);
        em.persist(stock11);

        Stock stock12 =
                createStock("주식회사리액트", 900L, 15L,"달러",itemStandard2, user);
        em.persist(stock12);

        Stock stock13 =
                createStock("MSA엔지니어링", 800L,15L,"달러",itemStandard2, user);
        em.persist(stock13);

        Stock stock14 =
                createStock("도커컨테이너필드", 700L,13L,"달러",itemStandard2, user);
        em.persist(stock14);

        Stock stock15 =
                createStock("파이썬자동차", 400L, 20L,"달러",itemStandard2, user);
        em.persist(stock15);

        Stock stock16 =
                createStock("파이썬전자", 480L, 14L,"달러",itemStandard2, user);
        em.persist(stock16);

        Stock stock17 =
                createStock("파이썬테크", 550L, 17L,"달러",itemStandard2, user);
        em.persist(stock17);

        Stock stock18 =
                createStock("코틀린코틀린", 650L, 17L,"달러",itemStandard2, user);
        em.persist(stock18);

        Stock stock19 =
                createStock("주피터네트워크", 800L, 12L,"달러",itemStandard2, user);
        em.persist(stock19);

        Stock stock20 =
                createStock("주피터코퍼레이션", 1500L, 11L,"달러",itemStandard2, user);
        em.persist(stock20);
    }


    private Stock createStock(String stockName,
                              Long stockPrice,
                              Long stockCount,
                              String moneyUnit,
                              ItemStandard itemStandard,
                              User user) {

        Stock stock =
                new Stock().builder()
                        .item(new Item().builder()
                                .name(stockName)
                                .price(stockPrice)
                                .count(stockCount)
                                .moneyUnit(moneyUnit)
                                .build())
                        .itemStandard(itemStandard)
                        .user(user)
                        .build();
        return stock;
    }

}
