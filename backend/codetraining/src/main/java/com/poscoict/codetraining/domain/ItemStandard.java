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
public class ItemStandard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
