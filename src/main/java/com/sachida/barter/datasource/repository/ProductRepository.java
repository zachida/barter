package com.sachida.barter.datasource.repository;

import com.sachida.barter.datasource.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, String> {

    List<Product> findAllByUserId(String userId);
}