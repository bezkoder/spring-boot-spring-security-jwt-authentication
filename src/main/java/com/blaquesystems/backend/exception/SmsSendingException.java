package com.blaquesystems.backend.exception;

public class SmsSendingException extends Exception {
    public SmsSendingException(String message) {
        super(message);
    }

    public SmsSendingException(String message, Throwable cause) {
        super(message, cause);
    }
}
