package org.order.service;

import org.order.model.Order;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {
    BigDecimal getTotalInvoiceByMonth(List<Order> orders, int month);

    List<BigDecimal> filterInvoiceOverGivenAmount(List<Order> orders, BigDecimal givenAmount);

    List<BigDecimal> filterInvoiceUnderGivenAmount(List<Order> orders, BigDecimal givenAmount);

    BigDecimal averageOfInvoices(List<Order> orders);

    List<Order> getOrdersByMonth(List<Order> orders, int month, BigDecimal givenAmount);
}
