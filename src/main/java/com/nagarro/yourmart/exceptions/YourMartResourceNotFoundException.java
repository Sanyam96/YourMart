package com.nagarro.yourmart.exceptions;

/**
 * @author Sanyam Goel created on 29/10/18
 */
public class YourMartResourceNotFoundException extends YourMartBaseException {

    public YourMartResourceNotFoundException() {
    }

    public YourMartResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public YourMartResourceNotFoundException(String message, String errorCode) {
        super(message, errorCode);
    }

    public YourMartResourceNotFoundException(String message) {
        super(message);
    }

    public YourMartResourceNotFoundException(Throwable cause) {
        super(cause);
    }

    public YourMartResourceNotFoundException(String message, String errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }
}
