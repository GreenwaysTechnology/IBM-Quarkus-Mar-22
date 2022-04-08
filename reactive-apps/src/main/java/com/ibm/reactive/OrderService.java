package com.ibm.reactive;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import java.util.List;

public class OrderService {
    //traditional pull api
    public List<Order> findAll() {
        return List.of(new Order(1, "Books", true), new Order(2, "Phone", false));
    }

    //reactive push api
    //publisher
    public Uni<List<Order>> streamOrder() {
        //return stream.
        List<Order> orderList = List.of(new Order(1, "Books", true), new Order(2, "Phone", false));
        return Uni.createFrom().item(orderList);
    }

    public Multi<Order> streamSequence() {
        //return stream.
        return Multi.createFrom().
                items(new Order(1, "Books", true), new Order(2, "Phone", false))
                .filter(order -> order.isInStock());
    }

}
