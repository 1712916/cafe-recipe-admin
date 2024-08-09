package com.vinhnt.caferecipeadmin.service;

import com.vinhnt.caferecipeadmin.data.entity.Product;
import com.vinhnt.caferecipeadmin.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        //todo: check required data
        return productRepository.save(product);
    }

    public void deleteById(Long id) throws ProductNotFoundException {
        productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        productRepository.deleteById(id);
    }
}