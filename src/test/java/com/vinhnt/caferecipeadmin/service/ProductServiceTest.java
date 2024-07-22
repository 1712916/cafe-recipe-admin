package com.vinhnt.caferecipeadmin.service;

import com.vinhnt.caferecipeadmin.data.entity.Product;
import com.vinhnt.caferecipeadmin.data.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
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
}
