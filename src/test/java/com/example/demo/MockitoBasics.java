package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

//TODO(3): Extensions @ExtendWith(MockitoExtension.class)
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

    // TODO(2): @Mock

    @Mock
    private MyClass myClass;

    @BeforeEach
    void setUp() {
        // TODO(1): programmatic mocking

        // TODO(2): custom Answer

        // TODO(4): when().thenReturn()

        // TODO(5): when().then()

        // TODO(6): when().thenThrow()

        // TODO(7): when().thenCallRealMethod()

        // TODO(8): two whens and MockitoSettings strictness
    }

    @Test
    void test() {
    }

    private static class MyClass {
        public String sayHello(String name) {
            return "Hello ya " + name;
        }
    }

}
