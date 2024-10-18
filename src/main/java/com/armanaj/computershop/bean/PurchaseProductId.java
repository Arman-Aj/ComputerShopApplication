package com.armanaj.computershop.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class PurchaseProductId implements Serializable {

    @Getter
    @Setter
    private int purchase;

    @Getter
    @Setter
    private int product;
}
