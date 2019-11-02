package com.sachida.barter.rest.api.product;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

public class ProductDTO implements Serializable {

    @NotBlank(message = "'name' is a required field.")
    @Size(min = 5, max = 100, message = "Wrong 'name' length.")
    private String name;
    @NotBlank(message = "'description' is a required field.")
    @Size(min = 10, max = 256, message = "Wrong 'description' length.")
    private String description;
    @NotBlank(message = "'amount' is a required field.")
    private BigDecimal amount;
    @NotBlank(message = "'unit' is a required field.")
    private String unit;
    @NotBlank(message = "'user_id' is a required field.")
    private Long userId;
    @NotBlank(message = "'price' is a required field.")
    private BigDecimal price;

    public ProductDTO() {
    }

    public ProductDTO(String name, String description, BigDecimal amount, String unit, BigDecimal price, Long userId) {
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.unit = unit;
        this.price = price;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}