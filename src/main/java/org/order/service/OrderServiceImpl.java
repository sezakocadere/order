package org.order.service;

import org.order.model.Order;
import org.order.model.Seller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {
    @Override
    public BigDecimal getTotalInvoiceByMonth(List<Order> orders, int month) {
        return orders.stream().filter(order -> order.getCustomer().getCreatedTime().getMonthValue() == month).collect(Collectors.toList()).stream().map(Order::getInvoice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public List<BigDecimal> filterInvoiceOverGivenAmount(List<Order> orders, BigDecimal givenAmount) {
        return orders.stream().filter(order -> order.getInvoice().compareTo(givenAmount) > 0).collect(Collectors.toList()).stream().map(Order::getInvoice).collect(Collectors.toList());
    }

    @Override
    public List<BigDecimal> filterInvoiceUnderGivenAmount(List<Order> orders, BigDecimal givenAmount) {
        return orders.stream().filter(order -> order.getInvoice().compareTo(givenAmount) < 0).collect(Collectors.toList()).stream().map(Order::getInvoice).collect(Collectors.toList());
    }

    @Override
    public BigDecimal averageOfInvoices(List<Order> orders) {
        return orders.stream().map(Order::getInvoice).reduce(BigDecimal.ZERO, BigDecimal::add).divide(BigDecimal.valueOf(orders.size()), RoundingMode.HALF_UP);
    }

    @Override
    public List<Order> getOrdersByMonth(List<Order> orders, int month, BigDecimal givenAmount) {
        List<Order> orderByMonth = orders.stream().filter(order -> order.getCreatedDate().getMonthValue() == month).toList();
        Map<List<Seller>, List<Order>> sellerListMap = orderByMonth.stream().collect(Collectors.groupingBy(order -> order.getProducts().stream().map(product -> product.getSeller()).collect(Collectors.toList())));
        Map<List<Seller>, BigDecimal> avgOrdersBySeller = new HashMap<>();
        for (Map.Entry<List<Seller>, List<Order>> entry : sellerListMap.entrySet()) {
            BigDecimal avg = entry.getValue().stream().map(Order::getInvoice).reduce(BigDecimal.ZERO, BigDecimal::add).divide(BigDecimal.valueOf(entry.getValue().size()), RoundingMode.HALF_UP);
            avgOrdersBySeller.put(entry.getKey(), avg);
        }
        System.out.println(avgOrdersBySeller);
        return null;
    }
}
