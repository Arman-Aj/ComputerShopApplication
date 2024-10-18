package com.armanaj.computershop.controller;

import com.armanaj.computershop.payload.request.ChangePasswordRequest;
import com.armanaj.computershop.payload.request.PurchaseRequest;
import com.armanaj.computershop.payload.response.MessageResponse;
import com.armanaj.computershop.payload.response.PurchaseResponse;
import com.armanaj.computershop.payload.response.UserPurchasesResponse;
import com.armanaj.computershop.security.services.UserDetailsImpl;
import com.armanaj.computershop.service.PurchaseService;
import com.armanaj.computershop.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
public class UserController {

    private final PurchaseService purchaseService;

    private final UserService userService;

    public UserController(PurchaseService purchaseService, UserService userService) {
        this.purchaseService = purchaseService;
        this.userService = userService;
    }

    @PostMapping("/add-purchase")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<PurchaseResponse> addPurchase(@Valid @RequestBody PurchaseRequest purchase) {
        if (purchase.getUserId() == null || purchase.getPurchaseProductList().size() == 0) {
            return ResponseEntity.badRequest().build();
        }
        purchaseService.savePurchase(purchase);
        return ResponseEntity.ok(new PurchaseResponse("Purchase Saved Successfully", purchase.getPurchaseProductList()));
    }

    @GetMapping("/get-purchases")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<UserPurchasesResponse> getUserPurchases(@RequestParam(defaultValue = "0") int page) {
        UserDetailsImpl user = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserPurchasesResponse response = purchaseService.findPurchasesByUserId(user.getId(), page == 0 ? page : page - 1);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/change-password")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<MessageResponse> changeUserPassword(@Valid @RequestBody ChangePasswordRequest request) {
        UserDetailsImpl user = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userService.checkIfOldPasswordMatches(user.getId(), request.getOldPassword())) {
            userService.changeUserPassword(user.getId(), request.getNewPassword());
        }

        MessageResponse response = new MessageResponse("Password changed successfully. Please login again.");
        return ResponseEntity.ok(response);
    }
}