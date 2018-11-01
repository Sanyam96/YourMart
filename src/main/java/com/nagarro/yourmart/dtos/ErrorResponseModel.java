package com.nagarro.yourmart.dtos;

import com.nagarro.yourmart.enums.YourMartExceptionType;

import java.util.List;

/**
 * @author Sanyam Goel created on 29/10/18
 */
public class ErrorResponseModel {

    private YourMartExceptionType exceptionType;

    private String errorCode;

    private String errorMessage;

    private long time;

    private List<String> errorCause;

    public ErrorResponseModel(YourMartExceptionType exceptionType, String errorCode, String errorMessage, long time, List<String> errorCause) {
        this.exceptionType = exceptionType;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.time = time;
        this.errorCause = errorCause;
    }

    public ErrorResponseModel() {
    }

    public YourMartExceptionType getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(YourMartExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public List<String> getErrorCause() {
        return errorCause;
    }

    public void setErrorCause(List<String> errorCause) {
        this.errorCause = errorCause;
    }
}
