package com.shopcart.order.controller;

import com.shopcart.order.model.Order;
import com.shopcart.order.model.OrderStatus;
import com.shopcart.order.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService service;
    public OrderController(OrderService service){this.service=service;}
    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public Order create(@Valid @RequestBody Order order){return service.create(order);}
    @GetMapping public List<Order> findAll(){return service.findAll();}
    @GetMapping("/{id}") public Order findById(@PathVariable Long id){return service.findById(id);}
    @PutMapping("/{id}/status")
    public Order updateStatus(@PathVariable Long id,@RequestBody StatusRequest request){return service.updateStatus(id,request.status());}
    public record StatusRequest(OrderStatus status) {}
}
