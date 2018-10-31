package com.nagarro.yourmart.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Sanyam Goel created on 31/10/18
 */
public class ProductRequest {

    @JsonProperty(required = true)
    private String productCode;

    @JsonProperty(required = true)
    private String productName;

    @JsonProperty(required = true)
    private String shortDescription;

    @JsonProperty(required = false)
    private String longDescription;

    @JsonProperty(required = false)
    private String dimensions;

    @JsonProperty(required = true)
    private long categoryId;

    @JsonProperty(required = true)
    private double mrp;

    @JsonProperty(required = false)
    private double ssp;

    @JsonProperty(required = true)
    private double ymp;

//    primary Image
    // private IMAGE primaryImage;

//    gallary Images
    // private ArrayList[IMAGE] gallaryImages;

    // Todo change this to required = true and change the data type of usageInstructions to a fileType in the PDF
//    @JsonProperty(required = false)
//    private String usageInstructions;

    // Todo product attibutes in the form of key:value pair
    // private MetaData productAttributes;

    @JsonProperty(required = true)
    private long sellerId;

    // todo tobe removed from request
    @JsonProperty(required = false)
    private long productStatusId;

    @JsonProperty(required = false)
    private String comment;


    public ProductRequest() {
    }

    public ProductRequest(String productCode, String productName, String shortDescription, String longDescription, String dimensions, long categoryId, double mrp, double ssp, double ymp, long sellerId, long productStatusId, String comment) {
        this.productCode = productCode;
        this.productName = productName;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.dimensions = dimensions;
        this.categoryId = categoryId;
        this.mrp = mrp;
        this.ssp = ssp;
        this.ymp = ymp;
        this.sellerId = sellerId;
        this.productStatusId = productStatusId;
        this.comment = comment;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
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

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public long getProductStatusId() {
        return productStatusId;
    }

    public void setProductStatusId(long productStatusId) {
        this.productStatusId = productStatusId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
