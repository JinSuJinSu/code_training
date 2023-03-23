package com.poscoict.codetraining.dto;

import com.poscoict.codetraining.domain.Stock;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDto {
    private String name;
    private long count;
    private String userId;
    private LocalDateTime orderDate;
}
