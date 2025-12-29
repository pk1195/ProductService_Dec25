package com.example.productservicebydheerajkumar.exceptions;

public class ProductNotFoundException extends Exception{

    //create object of ProductNotFoundException class and set the error message
    public ProductNotFoundException(String message) {
        super(message);
    }
}
/*
use of super keyword in java
The super keyword in Java is used to refer to the immediate parent class of a class.
 It can be used to access parent class methods, constructors, and variables.

 */