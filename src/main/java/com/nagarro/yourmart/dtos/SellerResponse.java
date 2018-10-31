package com.nagarro.yourmart.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nagarro.yourmart.enums.SellerStatusEnum;

/**
 * @author Sanyam Goel created on 30/10/18
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SellerResponse {

    private long id;

    private String companyName;

    private String ownerName;

    private String address;

    private String emailAddress;

    private long telephoneNumber;

    private String gstNumber;

    private long sellerStatusId;

    private SellerStatusEnum sellerStatus;


    public SellerResponse() {

    }

    public SellerResponse(long id, String companyName, String ownerName, String address, String emailAddress, long telephoneNumber, String gstNumber, long sellerStatusId, SellerStatusEnum sellerStatus) {
        this.id = id;
        this.companyName = companyName;
        this.ownerName = ownerName;
        this.address = address;
        this.emailAddress = emailAddress;
        this.telephoneNumber = telephoneNumber;
        this.gstNumber = gstNumber;
        this.sellerStatusId = sellerStatusId;
        this.sellerStatus = sellerStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getSellerStatusId() {
        return sellerStatusId;
    }

    public void setSellerStatusId(long sellerStatusId) {
        this.sellerStatusId = sellerStatusId;
    }

    public SellerStatusEnum getSellerStatus() {
        return sellerStatus;
    }

    public void setSellerStatus(SellerStatusEnum sellerStatus) {
        this.sellerStatus = sellerStatus;
    }
}
