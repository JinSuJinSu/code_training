package com.poscoict.codetraining.mapper;

import com.poscoict.codetraining.domain.Order;
import com.poscoict.codetraining.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    @Mapping(source = "name", target = "item.name")
    @Mapping(source = "count", target = "item.count")
    @Mapping(source = "userId", target = "user.userId")
    Order toEntity(OrderDto dto);

    @Mapping(source = "item.name", target = "name")
    @Mapping(source = "item.count", target = "count")
    OrderDto toDto(Order entity);
}
