package org.example.test.linpaitong;

public class APIException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String msg;
    public APIException(String msg) {
        super(msg);
        this.msg = msg;
    }
}