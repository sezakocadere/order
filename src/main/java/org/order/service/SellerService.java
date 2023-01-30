package org.order.service;

import org.order.model.Seller;

import java.util.List;

public interface SellerService {
    List<Seller> getSellersByGivenMonth(int month);
}
