package com.nagarro.yourmart.dtos;

/**
 * @author Sanyam Goel created on 4/11/18
 */
public class ImageRequest {

    private byte[] image;

    private long productId;

    public ImageRequest() {
    }

    public ImageRequest(byte[] image, long productId) {
        this.image = image;
        this.productId = productId;
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
