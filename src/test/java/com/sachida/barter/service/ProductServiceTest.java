package com.sachida.barter.service;

import com.sachida.barter.datasource.model.Product;
import com.sachida.barter.datasource.model.Unit;
import com.sachida.barter.datasource.repository.ProductRepository;
import com.sachida.barter.rest.api.product.ProductDTO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.math.BigDecimal;

import static com.sachida.barter.asserts.ThrowableAssertion.assertThrown;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ProductServiceTest {

    @InjectMocks
    private ProductService service;

    @Mock
    ProductRepository repository;

    private Product product1 = new Product();
    private Product product2 = new Product();

    @Before
    public void setUp() {
        initMocks(this);

        product1.setDescription("Excelente estado");
        product1.setName("Batidora");
        product1.setUserId(45L);
        product1.setUnit(Unit.UNITY);
        product2.setDescription("No la uso, se ve bien");
        product2.setName("Cafetera");
        product2.setUserId(47L);
        product2.setUnit(Unit.UNITY);
    }

    @Test
    public void addProduct_nameNull() {
        when(repository.save(any(Product.class))).thenReturn(product1);
        ProductDTO productToSave = new ProductDTO();
        productToSave.setDescription("Description");
        productToSave.setAmount(BigDecimal.TEN);
        productToSave.setUnit("UNITY");
        productToSave.setUserId(2344L);
        productToSave.setPrice(BigDecimal.ONE);
        service.addProduct("45", productToSave);
        //assertThrown(() -> service.addProduct("45", productToSave));
    }

    @Test
    public void addProduct_descriptionNull() {
        when(repository.save(any(Product.class))).thenReturn(product1);
        ProductDTO productToSave = new ProductDTO();
        productToSave.setName("Name");
        productToSave.setAmount(BigDecimal.TEN);
        productToSave.setUnit("Unit");
        productToSave.setUserId(2344L);
        productToSave.setPrice(BigDecimal.ONE);

            assertThrown(() -> service.addProduct("45", productToSave));
    }

    @Test
    public void addProducts() {
    }

    @Test
    public void getProduct() {
    }

    @Test
    public void deleteProduct() {
    }

    @Test
    public void setProductRepository() {
    }
}