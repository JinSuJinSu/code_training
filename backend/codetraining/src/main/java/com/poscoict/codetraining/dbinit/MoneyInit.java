package com.poscoict.codetraining.dbinit;

import com.poscoict.codetraining.domain.User;
import com.poscoict.codetraining.enumration.UserGrade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Component
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MoneyInit {

    private final EntityManager em;

    public void dbInit(){
        User user1 = createUser("hjs429", "1234", "jinsu", UserGrade.ADMIN);
        em.persist(user1);
    }

    private User createUser(String userId,
                            String password,
                            String name,
                            UserGrade grade) {

        User user =
                new User().builder()
                        .userId(userId)
                        .password(password)
                        .name(name)
                        .grade(grade)
                        .build();
        log.info("생성된 유저 : " + user);
        return user;
    }
}
