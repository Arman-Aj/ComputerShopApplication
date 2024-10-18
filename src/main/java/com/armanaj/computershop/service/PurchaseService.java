package com.armanaj.computershop.service;

import com.armanaj.computershop.model.Purchase;
import com.armanaj.computershop.model.PurchaseProduct;
import com.armanaj.computershop.payload.request.PurchaseRequest;
import com.armanaj.computershop.payload.response.UserPurchasesResponse;
import com.armanaj.computershop.repository.PurchaseProductRepository;
import com.armanaj.computershop.repository.PurchaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

    private PurchaseRepository purchaseRepository;
    private PurchaseProductRepository purchaseProductRepository;
    private UserService userService;

    public PurchaseService(PurchaseRepository purchaseRepository, PurchaseProductRepository purchaseProductRepository, UserService userService) {
        this.purchaseRepository = purchaseRepository;
        this.purchaseProductRepository = purchaseProductRepository;
        this.userService = userService;
    }

    public void savePurchase(PurchaseRequest request) {
        Purchase purchase = new Purchase();
        purchase.setUser(userService.getUserById(request.getUserId()));
        Purchase savedPurchase = purchaseRepository.save(purchase);

        for (PurchaseProduct purchaseProduct :
                request.getPurchaseProductList()) {
            purchaseProduct.setPurchase(savedPurchase);
            purchaseProductRepository.save(purchaseProduct);
        }
    }

    public UserPurchasesResponse findPurchasesByUserId(Integer userID, Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10, Sort.by("id"));
        Page<Purchase> page = purchaseRepository.findPurchasesByUserId(userID, pageable);
        return new UserPurchasesResponse(page.getNumber(), page.getTotalPages(), page.getContent());
    }
}
