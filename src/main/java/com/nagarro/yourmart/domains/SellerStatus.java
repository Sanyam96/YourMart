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




    // Constructors
    public SellerStatus() {

    }

    public SellerStatus(long createdAt, long updatedAt, long id, String name) {
        super(createdAt, updatedAt);
        this.id = id;
        this.name = name;
    }

    public SellerStatus(long id, String name) {
        this.id = id;
        this.name = name;
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

}
