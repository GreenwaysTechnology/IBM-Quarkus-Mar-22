package com.ibm.reactive;

import java.util.List;

public class CustomerService {
    private OrderService orderService;

    public CustomerService() {
    }

    public CustomerService(OrderService orderService) {
        this.orderService = orderService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public List<Order> getAllOrders() {
        return this.orderService.findAll();
    }

    public void processOrderStream() {
        //subscriber / listner
        orderService.streamOrder().subscribe().with(orders -> {
            System.out.println(orders);
        });
    }

    public void processSequenceStream() {
        orderService.streamSequence().subscribe().with(order -> {
            System.out.println(order);

        });
    }
}
