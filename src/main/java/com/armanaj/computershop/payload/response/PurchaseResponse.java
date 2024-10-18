package com.armanaj.computershop.payload.response;

import com.armanaj.computershop.model.PurchaseProduct;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

public class PurchaseResponse {

    public PurchaseResponse() {
    }

    public PurchaseResponse(String state, Set<PurchaseProduct> purchaseProductList) {
        this.state = state;
        this.purchaseProductList = purchaseProductList;
    }

    @Getter
    @Setter
    private String state;

    @Getter
    @Setter
    private Set<PurchaseProduct> purchaseProductList;


}
