package com.nagarro.yourmart.exceptions;

/**
 * @author Sanyam Goel created on 29/10/18
 */
public class YourMartBaseException extends RuntimeException {

    private String errorCode;

    public YourMartBaseException() {
    }

    public YourMartBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public YourMartBaseException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public YourMartBaseException(String message) {
        super(message);
    }

    public YourMartBaseException(Throwable cause) {
        super(cause);
    }

    public YourMartBaseException(String message, String errorCode, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}
