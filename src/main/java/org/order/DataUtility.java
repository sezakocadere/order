package org.order;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.order.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class DataUtility {
    public static final Map<Long, Customer> customers = prepareCustomerList();
    public static final List<Order> orders = prepareOrderList();
    public static final Map<Long, Product> products = prepareProductList();

    public static Map<Long, Product> prepareProductList() {
        return Maps.newHashMap(ImmutableMap.of(1L, Product.builder().name("MICROSOFT Xbox Series X 1TB").seller(Seller.builder().name("Persona Technology").sector(Sector.ELECTRONICS).build()).price(BigDecimal.valueOf(8300)).build(),
                2L, Product.builder().name("Apple USB-C Charge Cable (2m)").seller(Seller.builder().name("Apple").sector(Sector.TECHNOLOGY).build()).price(BigDecimal.valueOf(320)).build(),
                3L, Product.builder().name("Valorant 8500 Vp").seller(Seller.builder().name("Riot Games").sector(Sector.GAMING).build()).price(BigDecimal.valueOf(635)).build()));
    }

    public static List<Order> prepareOrderList() {
        return List.of(Order.builder().products(List.of(prepareProductList().get(1L))).customer(customers.get(1L)).createdDate(LocalDate.now()).build(),
                Order.builder().products(List.of(prepareProductList().get(1L))).customer(customers.get(2L)).createdDate(LocalDate.now()).build(),
                Order.builder().products(List.of(prepareProductList().get(2L))).customer(customers.get(2L)).createdDate(LocalDate.now()).build());
    }

    public static Map<Long, Customer> prepareCustomerList() {
        return Maps.newHashMap(ImmutableMap.of(1L, Customer.builder().fullName("Seza Kocadere").createdTime(LocalDate.now()).build(),
                2L, Customer.builder().fullName("Slim Shady").createdTime(LocalDate.of(2022, 06, 05)).build(),
                3L, Customer.builder().fullName("Albert Einstein").createdTime(LocalDate.of(200, 06, 01)).build()));
    }
}
