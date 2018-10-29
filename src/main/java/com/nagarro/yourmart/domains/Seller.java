package com.nagarro.yourmart.domains;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Sanyam Goel created on 29/10/18
 */
@Entity
@Table(name = "seller")
public class Seller extends BaseEntity {

    @Id
    @Column(name = "seller_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
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

//    Mappings
    @OneToMany(mappedBy = "seller")
    private List<Products> products;

    @OneToOne
    @JoinColumn(name = "seller_status_id", nullable = false)
    private SellerStatus sellerStatusId;

//    Constructors
    public Seller() {

    }

    public Seller(long createdAt, long updatedAt, long id, String companyName, String ownerName, String address, String emailAddress, long telephoneNumber, String gstNumber, String password, List<Products> products, SellerStatus sellerStatusId) {
        super(createdAt, updatedAt);
        this.id = id;
        this.companyName = companyName;
        this.ownerName = ownerName;
        this.address = address;
        this.emailAddress = emailAddress;
        this.telephoneNumber = telephoneNumber;
        this.gstNumber = gstNumber;
        this.password = password;
        this.products = products;
        this.sellerStatusId = sellerStatusId;
    }

    public Seller(long id, String companyName, String ownerName, String address, String emailAddress, long telephoneNumber, String gstNumber, String password, List<Products> products, SellerStatus sellerStatusId) {
        this.id = id;
        this.companyName = companyName;
        this.ownerName = ownerName;
        this.address = address;
        this.emailAddress = emailAddress;
        this.telephoneNumber = telephoneNumber;
        this.gstNumber = gstNumber;
        this.password = password;
        this.products = products;
        this.sellerStatusId = sellerStatusId;
    }

//    Getter and Setters
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

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public SellerStatus getSellerStatusId() {
        return sellerStatusId;
    }

    public void setSellerStatusId(SellerStatus sellerStatusId) {
        this.sellerStatusId = sellerStatusId;
    }
}
