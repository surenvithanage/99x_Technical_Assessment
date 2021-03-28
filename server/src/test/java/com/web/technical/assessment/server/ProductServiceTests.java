package com.web.technical.assessment.server;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.web.technical.assessment.server.mapping.Product;
import com.web.technical.assessment.server.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTests {

    @MockBean
    ProductRepository productRepository;

    @Before
    public void setup() {
        Product product = new Product((long) 1, "PNE", "Penguin-ears", 20, 175, 7.5, 30, 3 , 10);
        when(productRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(product));
    }

    @Test
    public void whenValidId_thenProductShouldReturn() {
        Product product = productRepository.findById(Long.valueOf(1)).get();
        assertEquals("Penguin-ears", product.getCode());
    }

}
