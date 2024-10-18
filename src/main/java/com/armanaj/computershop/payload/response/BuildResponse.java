package com.armanaj.computershop.payload.response;

import com.armanaj.computershop.model.products.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class BuildResponse {

    @Getter
    @Setter
    private List<Product> productList;

    @Getter
    @Setter
    private List<String> warningList;

    @Getter
    @Setter
    private Integer itemCount;

    @Getter
    @Setter
    private Double priceSum;


}
