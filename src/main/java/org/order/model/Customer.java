package org.order.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Customer {
    private String fullName;
    private LocalDate createdTime;
}
