package com.accenture.ws.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderName;
    private double price;
    private boolean isDiscounted;
    private double isDiscountedPercentage = 5.0;

    // Default constructor
    public Order() {
    }

    // Parameterized constructor
    public Order(String orderName, double price, boolean isDiscounted) {
        this.orderName = orderName;
        this.price = price;
        this.isDiscounted = isDiscounted;
        if (!isDiscounted) {
            this.isDiscountedPercentage = 0;
        }
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDiscounted() {
        return isDiscounted;
    }

    public void setDiscounted(boolean isDiscounted) {
        this.isDiscounted = isDiscounted;
        if (!isDiscounted) {
            this.isDiscountedPercentage = 0;
        }
    }

    public double getDiscountedPercentage() {
        return isDiscountedPercentage;
    }

    public void setDiscountedPercentage(double discountedPercentage) {
        this.isDiscountedPercentage = discountedPercentage;
    }
}