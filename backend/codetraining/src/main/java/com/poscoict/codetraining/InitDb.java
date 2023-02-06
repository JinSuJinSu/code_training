package com.poscoict.codetraining;


import com.poscoict.codetraining.domain.Asset;
import com.poscoict.codetraining.domain.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();
        initService.dbInit2();
    }
    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;

        public void dbInit1() {
            Asset asset1 =
                    createAsset("주식", 10000L);
            em.persist(asset1);

            Asset asset2 =
                    createAsset("원자재", 9000L);
            em.persist(asset2);

            Asset asset3 =
                    createAsset("외화", 8000L);
            em.persist(asset3);

            Asset asset4 =
                    createAsset("비트코인", 7000L);
            em.persist(asset4);

            Asset asset5 =
                    createAsset("현금", 10000L);
            em.persist(asset5);

            Asset asset6 =
                    createAsset("펀드", 10000L);
            em.persist(asset6);

            Asset asset7 =
                    createAsset("연금", 12000L);
            em.persist(asset7);
        }

        public void dbInit2() {
            Stock stock1 =
                    createStock("니나브ICT", 10000L, 20L);
            em.persist(stock1);

            Stock stock2 =
                    createStock("샤나전자", 9000L, 15L);
            em.persist(stock2);

            Stock stock3 =
                    createStock("크리스틴엔지니어링", 8000L,15L);
            em.persist(stock3);

            Stock stock4 =
                    createStock("베아트리스CNC", 7000L,13L);
            em.persist(stock4);

            Stock stock5 =
                    createStock("실리안전자", 4000L, 20L);
            em.persist(stock5);

            Stock stock6 =
                    createStock("라우리엘전자", 4800L, 14L);
            em.persist(stock6);

            Stock stock7 =
                    createStock("에아달린테크", 5500L, 17L);
            em.persist(stock7);

            Stock stock8 =
                    createStock("마리마리", 6500L, 17L);
            em.persist(stock8);

            Stock stock9 =
                    createStock("나기니아네트워크", 8000L, 12L);
            em.persist(stock9);

            Stock stock10 =
                    createStock("니나브", 15000L, 11L);
            em.persist(stock10);
        }



        private Asset createAsset(String assetName,
                                  Long assetPrice) {

            Asset asset =
                    new Asset().builder()
                            .name(assetName)
                            .price(assetPrice)
                            .build();
            return asset;
        }

    private Stock createStock(String stockName,
                              Long stockPrice,
                              Long stockCount) {

        Stock stock =
                new Stock().builder()
                        .name(stockName)
                        .price(stockPrice)
                        .count(stockCount)
                        .totalPrice(stockPrice*stockCount)
                        .build();
        return stock;
    }

    }
}