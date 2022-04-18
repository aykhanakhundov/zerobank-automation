package com.zeroBank.utilities;

public class NotElementDefinedException extends RuntimeException{

    public NotElementDefinedException(String element){
        super("No such element found in PoM. Check your getElement() parameter or define the element: " + element);
    }
}
