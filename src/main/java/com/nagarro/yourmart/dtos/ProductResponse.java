package com.nagarro.yourmart.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nagarro.yourmart.domains.Seller;
import com.nagarro.yourmart.enums.ProductStatusEnum;

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

    private long sellerId;

    private ProductStatusEnum productStatus;

    private long productStatusId;

    private long createdAt;

    private long updatedAt;

    // category
    private long categoryId;


    public ProductResponse() {

    }

    public ProductResponse(long id, String productName, String productCode, double mrp, double ssp, double ymp, String shortDescription, String longDescription, String dimensions, String comment, long sellerId, ProductStatusEnum productStatus, long productStatusId, long createdAt, long updatedAt, long categoryId) {
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
        this.productStatus = productStatus;
        this.productStatusId = productStatusId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.categoryId = categoryId;
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

    public ProductStatusEnum getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(ProductStatusEnum productStatus) {
        this.productStatus = productStatus;
    }

    public long getProductStatusId() {
        return productStatusId;
    }

    public void setProductStatusId(long productStatusId) {
        this.productStatusId = productStatusId;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
}
