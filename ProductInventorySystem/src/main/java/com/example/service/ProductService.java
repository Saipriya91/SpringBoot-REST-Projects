
package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Product;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();

    public List<Product> getAllProducts() {
        return products;
    }

    public Product addProduct(Product product) {
        products.add(product);
        return product;
    }

    public Product getProductById(int id) {
        for (Product product : products) {
            if (product.getProductId() == id) {
                return product;
            }
        }
        return null;
    }

    public Product updateProduct(int id, Product updatedProduct) {
        for (Product product : products) {
            if (product.getProductId() == id) {
                product.setProductName(updatedProduct.getProductName());
                product.setCategory(updatedProduct.getCategory());
                product.setStock(updatedProduct.getStock());
                product.setPrice(updatedProduct.getPrice());
                return product;
            }
        }
        return null;
    }

    public boolean deleteProduct(int id) {
        return products.removeIf(
            product -> product.getProductId() == id
        );
    }
}
