package com.accenture.ws.impl;

import com.accenture.ws.entity.Order;
import com.accenture.ws.entity.OrderBill;
import com.accenture.ws.entity.RegularBill;
import com.accenture.ws.entity.DiscountedBill;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CafeClerk {

    @Id
    private Long id;
    private String name;

    public CafeClerk() {
    }

    public CafeClerk(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OrderBill calculateTotalRegularBill(List<Order> orders) {
        RegularBill regularBill = new RegularBill(this);
        regularBill.setOrderList(orders);
        return regularBill;
    }

    public OrderBill calculateTotalDiscountedBill(List<Order> orders) {
        DiscountedBill discountedBill = new DiscountedBill(this);
        discountedBill.setOrderList(orders);
        return discountedBill;
    }
}