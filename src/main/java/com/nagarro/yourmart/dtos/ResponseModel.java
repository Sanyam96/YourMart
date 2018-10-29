package com.nagarro.yourmart.dtos;

/**
 * @author Sanyam Goel created on 29/10/18
 */
public class ResponseModel<T> {

    private T data;

    private int statusCode;

    private ErrorResponseModel error;

    public ResponseModel() {
    }

    public ResponseModel(T data, int statusCode, ErrorResponseModel error) {
        this.data = data;
        this.statusCode = statusCode;
        this.error = error;
    }

    @Override
    public String toString() {
        return "ResponseModel{" +
                "data=" + data +
                ", statusCode=" + statusCode +
                ", error=" + error +
                '}';
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public ErrorResponseModel getError() {
        return error;
    }

    public void setError(ErrorResponseModel error) {
        this.error = error;
    }
}
