package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class MockitoBasics {

    /*
     - The name
     - dependencies: core and junit jupiter
     - Classes: Mockito
     - mock() --> Defaults
     - mock() with Custom Answer
     - @Mock() -> who reads it?
     - Junit5 Extensions and Junit4 Runners.
     - when() and thenReturn()
     - two whens and UnnecessaryStubbingException
     - then(), thenThrow() and thenCallRealMethod()
     */

    @Mock
    private MyClass myClass;

    @BeforeEach
    void setUp() {
        Mockito.when(myClass.sayHello("Ahmed"))
                .thenReturn("Hello ya Ahmed");

        Mockito.when(myClass.sayHello("Mahmoud"))
                .thenReturn("Hello ya Mahmoud");
    }

    @Test
    void test() {
        assertEquals("Hello ya Ahmed", myClass.sayHello("Ahmed"));
    }


    @Test
    void test1() {
        assertEquals("Hello ya Mahmoud", myClass.sayHello("Mahmoud"));
    }

    private static class MyClass {
        public String sayHello(String name) {
            return "Hello ya " + name;
        }
    }

}
