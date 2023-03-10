package com.poscoict.codetraining.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SequenceGenerator(
        name = "ITEMSTANDARD_SEQ_GENERATOR",
        sequenceName = "ITEMSTANDARD_SEQ",
        initialValue = 1, allocationSize = 10)
public class ItemStandard {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEMSTANDARD_SEQ_GENERATOR")
    @Column(name = "item_id")
    private long id;

    @NotNull
    private String category;

    @NotNull
    @Column(name = "item_name")
    private String name;

    @NotNull
    private String countryCode;

    @NotNull
    private String standardUnit;

}
