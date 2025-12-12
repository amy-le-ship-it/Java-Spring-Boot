package com.example.myproject.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "order_details")
public class Order_Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long quantity;
    private double price;

    // Many-to-One relationship with Order
    // orderId
    @ManyToOne
    @JoinColumn(name = "order_id") // Foreign key column in order_details table
    private Order order;

    // Many-to-One relationship with Product
    // productId
    @ManyToOne
    @JoinColumn(name = "product_id") // Foreign key column in order_details table
    private Product product;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
