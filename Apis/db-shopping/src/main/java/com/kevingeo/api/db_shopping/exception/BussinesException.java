package com.kevingeo.api.db_shopping.exception;

public class BussinesException extends RuntimeException {

    private static final long serialVersionUID = 2L;

    public BussinesException() {
        super();
    }

    public BussinesException(String message) {
        super(message);
    }
}
