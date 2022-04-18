package com.zeroBank.utilities;

public class UnknownParameterException extends RuntimeException {
    public UnknownParameterException(String message) {
        super("Specified parameter is not recognised in PoM. Fix parameter or add it to PoM: " + message);
    }
}
