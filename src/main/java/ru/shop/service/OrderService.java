package ru.shop.service;

import ru.shop.exception.BadOrderCountException;
import ru.shop.model.Customer;
import ru.shop.model.Order;
import ru.shop.model.Product;
import ru.shop.repository.OrderRepository;

import java.util.List;
import java.util.UUID;

public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public List<Order> findByCustomer(Customer customer) {
        return orderRepository.findAll().stream().filter(o -> o.customerId() == customer.id()).toList();
    }

    public void add(Customer customer, Product product, long count) {
        if (count <= 0) {
            throw new BadOrderCountException(count);
        }

        Order order = new Order(UUID.randomUUID(), customer.id(), product.id(), count, count * product.cost());
        orderRepository.save(order);
    }

    public long getTotalCustomerAmount(Customer customer) {
        long totalAmount = 0;
        for (Order order : orderRepository.findCustomerOrders(customer.id())) {
            totalAmount += order.amount();
        }
        return totalAmount;
    }
}
