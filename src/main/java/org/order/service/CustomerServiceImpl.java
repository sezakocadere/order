package org.order.service;

import org.order.model.Customer;
import org.order.model.Order;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public List<Customer> getCustomersGivenCharOfFullName(List<Customer> customers, CharSequence givenChar) {
        // returns list customers with the given letter in their full names
        return customers.stream().filter(customer -> customer.getFullName().contains(givenChar)).toList();
    }

    @Override
    public List<String> getCustomerNamesByGivenAmountUnderOrders(List<Order> orders, BigDecimal amount) {
        // returns list customers full names by given amount under invoices
        return orders.stream().filter(order -> order.getInvoice().compareTo(amount) < 0).map(order -> order.getCustomer().getFullName()).collect(Collectors.toList());
    }
}
