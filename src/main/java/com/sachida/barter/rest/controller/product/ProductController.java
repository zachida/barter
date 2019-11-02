package com.sachida.barter.rest.controller.product;

import com.sachida.barter.rest.api.product.ProductDTO;
import com.sachida.barter.rest.api.exception.BarterBadRequestException;
import com.sachida.barter.service.ProductService;
import com.sachida.barter.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
@Api
public class ProductController {

    private ProductService productService;
    private UserService userService;

    @PostMapping("{userId}/product")
    @ApiOperation(value = "Add Products")
    public List<ProductDTO> addProducts(@PathVariable String userId,@Valid @RequestBody List<ProductDTO> products) {
        return productService.addProducts(userId, products);
    }

    @GetMapping("{userId}/product/{productId}")
    @ApiOperation(value = "Get Product by Id")
    public ProductDTO getProduct(@PathVariable String userId, @PathVariable String productId) {
        return validateAndGetProductForUser(userId, productId);
    }

    @GetMapping("/{userId}/product/all")
    @ApiOperation(value = "Get all user's products")
    public List<ProductDTO> findProducts(@PathVariable String userId) {
        return productService.findAllProductsByUser(userId);
    }

    @DeleteMapping(value = "/{userId}/product/{productId}")
    @ApiOperation(value = "Delete Product")
    public void deleteProduct(@PathVariable String userId, @PathVariable String productId) {
        validateAndGetProductForUser(userId, productId);
        productService.deleteProduct(productId);
    }

    private ProductDTO validateAndGetProductForUser(String userId, String productId) {
        userService.getUser(userId); /* Is a valid user? */
        ProductDTO product = productService.getProduct(productId);
        if (product.getUserId().equals(Long.parseLong(userId))) {
            throw new BarterBadRequestException(String.format("product %s is not from user %s", productId, userId));
        }
        return product;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
