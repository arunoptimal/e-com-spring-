package com.boostmytool.beststore;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        
        return productRepository.createProduct(product);
    }

    @Override
    public Product getProductById(String productId) {
       
        return productRepository.getProductById(productId);
    }

    @Override
    public Product updateProduct(Product product) {
        
        return productRepository.updateProduct(product);
    }

    @Override
    public boolean deleteProduct(String productId) {
        
        return productRepository.deleteProduct(productId);
    }

    @Override
    public Product applyTax(String productId, BigDecimal taxPercentage) {
        Product product = productRepository.getProductById(productId);
        if (product != null) {
            BigDecimal taxAmount = product.getPrice().multiply(taxPercentage).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
            BigDecimal newPrice = product.getPrice().add(taxAmount);
            product.setPrice(newPrice);
            return productRepository.updateProduct(product);
        }
        return null;
    }

    @Override
    public Product applyDiscount(String productId, BigDecimal discountPercentage) {
        Product product = productRepository.getProductById(productId);
        if (product != null) {
            BigDecimal discountAmount = product.getPrice().multiply(discountPercentage).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
            BigDecimal newPrice = product.getPrice().subtract(discountAmount);
            product.setPrice(newPrice);
            return productRepository.updateProduct(product);
        }
        return null;
    }
}
