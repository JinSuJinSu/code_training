package com.poscoict.codetraining.dbinit;

import com.poscoict.codetraining.domain.ItemStandard;
import com.poscoict.codetraining.repository.DomesticStockRepository;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.persistence.EntityManager;


public class ItemStandardTestUtils {


    // 테스트에 필요한 객체 생성
    public static void addItemStandard(TestEntityManager em, String stockType) {
        ItemStandard itemStandard = null;
        if(stockType.equals("국내주식")){
            itemStandard = createItemStandard("주식", "국내주식","KO","주");
        }
        if(stockType.equals("해외주식")){
            itemStandard = createItemStandard("주식", "해외주식","US","주");
        }
        em.persist(itemStandard);
    }

    // 테스트 완료 후 객체 삭제
    public static void deleteItemStandard(TestEntityManager em,
            DomesticStockRepository domesticStockRepository, String standardName) {
        ItemStandard itemStandard = domesticStockRepository.findStandard(standardName);
        em.remove(itemStandard);
    }

    private static ItemStandard createItemStandard(
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

}
