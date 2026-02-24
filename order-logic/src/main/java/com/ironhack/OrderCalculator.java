package com.ironhack;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderCalculator {
    public static void main(String[] args) {
        String ordersJson = """
        [
          {
            "id": "order-1001",
            "customerId": "customer-501",
            "total": 250.00,
            "items": [
              {
                "id": "item-1",
                "orderId": "order-1001",
                "productId": "product-2001",
                "quantity": 2,
                "unitPrice": 50.00
              },
              {
                "id": "item-2",
                "orderId": "order-1001",
                "productId": "product-2002",
                "quantity": 1,
                "unitPrice": 150.00
              }
            ]
          },
          {
            "id": "order-1002",
            "customerId": "customer-777",
            "total": 89.97,
            "items": [
              {
                "id": "item-3",
                "orderId": "order-1002",
                "productId": "product-3001",
                "quantity": 3,
                "unitPrice": 29.99
              }
            ]
          }
        ]
        """;

        List<Order> orders = OrderProcessor.processData(ordersJson);
        validateOrders(orders);

        // Should return 0 elements
        List<Order> filteredOrders = filterByPrice(orders, BigDecimal.valueOf(100));
        System.out.println("Filtered orders: " + filteredOrders);

        // Should return element with specified id
        Order orderByCustomerId = filterByCustomerId(orders, "customer-501");
        System.out.println("Order by customer ID=customer-501 : " + orderByCustomerId);
    }

    private static void validateOrders(List<Order> orders) {
        // Validate order total equals actual total
        for (Order order : orders) {
            BigDecimal actualTotal = BigDecimal.ZERO;

            for (OrderItem item : order.getItems()) {
                BigDecimal quantity = BigDecimal.valueOf(item.getQuantity());
                BigDecimal orderItemPrice = item.getUnitPrice().multiply(quantity);

                actualTotal = actualTotal.add(orderItemPrice);
            }
            if (order.getTotal().compareTo(actualTotal) != 0) {
                throw new IllegalArgumentException("INVALID_TOTAL_PRICE. Order items total price does not match given total.");
            }
        }
    }

    public static List<Order> filterByPrice(List<Order> orders, BigDecimal price) {
        List<Order> filteredOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getTotal().compareTo(price) == 0) {
                filteredOrders.add(order);
            }
        }
        return filteredOrders;
    }

    public static Order filterByCustomerId(List<Order> orders, String customerId) {
        for (Order order : orders) {
            if (order.getCustomerId().equals(customerId)) {
                return order;
            }
        }
        return null;
    }
}
