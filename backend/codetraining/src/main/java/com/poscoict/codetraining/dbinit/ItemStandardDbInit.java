package com.poscoict.codetraining.dbinit;

import com.poscoict.codetraining.domain.ItemStandard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Component
@Transactional
@RequiredArgsConstructor
public class ItemStandardDbInit {

    private final EntityManager em;

    public void dbInit() {
        ItemStandard itemStandard1 =
                createItemStandard("주식", "국내주식","KO","주");
        em.persist(itemStandard1);

        ItemStandard itemStandard2 =
                createItemStandard("주식", "해외주식","US","주");
        em.persist(itemStandard2);

        ItemStandard itemStandard3 =
                createItemStandard("원자재", "금","KO","그램(g)");
        em.persist(itemStandard3);

        ItemStandard itemStandard4 =
                createItemStandard("원자재", "은","KO","그램(g)");
        em.persist(itemStandard4);

        ItemStandard itemStandard5 =
                createItemStandard("현금", "원화","KO","기본(원)");
        em.persist(itemStandard5);

        ItemStandard itemStandard6 =
                createItemStandard("현금", "달러","US","USD");
        em.persist(itemStandard6);

        ItemStandard itemStandard7 =
                createItemStandard("코인", "비트코인","US","coin");
        em.persist(itemStandard7);
    }

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

}
