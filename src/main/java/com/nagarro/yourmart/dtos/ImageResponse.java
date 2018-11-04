package com.nagarro.yourmart.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Sanyam Goel created on 4/11/18
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageResponse {

    private long id;

    private byte[] image;

    private long productId;

    public ImageResponse() {
    }

    public ImageResponse(long id, byte[] image, long productId) {
        this.id = id;
        this.image = image;
        this.productId = productId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
