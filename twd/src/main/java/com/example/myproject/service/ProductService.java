package com.example.myproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.myproject.domain.Product;
import com.example.myproject.repository.ProductRepository;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product pr) {
        return pr;

    }

    

    public Page<Product> fetchProducts(Pageable page) {
        return this.productRepository.findAll(page);

    }

    // public Page<Product> fetchProductsWithSpec(Pageable page, String name) {
    //     return this.productRepository.findAll(ProductSpecs.nameLike(name), page);
    // }

    //case 1
    // public Page<Product> fetchProductsWithSpec(Pageable page, double min) {
    //     return this.productRepository.findAll(ProductSpecs.minPrice(min), page);
    // }

    //case 2
    // public Page<Product> fetchProductsWithSpec(Pageable page, double max) {
    //     return this.productRepository.findAll(ProductSpecs.maxPrice(max), page);
    // }

    //case 3
    // public Page<Product> fetchProductsWithSpec(Pageable page, String factory) {
    //     return this.productRepository.findAll(ProductSpecs.matchFactory(factory), page);
    // }

    //case 4
    // public Page<Product> fetchProductsWithSpec(Pageable page, List<String> factory) {
    //     return this.productRepository.findAll(ProductSpecs.matchListFactory(factory), page);
    // }

    //case 5
    public Page<Product> fetchProductsWithSpec(Pageable page, String price) {
        return null;
        // eg: price 10-toi-15-trieu

    }
    


    public Optional<Product> fetchProductById(long id) {
        return null;
    }

    public Object deleteProduct(long id) {
        return null;
    }

    public Object handleAddProductToCart(String email, long productId, HttpSession session){
        return null;
    }

    
}

