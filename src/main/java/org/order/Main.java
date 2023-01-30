package org.order;

import org.order.service.OrderServiceImpl;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        OrderServiceImpl service = new OrderServiceImpl();
        System.out.println("Welcome to the order program!");
        service.getOrdersByMonth(DataUtility.orders, 1, BigDecimal.valueOf(90));
    }
}