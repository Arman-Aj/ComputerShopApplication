package com.armanaj.computershop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Getter
    @Setter
    private Integer id;

    @ManyToOne
    @Getter
    @Setter
    @NonNull
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "purchase")
    @Getter
    @Setter
    private List<PurchaseProduct> purchaseProductList;

    @Transient
    @Getter
    @Setter
    private Integer itemCount;

    @Transient
    @Getter
    @Setter
    private Double priceSum;
}
