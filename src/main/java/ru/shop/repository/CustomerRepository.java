package ru.shop.repository;

import org.springframework.stereotype.Repository;
import ru.shop.model.Customer;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {

    List<Customer> customers = new ArrayList<>();

    public void save(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> findAll() {
        return customers;
    }
}
