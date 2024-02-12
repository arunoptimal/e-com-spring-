package com.boostmytool.beststore;

import java.util.List;

public interface ProductRepository {
    Product createProduct(Product product);
    Product getProductById(String productId);
    Product updateProduct(Product product);
    boolean deleteProduct(String productId);
    List<Product> getAllProducts();
}
