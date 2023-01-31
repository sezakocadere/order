package org.order;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.order.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataUtility {
    protected static final Map<Long, Customer> CUSTOMERS = prepareCustomerList();
    protected static final Map<Long, Product> PRODUCTS = prepareProductList();
    protected static final List<Order> ORDERS = prepareOrderList();

    public static Map<Long, Product> prepareProductList() {
        Map<Long, Product> products = new HashMap<>();
        products.put(1L, Product.builder().name("MICROSOFT Xbox Series X 1TB").seller(Seller.builder().name("Persona Technology").sector(Sector.ELECTRONICS).build()).price(BigDecimal.valueOf(8300)).build());
        products.put(2L, Product.builder().name("Apple USB-C Charge Cable (2m)").seller(Seller.builder().name("Apple").sector(Sector.TECHNOLOGY).build()).price(BigDecimal.valueOf(320)).build());
        products.put(3L, Product.builder().name("Valorant 8500 Vp").seller(Seller.builder().name("Riot Games").sector(Sector.GAMING).build()).price(BigDecimal.valueOf(635)).build());
        products.put(4L, Product.builder().name("Frost King RC160 Automatic Electric Roof Cable Kits").seller(Seller.builder().name("Frost King Store").sector(Sector.ELECTRONICS).build()).price(BigDecimal.valueOf(100)).build());
        products.put(5L, Product.builder().name("Pure Bliss Chocolate Gift Basket, Classic Ribbon").seller(Seller.builder().name("GODIVA").sector(Sector.FOOD).build()).price(BigDecimal.valueOf(78)).build());
        products.put(6L, Product.builder().name("Time Travel in Einstein's Universe: The Physical Possibilities of Travel Through Time").seller(Seller.builder().name("Mariner Books").sector(Sector.BOOKS).build()).price(BigDecimal.valueOf(65)).build());

        return products;
    }

    public static List<Order> prepareOrderList() {
        return List.of(Order.builder().products(List.of(PRODUCTS.get(1L))).customer(CUSTOMERS.get(1L)).createdDate(LocalDate.of(2022, 6, 22)).build(),
                Order.builder().products(List.of(PRODUCTS.get(1L), PRODUCTS.get(2L))).customer(CUSTOMERS.get(2L)).createdDate(LocalDate.of(2022, 6, 25)).build(),
                Order.builder().products(List.of(PRODUCTS.get(2L), PRODUCTS.get(5L))).customer(CUSTOMERS.get(3L)).createdDate(LocalDate.of(2022, 6, 21)).build(),
                Order.builder().products(List.of(PRODUCTS.get(4L), PRODUCTS.get(5L))).customer(CUSTOMERS.get(4L)).createdDate(LocalDate.of(2022, 6, 21)).build(),
                Order.builder().products(List.of(PRODUCTS.get(6L))).customer(CUSTOMERS.get(5L)).createdDate(LocalDate.of(2022, 6, 21)).build());
    }

    public static Map<Long, Customer> prepareCustomerList() {
        return Maps.newHashMap(ImmutableMap.of(1L, Customer.builder().fullName("Seza Kocadere").createdTime(LocalDate.of(2022, 6, 9)).build(),
                2L, Customer.builder().fullName("Slim Shady").createdTime(LocalDate.of(2022, 6, 5)).build(),
                3L, Customer.builder().fullName("Albert Einstein").createdTime(LocalDate.of(2022, 6, 1)).build(),
                4L, Customer.builder().fullName("Nikola Tesla").createdTime(LocalDate.of(2022, 6, 2)).build(),
                5L, Customer.builder().fullName("Stephen Hawking").createdTime(LocalDate.of(2022, 6, 1)).build()));
    }
}