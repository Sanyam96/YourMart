package com.nagarro.yourmart.domains;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * @author Sanyam Goel created on 29/10/18
 */
@Entity
@Table(name = "seller_status")
public class SellerStatus extends BaseEntity {

    @Id
    @Column(name = "seller_status_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

//    Mappings
    // SellerStatus and Seller
//    @JsonManagedReference
//    @OneToOne(mappedBy = "sellerStatusId")
//    private Seller Seller;

    @JsonManagedReference
    @OneToMany(mappedBy = "sellerStatus", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Seller> sellers;


    // Constructors
    public SellerStatus() {

    }

    public SellerStatus(long createdAt, long updatedAt, long id, String name, List<Seller> sellers) {
        super(createdAt, updatedAt);
        this.id = id;
        this.name = name;
        this.sellers = sellers;
    }

    public SellerStatus(long id, String name, List<Seller> sellers) {
        this.id = id;
        this.name = name;
        this.sellers = sellers;
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

    public List<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(List<Seller> sellers) {
        this.sellers = sellers;
    }
}
