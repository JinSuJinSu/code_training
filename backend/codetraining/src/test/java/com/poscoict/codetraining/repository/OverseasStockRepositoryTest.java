package com.poscoict.codetraining.repository;

import com.poscoict.codetraining.dbinit.ItemStandardTestUtils;
import com.poscoict.codetraining.dbinit.StockMarketTestUtils;
import com.poscoict.codetraining.dbinit.StockTestUtils;
import com.poscoict.codetraining.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ComponentScan(basePackages = "com.poscoict.codetraining.repository")
class OverseasStockRepositoryTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private DomesticStockRepository domesticStockRepository;

    @BeforeEach
    public void init() {
        System.out.println("데이터 삽입 시작");
        ItemStandardTestUtils.addItemStandard(em, "해외주식");
        // 객체가 Entity로 매핑되어 있어서 단순 삽입으로는 확인이 어려움
        // 삽입하는 데이터는 해당 클래스의 메소드 참조
        StockTestUtils.addStock(em, domesticStockRepository, "해외주식");
        StockMarketTestUtils.addStockMarket(em, domesticStockRepository, "해외주식");
    }

    @Test
    @DisplayName("해외주식 조회 테스트")
    void searchStock(){
        // given
        // 아이템 규격부터 조회하자(직접 id로 접근하는 것은 상당히 위험한 코드)
        // 규격 조회 후 해당 객체의 id를 넣어주자
        ItemStandard itemStandard = domesticStockRepository.findStandard("해외주식");
        Long id = itemStandard.getId();
        User user = domesticStockRepository.findUser("hjs429");
        Long userTransaction = user.getId(); // getId를 넣었지만 pk는 유저ID가 아닌 유저 Transaction을 사용한다.

        List<Stock> StockList1 = domesticStockRepository.getStockList("",id,userTransaction);
        List<Stock> StockList2 = domesticStockRepository.getStockList("자바",id,userTransaction);
        // when
        int size1 = StockList1.size();
        int size2 = StockList2.size();
        //then
        assertThat(size1).isEqualTo(3);
        assertThat(size2).isEqualTo(1);

    }

    @Test
    @DisplayName("해외주식시장 조회 테스트")
    void searchStockMarket(){
        // given
        // 아이템 규격부터 조회하자(직접 id로 접근하는 것은 상당히 위험한 코드)
        // 규격 조회 후 해당 객체의 id를 넣어주자
        ItemStandard itemStandard = domesticStockRepository.findStandard("해외주식");
        Long id = itemStandard.getId();
        System.out.println("아이디 : " + id);

        List<StockMarket> StockList1 = domesticStockRepository.getStockMarketList("",id);
        List<StockMarket> StockList2 = domesticStockRepository.getStockMarketList("자바",id);

        System.out.println("StockList1 : " + StockList1);
        System.out.println("StockList2: " + StockList2);
        // when
        int size1 = StockList1.size();
        int size2 = StockList2.size();
        //then
        assertThat(size1).isEqualTo(3);
        assertThat(size2).isEqualTo(1);

    }

}