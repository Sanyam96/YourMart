package com.nagarro.yourmart.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * @author Sanyam Goel created on 4/11/18
 */
@Entity
@Table(name = "images")
public class Image extends BaseEntity {

    @Id
    @Column(name = "image_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "product_id", insertable = false, updatable = false)
    private long productId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    private Products products;


    public Image() {
    }

    public Image(long createdAt, long updatedAt) {
        super(createdAt, updatedAt);
    }

    public Image(long createdAt, long updatedAt, long id, byte[] image, long productId, Products products) {
        super(createdAt, updatedAt);
        this.id = id;
        this.image = image;
        this.productId = productId;
        this.products = products;
    }

    public Image(long id, byte[] image, long productId, Products products) {
        this.id = id;
        this.image = image;
        this.productId = productId;
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
}
