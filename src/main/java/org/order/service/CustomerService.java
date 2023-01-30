package org.order.service;

import org.order.model.Customer;
import org.order.model.Order;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomersGivenMonthOfCreateDate(List<Customer> customers, int givenMonth);

    List<Customer> getCustomersGivenCharOfFullName(List<Customer> customers, CharSequence givenChar);

    List<String> getCustomerNamesByInvoice(List<Order> orders);
}
