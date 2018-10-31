package com.nagarro.yourmart.dtos;

/**
 * @author Sanyam Goel created on 31/10/18
 */
public class CategoryRequest {

    private String name;

    public CategoryRequest() {
    }

    public CategoryRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
