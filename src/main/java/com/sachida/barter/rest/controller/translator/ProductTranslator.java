package com.sachida.barter.rest.controller.translator;

import com.sachida.barter.datasource.model.Product;
import com.sachida.barter.datasource.model.Unit;
import com.sachida.barter.rest.api.product.ProductDTO;

public class ProductTranslator {

    public static Product translateToEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setUnit(Unit.valueOf(productDTO.getUnit().toUpperCase()));
        return product;
    }

    public static ProductDTO translateToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setUnit(product.getUnit().name());
        return productDTO;
    }

}
