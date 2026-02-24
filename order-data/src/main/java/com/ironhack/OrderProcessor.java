package com.ironhack;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class OrderProcessor {
    private static final Gson GSON = new Gson();

    public static void main(String[] args) {
        String ordersJson = """
        [
          {
            "id": "order-1001",
            "customerId": "customer-501",
            "total": 259.98,
            "items": [
              {
                "id": "item-1",
                "orderId": "order-1001",
                "productId": "product-2001",
                "quantity": 2,
                "unitPrice": 49.99
              },
              {
                "id": "item-2",
                "orderId": "order-1001",
                "productId": "product-2002",
                "quantity": 1,
                "unitPrice": 159.99
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
        List<Order> orders = processData(ordersJson);
        logOrders(orders);
    }

    public static List<Order> processData(String ordersJson) {
        Type listType = new TypeToken<List<Order>>() {}.getType();

        return GSON.fromJson(ordersJson, listType);
    }

    private static void logOrders(List<Order> orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
