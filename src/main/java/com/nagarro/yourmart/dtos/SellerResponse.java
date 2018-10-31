package com.nagarro.yourmart.dtos;

/**
 * @author Sanyam Goel created on 31/10/18
 */
public class SellerResponse {

    private long id;

    private String companyName;

    private String ownerName;

    private String address;

    private String emailAddress;

    private long telephoneNumber;

    private String gstNumber;

    private long sellerStatusId;

    private String sellerStatus;


    public SellerResponse() {

    }

    public SellerResponse(long id, String companyName, String ownerName, String address, String emailAddress, long telephoneNumber, String gstNumber, long sellerStatusId, String sellerStatus) {
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

    public String getSellerStatus() {
        return sellerStatus;
    }

    public void setSellerStatus(String sellerStatus) {
        this.sellerStatus = sellerStatus;
    }
}
