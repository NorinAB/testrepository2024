package ru.shop.model;

import java.util.UUID;

public record Customer(UUID id, String name, String phone, int age) {
    @Override
    public String toString() {
        return String.format("Customer(id=[%s], name=[%s], phone=[%s], age=[%s])", id, name, phone, age);
    }
}
