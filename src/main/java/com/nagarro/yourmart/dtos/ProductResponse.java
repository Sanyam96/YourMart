package com.nagarro.yourmart.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nagarro.yourmart.domains.Seller;

import javax.persistence.*;

/**
 * @author Sanyam Goel created on 29/10/18
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResponse {

    private long id;

    private String productName;

    private String productCode;

    private double mrp;

    private double ssp;

    private double ymp;

    private String shortDescription;

    private String longDescription;

//    File store
//    private File usageInstructions;

    private String dimensions;

    private String comment;

//    MetaData -> Product Attributes
//    private Metadata productAttributes

//    CategoryID

    private long sellerId;


    public ProductResponse() {

    }

    public ProductResponse(long id, String productName, String productCode, double mrp, double ssp, double ymp, String shortDescription, String longDescription, String dimensions, String comment, long sellerId) {
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
        this.sellerId = sellerId;
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

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }
}
