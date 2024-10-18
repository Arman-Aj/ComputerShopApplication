package com.armanaj.computershop.payload.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ProductResponse<t> {

    @Getter
    @Setter
    private Integer currentPage;

    @Getter
    @Setter
    private Integer totalPages;

    @Getter
    @Setter
    private List<t> productList;

    public ProductResponse(Integer currentPage, Integer totalPages, List<t> productList) {
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.productList = productList;
    }
}
