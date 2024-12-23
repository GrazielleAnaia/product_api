package com.grazielle.product_api.business;

import com.grazielle.product_api.infrastructure.entity.Product;

import com.grazielle.product_api.infrastructure.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    /* return the list of entities */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /* return the list of entity */
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    /* update product
     * @param id the ID of the entity
     * @param updatedProduct the updated entity
     * return the updated entity
     */
    public Product updateProduct(Long id, Product updateProduct) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setName(updateProduct.getName());
            product.setPrice(updateProduct.getPrice());
            product.setQuantity(updateProduct.getQuantity());
            return productRepository.save(product);
        } else {
            throw new RuntimeException("Product not found.");
        }
    }

    /* delete the product by ID
     * @param id the ID of the entity
     */
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }


}
