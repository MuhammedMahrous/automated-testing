package com.example.demo;

public class HelloWorld implements IHelloWorld {

    @Override
    public String sayHello(String name) {
        if (name == null || name.isBlank() || name.isEmpty())
            return "Hello";
        else
            return "Hello " + name;
    }

    @Override
    public boolean isPositiveNumber(String longStr) {
        if (longStr == null || longStr.isBlank() || longStr.isEmpty())
            return false;
        else {
            Long.parseLong(longStr);
            return true;
        }
    }
}
