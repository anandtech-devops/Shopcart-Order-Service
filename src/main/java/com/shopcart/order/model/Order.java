package com.shopcart.order.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Order {
    private Long id;
    @NotBlank private String customerName;
    @NotBlank private String product;
    @Min(1) private int quantity;
    private OrderStatus status = OrderStatus.CREATED;

    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getCustomerName(){return customerName;} public void setCustomerName(String v){customerName=v;}
    public String getProduct(){return product;} public void setProduct(String v){product=v;}
    public int getQuantity(){return quantity;} public void setQuantity(int v){quantity=v;}
    public OrderStatus getStatus(){return status;} public void setStatus(OrderStatus v){status=v;}
}
