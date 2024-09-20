package com.accenture.ws.controller;

import com.accenture.ws.entity.Order;
import com.accenture.ws.entity.OrderBill;
import com.accenture.ws.entity.RegularBill;
import com.accenture.ws.entity.DiscountedBill;
import com.accenture.ws.repository.OrderRepository;
import com.accenture.ws.impl.CafeClerk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
@CrossOrigin("*")
public class OrderAndBillingController {
    private final OrderRepository orderRepo;
    private final CafeClerk clerk;

    @Autowired
    public OrderAndBillingController(CafeClerk clerk, OrderRepository orderRepo) {
        this.clerk = clerk;
        this.orderRepo = orderRepo;
    }

    @GetMapping
    public List<Order> getOrderList() {
        return orderRepo.findAll();
    }

    @GetMapping("/totalRegularBill")
    public RegularBill getTotalRegularBill() {
        RegularBill regularBill = new RegularBill(clerk);
        regularBill.setOrderList(orderRepo.findAll());
        return regularBill;
    }

    @GetMapping("/totalDiscountedBill")
    public OrderBill getTotalDiscountedBill() {
        DiscountedBill discountedBill = new DiscountedBill(clerk);
        discountedBill.setOrderList(orderRepo.findAll());
        return discountedBill;
    }

    @PostMapping
    public void addOrder(@RequestBody Order order) {
        orderRepo.save(order);
    }

    @PutMapping ("/update/{id}")
    public void updateOrder(@PathVariable Long id, @RequestBody Order order) {
        if (orderRepo.existsById(id)) {
            order.setId(id);
            orderRepo.save(order);

        }

    }

    @DeleteMapping ("/delete/{id}")public void deleteOrder(@PathVariable Long id)
    {    orderRepo.findById(id).ifPresent(orderRepo::delete);}}
