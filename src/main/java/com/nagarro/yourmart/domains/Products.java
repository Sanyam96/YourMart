package com.nagarro.yourmart.domains;

import javax.persistence.*;

/**
 * @author Sanyam Goel created on 29/10/18
 */
@Entity
@Table(name = "products")
public class Products extends BaseEntity {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_code", nullable = false)
    private String productCode;

    @Column(name = "mrp", nullable = false)
    private double mrp;

    @Column(name = "ssp")
    private double ssp;

    @Column(name = "ymp", nullable = false)
    private double ymp;

    @Column(name = "short_description", length = 63, nullable = false)
    private String shortDescription;

    @Column(name = "long_description")
    private String longDescription;

//    File store
//    private File usageInstructions;

    @Column(name = "dimensions")
    private String dimensions;

    @Column(name = "comment")
    private String comment;

//    MetaData -> Product Attributes
//    private Metadata productAttributes

//    CategoryID


//    Mappings
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;


    public Products() {

    }

    public Products(long createdAt, long updatedAt, long id, String productName, String productCode, double mrp, double ssp, double ymp, String shortDescription, String longDescription, String dimensions, String comment, Seller seller) {
        super(createdAt, updatedAt);
        this.id = id;
        this.productName = productName;
        this.productCode = productCode;
        this.mrp = mrp;
        this.ssp = ssp;
        this.ymp = ymp;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.dimensions = dimensions;
        this.comment = comment;
        this.seller = seller;
    }

    public Products(long id, String productName, String productCode, double mrp, double ssp, double ymp, String shortDescription, String longDescription, String dimensions, String comment, Seller seller) {
        this.id = id;
        this.productName = productName;
        this.productCode = productCode;
        this.mrp = mrp;
        this.ssp = ssp;
        this.ymp = ymp;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.dimensions = dimensions;
        this.comment = comment;
        this.seller = seller;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public double getMrp() {
        return mrp;
    }

    public void setMrp(double mrp) {
        this.mrp = mrp;
    }

    public double getSsp() {
        return ssp;
    }

    public void setSsp(double ssp) {
        this.ssp = ssp;
    }

    public double getYmp() {
        return ymp;
    }

    public void setYmp(double ymp) {
        this.ymp = ymp;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
