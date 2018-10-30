package com.nagarro.yourmart.domains;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

/**
 * @author Sanyam Goel created on 30/10/18
 */
@Entity
@Table(name = "product_status")
public class ProductStatus extends BaseEntity {

    @Id
    @Column(name = "product_status_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "productStatus", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Products> products;


    // Constructors
    public ProductStatus() {

    }

    public ProductStatus(long createdAt, long updatedAt, long id, String name, List<Products> products) {
        super(createdAt, updatedAt);
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public ProductStatus(long id, String name, List<Products> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }
}
