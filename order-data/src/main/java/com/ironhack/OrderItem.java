package com.ironhack;

import java.math.BigDecimal;

public class OrderItem {
    private final String id;
    private final String orderId;
    private final String productId;
    private final int quantity;
    private final BigDecimal unitPrice;

    public OrderItem(String id, String orderId, String productId, int quantity, BigDecimal unitPrice) {
        validateOrderItem(id, orderId, productId, quantity, unitPrice);
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    private void validateOrderItem(String id, String orderId, String productId, int quantity, BigDecimal unitPrice) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        if (orderId == null) {
            throw new IllegalArgumentException("Order ID cannot be null");
        }
        if (productId == null) {
            throw new IllegalArgumentException("Product ID cannot be null");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        if (unitPrice == null) {
            throw new IllegalArgumentException("Unit Price cannot be null");
        }
    }

    public String getId() {
        return id;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id='" + id + '\'' +
                ", orderId='" + orderId + '\'' +
                ", productId='" + productId + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
