package com.nagarro.yourmart.domains;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Sanyam Goel created on 29/10/18
 */
@Entity
@Table(name = "seller")
public class Seller extends BaseEntity {

    @Id
    @Column(name = "seller_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "ownerName")
    private String ownerName;

    @Column(name = "address")
    private String address;

    @Column(name = "emailAddress")
    private String emailAddress;

    @Column(name = "telephone_number")
    private long telephoneNumber;

    @Column(name = "gst_number")
    private String gstNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "seller_status_id")
    @GeneratedValue
    private long sellerStatusId;


    //Mappings
    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<SellerStatus> sellerStatuses;


    public Seller() {

    }

    public Seller(long createdAt, long updatedAt, long id, String companyName, String ownerName, String address, String emailAddress, long telephoneNumber, String gstNumber, String password, long sellerStatusId, Set<SellerStatus> sellerStatuses) {
        super(createdAt, updatedAt);
        this.id = id;
        this.companyName = companyName;
        this.ownerName = ownerName;
        this.address = address;
        this.emailAddress = emailAddress;
        this.telephoneNumber = telephoneNumber;
        this.gstNumber = gstNumber;
        this.password = password;
        this.sellerStatusId = sellerStatusId;
        this.sellerStatuses = sellerStatuses;
    }

    public Seller(long id, String companyName, String ownerName, String address, String emailAddress, long telephoneNumber, String gstNumber, String password, long sellerStatusId, Set<SellerStatus> sellerStatuses) {
        this.id = id;
        this.companyName = companyName;
        this.ownerName = ownerName;
        this.address = address;
        this.emailAddress = emailAddress;
        this.telephoneNumber = telephoneNumber;
        this.gstNumber = gstNumber;
        this.password = password;
        this.sellerStatusId = sellerStatusId;
        this.sellerStatuses = sellerStatuses;
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

    public Set<SellerStatus> getSellerStatuses() {
        return sellerStatuses;
    }

    public void setSellerStatuses(Set<SellerStatus> sellerStatuses) {
        this.sellerStatuses = sellerStatuses;
    }
}
