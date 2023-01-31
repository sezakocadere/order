package org.order.service;

import org.order.model.Customer;
import org.order.model.Order;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerService {
    List<Customer> getCustomersGivenCharOfFullName(List<Customer> customers, CharSequence givenChar);

    List<String> getCustomerNamesByGivenAmountUnderOrders(List<Order> orders, BigDecimal amount);
}
