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
@SequenceGenerator(
        name = "ASSET_SEQ_GENERATOR",
        sequenceName = "ASSET_SEQ",
        initialValue = 1, allocationSize = 10)
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ASSET_SEQ_GENERATOR")
    @Column(name = "asset_id")
    private long id;

    private String name;
    private long price;

}
