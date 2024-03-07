package ru.shop.model;

import java.util.UUID;

public record Product(UUID id, String name, ProductType productType, long cost) {

    @Override
    public String toString() {
        return String.format("Product(id=[%s], name=[%s], productType=[%s], cost=[%s])", id, name, productType, cost);
    }

}
