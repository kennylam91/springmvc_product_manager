package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> findAllProduct();

    Map<Integer, Product> createNewProduct(Product product);

    Product findProductById(int id);

    void deleteProduct(int id);
}
