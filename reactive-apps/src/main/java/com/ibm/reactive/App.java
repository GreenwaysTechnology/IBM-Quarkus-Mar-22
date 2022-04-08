package com.ibm.reactive;

public class App {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService(new OrderService());
        System.out.println(customerService.getAllOrders());
        customerService.processOrderStream();
        customerService.processSequenceStream();
    }
}
