package org.order.service;

import org.order.model.Order;
import org.order.model.Product;
import org.order.model.Seller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {
    @Override
    public BigDecimal getTotalInvoiceByMonth(List<Order> orders, int month) {
        //returns invoice totals for the given month
        return orders.stream().filter(order -> order.getCustomer().getCreatedTime().getMonthValue() == month).toList().stream().map(Order::getInvoice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public BigDecimal getTotalInvoiceByMonth(List<Order> orders) {
        //returns invoice totals for the current month
        return getTotalInvoiceByMonth(orders, LocalDate.now().getMonthValue());
    }

    @Override
    public List<BigDecimal> filterInvoiceOverGivenAmount(List<Order> orders, BigDecimal givenAmount) {
        //returns invoices over given amount
        return orders.stream().filter(order -> order.getInvoice().compareTo(givenAmount) > 0).toList().stream().map(Order::getInvoice).collect(Collectors.toList());
    }

    @Override
    public List<BigDecimal> filterInvoiceUnderGivenAmount(List<Order> orders, BigDecimal givenAmount) {
        //returns invoices under given amount
        return orders.stream().filter(order -> order.getInvoice().compareTo(givenAmount) < 0).toList().stream().map(Order::getInvoice).toList();
    }

    @Override
    public BigDecimal averageOfInvoices(List<BigDecimal> invoices) {
        //returns average of invoices
        return invoices.stream().reduce(BigDecimal.ZERO, BigDecimal::add).divide(BigDecimal.valueOf(invoices.size()), RoundingMode.HALF_UP);
    }

    @Override
    public Map<List<Seller>, BigDecimal> getAverageInvoiceOfOrdersAndSellersByMonth(List<Order> orders, int month, BigDecimal givenAmount) {
        //returns map of seller list - their average invoices by given month
        List<Order> orderByMonth = orders.stream().filter(order -> order.getCreatedDate().getMonthValue() == month).toList();
        Map<List<Seller>, List<Order>> sellerListMap = orderByMonth.stream().collect(Collectors.groupingBy(order -> order.getProducts().stream().map(Product::getSeller).toList()));
        Map<List<Seller>, BigDecimal> avgOrdersBySeller = new HashMap<>();
        for (Map.Entry<List<Seller>, List<Order>> entry : sellerListMap.entrySet()) {
            BigDecimal avg = entry.getValue().stream().map(Order::getInvoice).reduce(BigDecimal.ZERO, BigDecimal::add).divide(BigDecimal.valueOf(entry.getValue().size()), RoundingMode.HALF_UP);
            avgOrdersBySeller.put(entry.getKey(), avg);
        }
        return avgOrdersBySeller;
    }
}
