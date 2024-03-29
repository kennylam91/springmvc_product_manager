package com.codegym.service;

import com.codegym.model.Product;

import java.util.*;

public class ProductServiceImpl implements ProductService {

    private static Map<Integer,Product> products=new HashMap<>();
    static{
        products.put(1,new Product(1,"Tivi","Sony 42",10000));
        products.put(2,new Product(2,"Dien thoai","Sam sung Note8",15000));
        products.put(3,new Product(3,"Xe may","Honda Airblade",50000));
        products.put(4,new Product(4,"Dong ho","Apple watch",12000));

    }
    @Override
    public List<Product> findAllProduct() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Map<Integer,Product> createNewProduct(Product product) {
        int key=getRandomId();
        product.setId(key);
        products.put(key,product);
        return products;
    }

    @Override
    public Product findProductById(int id) {
        return products.get(id);
    }

    private int getRandomId(){
        Random random=new Random();
        return random.nextInt(100000);
    }

    @Override
    public void deleteProduct(int id) {
        products.remove(id);
    }

    @Override
    public void updateProduct(Product product) {
        products.put(product.getId(),product);
    }
}
