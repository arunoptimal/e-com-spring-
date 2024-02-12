package com.boostmytool.beststore;

import java.math.BigDecimal;

public interface ProductService {
    Product createProduct(Product product);
    Product getProductById(String productId);
    Product updateProduct(Product product);
    boolean deleteProduct(String productId);
    Product applyDiscount(String productId, BigDecimal discountPercentage);
    Product applyTax(String productId, BigDecimal taxRate);
}
