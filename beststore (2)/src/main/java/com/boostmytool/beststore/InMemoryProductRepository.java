package com.boostmytool.beststore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryProductRepository implements ProductRepository {
    private final Map<String, Product> productMap;

    public InMemoryProductRepository() {
        this.productMap = new HashMap<>();
    }

    @Override
    public Product createProduct(Product product) {
       
        return product;
    }

    @Override
    public Product getProductById(String productId) {
        
        return productMap.get(productId);
    }

    @Override
    public Product updateProduct(Product product) {
        return productMap.put(product.getProductId(), product);
    }

    @Override
    public boolean deleteProduct(String productId) {
       
        return productMap.remove(productId) != null;
    }

    @Override
    public List<Product> getAllProducts() {
        
        return new ArrayList<>(productMap.values());
    }
}
