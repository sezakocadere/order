package org.order.service;

import org.order.model.Order;
import org.order.model.Seller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface OrderService {
    BigDecimal getTotalInvoiceByMonth(List<Order> orders, int month);

    BigDecimal getTotalInvoiceByMonth(List<Order> orders);

    List<BigDecimal> filterInvoiceOverGivenAmount(List<Order> orders, BigDecimal givenAmount);

    List<BigDecimal> filterInvoiceUnderGivenAmount(List<Order> orders, BigDecimal givenAmount);

    BigDecimal averageOfInvoices(List<BigDecimal> invoices);

    Map<List<Seller>, BigDecimal> getAverageInvoiceOfOrdersAndSellersByMonth(List<Order> orders, int month, BigDecimal givenAmount);
}