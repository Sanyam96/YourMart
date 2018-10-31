package com.nagarro.yourmart.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Sanyam Goel created on 31/10/18
 */
public class SellerRequest {

    @JsonProperty(required = true)
    private String companyName;

    @JsonProperty(required = true)
    private String ownerName;

    @JsonProperty(required = true)
    private String address;

    @JsonProperty(required = true)
    private String emailAddress;

    @JsonProperty(required = true)
    private long telephoneNumber;

    @JsonProperty(required = true)
    private String gstNumber;

    @JsonProperty(required = true)
    private String password;

    // Todo to be removed from the request!
    @JsonProperty(required = false)
    private long sellerStatusId;

    public SellerRequest() {

    }

    public SellerRequest(String companyName, String ownerName, String address, String emailAddress, long telephoneNumber, String gstNumber, String password, long sellerStatusId) {
        this.companyName = companyName;
        this.ownerName = ownerName;
        this.address = address;
        this.emailAddress = emailAddress;
        this.telephoneNumber = telephoneNumber;
        this.gstNumber = gstNumber;
        this.password = password;
        this.sellerStatusId = sellerStatusId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public long getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(long telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getSellerStatusId() {
        return sellerStatusId;
    }

    public void setSellerStatusId(long sellerStatusId) {
        this.sellerStatusId = sellerStatusId;
    }
}
