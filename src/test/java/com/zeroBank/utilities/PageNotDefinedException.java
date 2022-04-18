package com.zeroBank.utilities;

public class PageNotDefinedException extends RuntimeException{

    public PageNotDefinedException(String pageName) {
        super("No such Page Object found. Check your pageObjectFactory parameter or define the page: " + pageName);
    }
}
