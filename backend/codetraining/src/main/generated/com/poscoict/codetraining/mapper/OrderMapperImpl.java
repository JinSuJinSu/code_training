package com.poscoict.codetraining.mapper;

import com.poscoict.codetraining.domain.Item;
import com.poscoict.codetraining.domain.Item.ItemBuilder;
import com.poscoict.codetraining.domain.Order;
import com.poscoict.codetraining.domain.Order.OrderBuilder;
import com.poscoict.codetraining.domain.User;
import com.poscoict.codetraining.domain.User.UserBuilder;
import com.poscoict.codetraining.dto.OrderDto;
import com.poscoict.codetraining.dto.OrderDto.OrderDtoBuilder;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-10T17:24:03+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order toEntity(OrderDto dto) {
        if ( dto == null ) {
            return null;
        }

        OrderBuilder order = Order.builder();

        order.item( orderDtoToItem( dto ) );
        order.user( orderDtoToUser( dto ) );
        order.orderDate( dto.getOrderDate() );

        return order.build();
    }

    @Override
    public OrderDto toDto(Order entity) {
        if ( entity == null ) {
            return null;
        }

        OrderDtoBuilder orderDto = OrderDto.builder();

        orderDto.name( entityItemName( entity ) );
        orderDto.count( entityItemCount( entity ) );
        orderDto.orderDate( entity.getOrderDate() );

        return orderDto.build();
    }

    protected Item orderDtoToItem(OrderDto orderDto) {
        if ( orderDto == null ) {
            return null;
        }

        ItemBuilder item = Item.builder();

        item.name( orderDto.getName() );
        item.count( orderDto.getCount() );

        return item.build();
    }

    protected User orderDtoToUser(OrderDto orderDto) {
        if ( orderDto == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        user.userId( orderDto.getUserId() );

        return user.build();
    }

    private String entityItemName(Order order) {
        if ( order == null ) {
            return null;
        }
        Item item = order.getItem();
        if ( item == null ) {
            return null;
        }
        String name = item.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private long entityItemCount(Order order) {
        if ( order == null ) {
            return 0L;
        }
        Item item = order.getItem();
        if ( item == null ) {
            return 0L;
        }
        long count = item.getCount();
        return count;
    }
}
