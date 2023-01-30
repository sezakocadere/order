package org.order.service;

import org.order.model.Customer;
import org.order.model.Order;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public List<Customer> getCustomersGivenMonthOfCreateDate(List<Customer> customers, int givenMonth) {
        return customers.stream().filter(customer -> customer.getCreatedTime().getMonthValue() == givenMonth).collect(Collectors.toList());
    }

    @Override
    public List<Customer> getCustomersGivenCharOfFullName(List<Customer> customers, CharSequence givenChar) {
        return customers.stream().filter(customer -> customer.getFullName().contains(givenChar)).collect(Collectors.toList());
    }

    @Override
    public List<String> getCustomerNamesByInvoice(List<Order> orders) {
        return orders.stream().map(order -> order.getCustomer().getFullName()).collect(Collectors.toList());
    }
}
