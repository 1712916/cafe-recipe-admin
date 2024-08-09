package com.vinhnt.caferecipeadmin.service;

import com.vinhnt.caferecipeadmin.data.entity.Product;
import com.vinhnt.caferecipeadmin.data.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void whenSaveProduct_shouldReturnProduct() {
        Product product = new Product();
        product.setName("Test Name");

        when(productRepository.save(ArgumentMatchers.any(Product.class))).thenReturn(product);

        Product created = productService.save(product);

        assertThat(created.getName()).isSameAs(product.getName());
        verify(productRepository).save(product);
    }

    // Test update product
    @Test
    public void whenUpdateProduct_shouldReturnProduct() {
        Product product = new Product();
        product.setId(1L);
        product.setName("Test Name");

        when(productRepository.save(ArgumentMatchers.any(Product.class))).thenReturn(product);

        Product updated = productService.save(product);

        assertThat(updated.getName()).isSameAs(product.getName());
        verify(productRepository).save(product);
    }

    //Test delete product
    @Test
    public void whenDeleteProduct_notFoundId() {
        Product product = new Product();
        product.setId(1L);

        when(productRepository.findById(product.getId())).thenReturn(Optional.empty());

        Throwable exception = assertThrows(ProductNotFoundException.class, () -> {
            productService.deleteById(product.getId());
        });

        assertEquals("Product not found with id: 1", exception.getMessage());

        verify(productRepository).findById(product.getId());
    }
}
