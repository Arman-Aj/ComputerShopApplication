package com.armanaj.computershop.payload.request;

import com.armanaj.computershop.model.PurchaseProduct;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

public class PurchaseRequest {

    @Getter
    @Setter
    private Integer userId;

    @Getter
    @Setter
    private Set<PurchaseProduct> purchaseProductList;
}
