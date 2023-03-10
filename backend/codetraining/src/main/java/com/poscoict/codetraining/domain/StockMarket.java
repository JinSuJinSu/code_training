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
        name = "STOCKMARKET_SEQ_GENERATOR",
        sequenceName = "STOCKMARKET_SEQ",
        initialValue = 1, allocationSize = 30)
public class StockMarket {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STOCKMARKET_SEQ_GENERATOR")
    @Column(name = "stock_market_id")
    private long id;

    @Embedded
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="item_id")
    private ItemStandard itemStandard;

    private long orderCount;
}