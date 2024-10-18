package com.armanaj.computershop.model;

import com.armanaj.computershop.bean.PurchaseProductId;
import com.armanaj.computershop.model.products.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@IdClass(PurchaseProductId.class)
public class PurchaseProduct {

    @Id
    @ManyToOne
    @Getter
    @Setter
    @JoinColumn(name = "purchase_id", referencedColumnName = "id")
    @JsonIgnore
    private Purchase purchase;

    @Id
    @ManyToOne
    @Getter
    @Setter
    private Product product;

    @Getter
    @Setter
    private Integer count;
}
