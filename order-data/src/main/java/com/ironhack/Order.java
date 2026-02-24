package com.ironhack;

import java.math.BigDecimal;
import java.util.List;

public class Order {
    private final String id;
    private final String customerId;
    private final BigDecimal total;
    private final List<OrderItem> items;

    public Order(String id, String customerId, BigDecimal total, List<OrderItem> items) {
        validateOrder(id, customerId, total, items);
        this.id = id;
        this.customerId = customerId;
        this.total = total;
        this.items = items;
    }

    private void validateOrder(String id, String customerId, BigDecimal total, List<OrderItem> items) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        if (customerId == null) {
            throw new IllegalArgumentException("Customer ID cannot be null");
        }
        if (total == null) {
            throw new IllegalArgumentException("Total cannot be null");
        }
        if (items == null) {
            throw new IllegalArgumentException("Order items must be specified");
        }
    }

    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customerId='" + customerId + '\'' +
                ", total=" + total +
                ", items=" + items +
                '}';
    }
}
