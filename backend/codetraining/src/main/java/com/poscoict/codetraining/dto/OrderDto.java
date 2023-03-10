package com.poscoict.codetraining.dto;

import com.poscoict.codetraining.domain.Stock;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private String name;
    private long count;
    private String userId;
    private LocalDateTime orderDate;
}
