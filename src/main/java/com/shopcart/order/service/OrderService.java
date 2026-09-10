package com.shopcart.order.service;

import com.shopcart.order.model.Order;
import com.shopcart.order.model.OrderStatus;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class OrderService {
    private final List<Order> orders = new ArrayList<>();
    private final AtomicLong sequence = new AtomicLong(0);

    public synchronized Order create(Order order) {
        order.setId(sequence.incrementAndGet());
        order.setStatus(OrderStatus.CREATED);
        orders.add(order);
        return order;
    }
    public synchronized List<Order> findAll() { return new ArrayList<>(orders); }
    public synchronized Order findById(Long id) {
        return orders.stream().filter(o -> o.getId().equals(id)).findFirst()
            .orElseThrow(() -> new RuntimeException("Order not found: " + id));
    }
    public synchronized Order updateStatus(Long id, OrderStatus status) {
        Order order = findById(id); order.setStatus(status); return order;
    }
}
