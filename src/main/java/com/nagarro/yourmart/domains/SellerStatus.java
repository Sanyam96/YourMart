package com.nagarro.yourmart.domains;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Sanyam Goel created on 29/10/18
 */
@Entity
@Table(name = "seller_status")
public class SellerStatus extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sellerStatusId;

    @Column(name = "name")
    private String name;


    // Mappings
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sellerStatusId")
    private Seller seller;


    // Constructors
    public SellerStatus() {

    }

    public SellerStatus(long createdAt, long updatedAt, Long sellerStatusId, String name, Seller seller) {
        super(createdAt, updatedAt);
        this.sellerStatusId = sellerStatusId;
        this.name = name;
        this.seller = seller;
    }

    public SellerStatus(Long sellerStatusId, String name, Seller seller) {
        this.sellerStatusId = sellerStatusId;
        this.name = name;
        this.seller = seller;
    }

    public Long getSellerStatusId() {
        return sellerStatusId;
    }

    public void setSellerStatusId(Long sellerStatusId) {
        this.sellerStatusId = sellerStatusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
