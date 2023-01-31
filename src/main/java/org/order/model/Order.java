package org.order.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class Order {
    private List<Product> products;
    private Customer customer;
    private LocalDate createdDate;

    public BigDecimal getInvoice() {
        return products.stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}