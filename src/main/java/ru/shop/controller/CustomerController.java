package ru.shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shop.model.Customer;
import ru.shop.service.CustomerService;

import java.util.List;

@RestController("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllProducts() {
        return customerService.findAll();
    }

    @PostMapping
    public void saveCustomer(Customer customer) {
        customerService.save(customer);
    }
}
