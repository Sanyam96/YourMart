package com.nagarro.yourmart.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;

/**
 * @author Sanyam Goel created on 2/11/18
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminResponse {

    private long id;

    private String username;

    private String name;

    private String email;

    public AdminResponse() {

    }

    public AdminResponse(long id, String username, String name, String email) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
