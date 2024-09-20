package com.accenture.ws.entity;

import com.accenture.ws.impl.CafeClerk;
import org.springframework.stereotype.Component;

@Component
public class DiscountedBill extends OrderBill {

    public DiscountedBill(CafeClerk clerk) {
        super(clerk);
    }

    public double getTotalBill() {
        double total = 0.0;
        for (Order order : getOrderList()) {
            if (order.isDiscounted()) {
                total += order.getPrice() * 0.05;
            } else {
                total += order.getPrice();
            }
        }
        // Round off to 2 decimal places
        total = Math.round(total * 100.0) / 100.0;
        return total;
    }

    public double getDiscount() {
        return getOrderList().stream()
                .filter(Order::isDiscounted)
                .mapToDouble(order -> order.getPrice() * order.getDiscountedPercentage() / 100)
                .sum();
    }

    public double getRegularBill() {
        return getOrderList().stream()
                .mapToDouble(Order::getPrice)
                .sum();
    }

    public void setRegularBill(OrderBill regularBill) {
        // Assuming you want to set the order list from the regular bill
        setOrderList(regularBill.getOrderList());
    }
}