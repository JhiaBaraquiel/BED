package com.accenture.ws.entity;

import com.accenture.ws.impl.CafeClerk;
import java.util.List;

public class RegularBill extends OrderBill {

    public RegularBill(CafeClerk clerk) {
        super(clerk);
    }

    @Override
    public double getRegularBill() {
        List<Order> orders = getOrderList();
        double total = orders.stream()
                .mapToDouble(order -> {
                    if (order.isDiscounted()) {
                        return order.getPrice() * (1 - order.getDiscountedPercentage() / 100);
                    } else {
                        return order.getPrice();
                    }
                })
                .sum();
        return Math.round(total);
    }
}