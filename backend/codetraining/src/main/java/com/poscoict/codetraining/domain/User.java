package com.poscoict.codetraining.domain;

import com.poscoict.codetraining.enumration.UserGrade;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Table(name = "user_info")
@SequenceGenerator(
        name = "USER_SEQ_GENERATOR",
        sequenceName = "USER_SEQ",
        initialValue = 1, allocationSize = 10)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ_GENERATOR")
    @Column(name = "user_transaction")
    private long id;

    private String userId;
    private String password;
    private String name;

    @Enumerated(EnumType.STRING)
    private UserGrade grade;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;
}