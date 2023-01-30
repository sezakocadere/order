package org.order.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Seller {
    private String name;
    private Sector sector;
}
