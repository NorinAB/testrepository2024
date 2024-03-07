package ru.shop.repository;

import ru.shop.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderRepository {

    List<Order> orders = new ArrayList<>();

    public void save(Order order) {
        orders.add(order);
    }

    public List<Order> findAll() {
        return orders;
    }

    public List<Order> findCustomerOrders(UUID customerId) {
        List<Order> list = new ArrayList<>();
        for (Order order : orders) {
            if (order.customerId() == customerId) {
                list.add(order);
            }
        }
        return list;
    }
}
