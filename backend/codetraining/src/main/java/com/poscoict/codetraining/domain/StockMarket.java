package com.poscoict.codetraining.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StockMarket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_market_id")
    private long id;

    @Embedded
    private Item item;

    @ManyToOne
    @JoinColumn(name="item_id")
    private ItemStandard itemStandard;

    private long orderCount;
}