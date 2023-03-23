package com.poscoict.codetraining.repository;

import com.poscoict.codetraining.dbinit.ItemStandardTestUtils;
//import com.poscoict.codetraining.dbinit.StockMarketTestUtils;
import com.poscoict.codetraining.dbinit.StockMarketTestUtils;
import com.poscoict.codetraining.dbinit.StockTestUtils;
import com.poscoict.codetraining.dbinit.UserTestUtils;
import com.poscoict.codetraining.domain.*;
import com.poscoict.codetraining.domain.Order;
import com.poscoict.codetraining.enumration.OrderStatus;
import com.poscoict.codetraining.mapper.OrderMapper;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ComponentScan(basePackages = "com.poscoict.codetraining.repository")
class DomesticStockRepositoryTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private DomesticStockRepository domesticStockRepository;
    // 테스트에 사용하는 공통 메소드
    public Order createOrder(String name, long price, long count){
        LocalDateTime dateTime = LocalDateTime.now();
        User user = em.find(User.class, 1L);
        return new Order().builder()
                .item(new Item().builder()
                        .name(name)
                        .price(price)
                        .count(count)
                        .moneyUnit("원")
                        .build())
                .user(user)
                .orderDate(dateTime)
                .status(OrderStatus.ORDER)
                .build();
    }

    @BeforeEach
    public void init() {
        System.out.println("데이터 삽입 시작");
        UserTestUtils.addUser(em);
        ItemStandardTestUtils.addItemStandard(em, "국내주식");
        // 객체가 Entity로 매핑되어 있어서 단순 삽입으로는 확인이 어려움
        // 삽입하는 데이터는 해당 클래스의 메소드 참조
        StockTestUtils.addStock(em, domesticStockRepository, "국내주식");
        StockMarketTestUtils.addStockMarket(em, domesticStockRepository, "국내주식");

    }

    @Test
    @DisplayName("국내주식 조회 테스트")
    void searchStock(){
        // given
        // 아이템 규격부터 조회하자(직접 id로 접근하는 것은 상당히 위험한 코드)
        // 규격 조회 후 해당 객체의 id를 넣어주자
        ItemStandard itemStandard = domesticStockRepository.findStandard("국내주식");
        Long id = itemStandard.getId();
        User user = domesticStockRepository.findUser("hjs429");
        Long userTransaction = user.getId(); // getId를 넣었지만 pk는 유저ID가 아닌 유저 Transaction을 사용한다.

        List<Stock> StockList1 = domesticStockRepository.getStockList("",id, userTransaction);
        List<Stock> StockList2 = domesticStockRepository.getStockList("샤나",id, userTransaction);

        // when
        int size1 = StockList1.size();
        int size2 = StockList2.size();
        //then
        assertThat(size1).isEqualTo(3);
        assertThat(size2).isEqualTo(1);

    }

    @Test
    @DisplayName("국내주식시장 조회 테스트")
    void searchStockMarket(){
        // given
        // 아이템 규격부터 조회하자(직접 id로 접근하는 것은 상당히 위험한 코드)
        // 규격 조회 후 해당 객체의 id를 넣어주자
        ItemStandard itemStandard = domesticStockRepository.findStandard("국내주식");
        Long id = itemStandard.getId();

        List<StockMarket> StockList1 = domesticStockRepository.getStockMarketList("",id);
        List<StockMarket> StockList2 = domesticStockRepository.getStockMarketList("샤나",id);

        // when
        int size1 = StockList1.size();
        int size2 = StockList2.size();
        //then
        assertThat(size1).isEqualTo(3);
        assertThat(size2).isEqualTo(1);

    }

    @Test
    @DisplayName("주식 주문 테스트---> 매수 주문 시작한 주식 추가")
    void orderStock(){
        // given
        Order order = createOrder("니나브ICT",10000,5);

        // when
        domesticStockRepository.orderStock(order);
        System.out.println("주문 : " + order);
        Order recentOrder = domesticStockRepository.findOrder("니나브ICT");

        //then
        System.out.println("주문 정보 : " + order);
        System.out.println("조회된 주문 정보 : " + recentOrder);

        assertThat(recentOrder.getItem().getName()).isEqualTo("니나브ICT");
        assertThat(recentOrder.getItem().getPrice()).isEqualTo(10000);
        assertThat(recentOrder.getItem().getCount()).isEqualTo(5);
        assertThat(recentOrder.getStatus()).isEqualTo(OrderStatus.ORDER);
    }

    @Test
    @DisplayName("주식 주문 테스트---> 매수 주문 시작한 주식 주문 수량 추가하기")
    void orderUpdateStock(){
        // given
        String stockName = "니나브ICT";
        long orderCount = 5L;
        // when
        int count = domesticStockRepository.orderUpdateStock(stockName, orderCount);
        em.clear();
        StockMarket stockMarket = domesticStockRepository.findStockMarket(stockName);

        //then
        assertThat(count).isEqualTo(1);
        assertThat(stockMarket.getItem().getName()).isEqualTo("니나브ICT");
        assertThat(stockMarket.getOrderCount()).isEqualTo(orderCount);
    }

    @Test
    @DisplayName("주문한 주식 목록 조회하기")
    void findOrders(){
        // given
        Order order1 = createOrder("니나브ICT",10000,5);
        Order order2 = createOrder("샤나전자",9000,7);
        // when
        domesticStockRepository.orderStock(order1);
        domesticStockRepository.orderStock(order2);

        //then
        List<Order> orders = domesticStockRepository.findOrders("hjs429");
        assertThat(orders.size()).isEqualTo(2);
    }


}