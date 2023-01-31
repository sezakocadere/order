package org.order;

import org.order.model.Customer;
import org.order.model.Order;
import org.order.model.Sector;
import org.order.service.CustomerService;
import org.order.service.CustomerServiceImpl;
import org.order.service.OrderService;
import org.order.service.OrderServiceImpl;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final BigDecimal VALUE_INVOICE = BigDecimal.valueOf(1500);
    private static final BigDecimal VALUE_INVOICE2 = BigDecimal.valueOf(750);
    private static final BigDecimal VALUE_INVOICE3 = BigDecimal.valueOf(500);
    private static final String VALUE_NAME = "c";
    private static final String CURRENCY = " TRY";

    public static void main(String[] args) {
        CustomerService customerService = new CustomerServiceImpl();
        OrderService orderService = new OrderServiceImpl();
        System.out.println("Welcome to the order program! \n");
        Map<Long, Customer> customers = DataUtility.CUSTOMERS;
        System.out.println("All customers listed.. \n" + customers);
        System.out.println("List of customers contains " + VALUE_NAME + " in their full name \n" + customerService.getCustomersGivenCharOfFullName(customers.values().stream().toList(), VALUE_NAME));
        List<Order> orders = DataUtility.ORDERS;
        System.out.println("Total invoice of customers registered in the system in June: " + orderService.getTotalInvoiceByMonth(orders, 6) + CURRENCY);
        System.out.println("Total invoice of customers registered in the system in currently month: " + orderService.getTotalInvoiceByMonth(orders) + CURRENCY);
        System.out.println("All invoice of system:");
        orders.forEach(order -> {
            System.out.println(order.getInvoice() + CURRENCY);
        });
        List<BigDecimal> invoicesOverGivenAmount = orderService.filterInvoiceOverGivenAmount(orders, VALUE_INVOICE);
        System.out.println("Invoices Of More Than " + VALUE_INVOICE + CURRENCY + "\n" + invoicesOverGivenAmount + CURRENCY);
        System.out.println("Average invoices Of More Than " + VALUE_INVOICE + CURRENCY + "\n" + orderService.averageOfInvoices(invoicesOverGivenAmount) + CURRENCY);
        System.out.println("Invoices Of Less Than " + VALUE_INVOICE + CURRENCY + "\n" + orderService.filterInvoiceUnderGivenAmount(orders, VALUE_INVOICE) + CURRENCY);
        System.out.println("List of customers names by invoices of less than " + VALUE_INVOICE3 + CURRENCY + "\n" + customerService.getCustomerNamesByGivenAmountUnderOrders(orders, VALUE_INVOICE3));
        System.out.println("Sectors of sellers with average invoice of less than " + VALUE_INVOICE2 + CURRENCY + " in June :");
        Set<Sector> sectors = new HashSet<>();
        orderService.getAverageInvoiceOfOrdersAndSellersByMonth(orders, 6, VALUE_INVOICE2).keySet().forEach(sellers -> sellers.forEach(seller -> {
            sectors.add(seller.getSector());
        }));
        System.out.println(sectors);
    }
}