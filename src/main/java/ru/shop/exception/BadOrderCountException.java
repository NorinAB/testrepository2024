package ru.shop.exception;

public class BadOrderCountException extends RuntimeException {

    public BadOrderCountException(Long orderCount) {
        super("Order count should be more than 0. Order count=" + orderCount);
    }
}
