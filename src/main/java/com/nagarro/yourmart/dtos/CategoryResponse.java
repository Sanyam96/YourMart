package com.nagarro.yourmart.dtos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Sanyam Goel created on 31/10/18
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryResponse {

    private long id;

    private String name;

    private long createdAt;

    private long updatedAt;

    private long productCount;

    public CategoryResponse() {
    }

    public CategoryResponse(long id, String name, long createdAt, long updatedAt, long productCount) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.productCount = productCount;
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

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public long getProductCount() {
        return productCount;
    }

    public void setProductCount(long productCount) {
        this.productCount = productCount;
    }
}
