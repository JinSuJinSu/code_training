package com.poscoict.codetraining.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@SequenceGenerator(
        name = "MONEY_SEQ_GENERATOR",
        sequenceName = "MONEY_SEQ",
        initialValue = 1, allocationSize = 30)
public class Money {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MONEY_SEQ_GENERATOR")
    @Column(name = "money_id")
    private long id;

    @Embedded
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_transaction")
    private User user;
}
