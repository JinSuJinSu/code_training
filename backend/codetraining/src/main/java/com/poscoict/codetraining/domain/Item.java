package com.poscoict.codetraining.domain;
;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Item {

    private String name;
    private long price;
    private long count;
    private String moneyUnit;
}
