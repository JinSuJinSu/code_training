package com.poscoict.codetraining.repository;

import com.poscoict.codetraining.domain.Asset;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AssetRepository {
    @PersistenceContext
    private EntityManager em;

    // 현재 저장되어 있는 원료타입별 수량 조회
    public List<Asset> getAsset() {
        return em.createQuery("select asset from Asset asset",
                Asset.class).getResultList();
    }
}
