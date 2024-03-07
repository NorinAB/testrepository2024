package ru.shop;

import ru.shop.exception.BadOrderCountException;
import ru.shop.model.Customer;
import ru.shop.model.Product;
import ru.shop.model.ProductType;
import ru.shop.repository.CustomerRepository;
import ru.shop.repository.OrderRepository;
import ru.shop.repository.ProductRepository;
import ru.shop.service.CustomerService;
import ru.shop.service.OrderService;
import ru.shop.service.ProductService;

import java.util.UUID;

public class Main {

    static CustomerService customerService = new CustomerService(new CustomerRepository());
    static ProductService productService = new ProductService(new ProductRepository());
    static OrderService orderService = new OrderService(new OrderRepository());

    public static void main(String[] args) {

        Customer ivanovIvan = new Customer(UUID.randomUUID(), "Ivanov Ivan", "256-35-69", 33);
        customerService.save(ivanovIvan);
        Customer petrovPetr = new Customer(UUID.randomUUID(), "Petrov Petr", "123-45-67", 35);
        customerService.save(petrovPetr);
        System.out.println("Customers count: " + customerService.findAll().size());

        Product bentley = new Product(UUID.randomUUID(), "Bentley", ProductType.GOOD, 100);
        productService.save(bentley);

        Product ferrari = new Product(UUID.randomUUID(), "Ferrari", ProductType.GOOD, 200);
        productService.save(ferrari);

        Product carWishing = new Product(UUID.randomUUID(), "Car wishing", ProductType.SERVICE, 20);
        productService.save(carWishing);

        System.out.println("Products count: " + productService.findAll().size());
        System.out.println("\tGOODS count: " + productService.findByProductType(ProductType.GOOD).size());
        System.out.println("\tSERVICE count: " + productService.findByProductType(ProductType.SERVICE).size());

        orderService.add(ivanovIvan, bentley, 2);
        orderService.add(ivanovIvan, ferrari, 1);
        orderService.add(petrovPetr, ferrari, 1);

        try {
            orderService.add(ivanovIvan, bentley, -2);
        } catch (BadOrderCountException ex) {
            System.out.println("Adding order exception: " + ex.getMessage());
        }

        System.out.println("Orders count: " + orderService.findAll().size());
        System.out.println("Ivanov orders count: " + orderService.findByCustomer(ivanovIvan).size());
        System.out.println("Petrov orders count: " + orderService.findByCustomer(petrovPetr).size());

        System.out.println("Total for Ivanov: " + orderService.getTotalCustomerAmount(ivanovIvan));
        System.out.println("Total for Petrov: " + orderService.getTotalCustomerAmount(petrovPetr));
    }


}