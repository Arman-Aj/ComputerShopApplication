package com.armanaj.computershop.payload.response;

import com.armanaj.computershop.model.Purchase;
import com.armanaj.computershop.model.PurchaseProduct;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class UserPurchasesResponse {

    public UserPurchasesResponse(Integer currentPage, Integer totalPages, List<Purchase> purchaseList) {
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.purchaseList = purchaseList;
        for (Purchase purchase: this.purchaseList) {
            int itemCount = 0;
            double priceSum = 0;
            for (PurchaseProduct item : purchase.getPurchaseProductList()) {
                itemCount += item.getCount();
                priceSum += item.getProduct().getPrice() * item.getCount();
            }
            purchase.setPriceSum(priceSum);
            purchase.setItemCount(itemCount);
        }
    }

    @Getter
    @Setter
    private Integer currentPage;

    @Getter
    @Setter
    private Integer totalPages;

    @Getter
    @Setter
    private List<Purchase> purchaseList;


}
