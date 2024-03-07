package ru.shop.model;

import java.util.UUID;

import static java.lang.String.valueOf;

public record Order(UUID id, UUID customerId, UUID productId, long count, long amount) {

    @Override
    public String toString() {
        return String.join(", ", valueOf(id), valueOf(customerId), valueOf(productId), valueOf(count), valueOf(amount));
    }
}
