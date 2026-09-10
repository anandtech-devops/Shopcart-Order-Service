package com.shopcart.order;

import com.shopcart.order.model.Order;
import com.shopcart.order.model.OrderStatus;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {
    @Test void orderDefaultsToCreated(){
        Order order=new Order(); order.setStatus(OrderStatus.CREATED);
        assertEquals(OrderStatus.CREATED, order.getStatus());
    }
    @Test void orderStatusCanChange(){
        Order order=new Order(); order.setStatus(OrderStatus.CREATED); order.setStatus(OrderStatus.SHIPPED);
        assertEquals(OrderStatus.SHIPPED, order.getStatus());
    }
}
