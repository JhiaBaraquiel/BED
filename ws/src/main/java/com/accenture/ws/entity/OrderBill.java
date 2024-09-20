package com.accenture.ws.entity;

import com.accenture.ws.impl.CafeClerk;

import java.util.List;

public abstract class OrderBill {
    private List<Order> orderList;
    private CafeClerk clerk;

    // No-argument constructor
    public OrderBill() {
    }

    // Constructor with CafeClerk parameter
    public OrderBill(CafeClerk clerk) {
        this.clerk = clerk;
    }

    // Getter and Setter for clerk
    public CafeClerk getClerk() {
        return clerk;
    }

    public void setClerk(CafeClerk clerk) {
        this.clerk = clerk;
    }

    // Getter and Setter for orderList
    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    // Abstract method to calculate total
    public abstract double getRegularBill();
}