package com.nagarro.yourmart.exceptions;

/**
 * @author Sanyam Goel created on 29/10/18
 */
public class YourMartHibernateException extends YourMartBaseException {

    public YourMartHibernateException() {
    }

    public YourMartHibernateException(String message, Throwable cause) {
        super(message, cause);
    }

    public YourMartHibernateException(String message, String errorCode) {
        super(message, errorCode);
    }

    public YourMartHibernateException(String message) {
        super(message);
    }

    public YourMartHibernateException(Throwable cause) {
        super(cause);
    }

    public YourMartHibernateException(String message, String errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }
}
