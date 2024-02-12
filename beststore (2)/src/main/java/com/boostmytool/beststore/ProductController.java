package com.boostmytool.beststore;

import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable String productId) {
        return productService.getProductById(productId);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{productId}")
    public boolean deleteProduct(@PathVariable String productId) {
        return productService.deleteProduct(productId);
    }

    @PatchMapping("/{productId}/apply-discount")
    public Product applyDiscount(@PathVariable String productId, @RequestParam BigDecimal discountPercentage) {
        return productService.applyDiscount(productId, discountPercentage);
    }

    @PatchMapping("/{productId}/apply-tax")
    public Product applyTax(@PathVariable String productId, @RequestParam BigDecimal taxRate) {
        return productService.applyTax(productId, taxRate);
    }
}
