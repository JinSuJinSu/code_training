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
        name = "STOCK_SEQ_GENERATOR",
        sequenceName = "STOCK_SEQ",
        initialValue = 1, allocationSize = 30)
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STOCK_SEQ_GENERATOR")
    @Column(name = "stock_id")
    private long id;

    @Embedded
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="item_id")
    private ItemStandard itemStandard;
}