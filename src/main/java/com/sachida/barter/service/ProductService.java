package com.sachida.barter.service;

import com.sachida.barter.datasource.model.Product;
import com.sachida.barter.datasource.repository.ProductRepository;
import com.sachida.barter.rest.api.product.ProductDTO;
import com.sachida.barter.rest.api.exception.BarterNotFoundException;
import com.sachida.barter.rest.controller.translator.ProductTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import com.google.common.collect.Lists;


@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductDTO addProduct(String userId, ProductDTO productDTO) {
        Product product = ProductTranslator.translateToEntity(productDTO);
        product.setUserId(Long.parseLong(userId));
        return ProductTranslator.translateToDTO(productRepository.save(product));
    }

    public List<ProductDTO> addProducts(String userId, List<ProductDTO> productDTOs) {
        if (productDTOs.size() == 1) {
            return Lists.newArrayList(this.addProduct(userId,productDTOs.get(0)));
        }
        return productDTOs.stream().map(product -> this.addProduct(userId, product)).collect(Collectors.toList());
    }

    public ProductDTO getProduct(String productId) {
        return ProductTranslator.translateToDTO(this.getSavedProduct(productId));
    }

    public List<ProductDTO> findAllProductsByUser(String userId) {
        List<Product> allByUserId = productRepository.findAllByUserId(userId);
        return allByUserId.stream().map(ProductTranslator::translateToDTO).collect(Collectors.toList());
    }

    public void deleteProduct(String productId) {
        productRepository.deleteById(productId);
    }

    private Product getSavedProduct(String productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new BarterNotFoundException(String.format("%s is not a saved product", productId)));
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
