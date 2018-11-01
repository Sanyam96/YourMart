package com.nagarro.yourmart.dtos;

/**
 * @author Sanyam Goel created on 1/11/18
 */
public class SellerLoginRequest {

    private long id;

    private String password;

    public SellerLoginRequest() {

    }

    public SellerLoginRequest(long id, String password) {
        this.id = id;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
