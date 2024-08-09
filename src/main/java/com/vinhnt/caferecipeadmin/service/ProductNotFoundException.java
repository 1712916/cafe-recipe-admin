package com.vinhnt.caferecipeadmin.service;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(Long id) {
        super("Product not found with id: " + id);
    }
}
