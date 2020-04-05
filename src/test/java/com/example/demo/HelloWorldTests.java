package com.example.demo;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HelloWorldTests {
    private IHelloWorld helloWorld;

    @BeforeAll
    void setUp() {
        System.out.println("Setting UP.....");
        helloWorld = new HelloWorld();
    }

    @Test
    @DisplayName("Null Name")
    void sayHello_nullName() {
        String actual = helloWorld.sayHello(null);
        assertEquals("Hello", actual);
    }

    @Test
    @DisplayName("Empty Name")
    void sayHello_emptyName() {
        String actual = helloWorld.sayHello("");
        assertEquals("Hello", actual);
    }

    @Test
    @DisplayName("Blank Name")
    void sayHello_blankName() {
        String actual = helloWorld.sayHello("    ");
        assertEquals("Hello", actual);
    }

    @Test
    @DisplayName("Happy Scenario")
    void sayHello_happyScenario() {
        String actual = helloWorld.sayHello("Mahrous");
        assertEquals("Hello Mahrous", actual);
    }

    @Test
    @DisplayName("Complex Happy Scenario")
    @Disabled
    void sayHello_ComplexHappyScenario() {
        assertAll("Say Hello",
                () -> assertEquals("Hello Mahrous", helloWorld.sayHello("Mahrous")),
                () -> assertTimeout(Duration.ofMillis(1), () -> helloWorld.sayHello("Mahrous")),
                () -> assertThat(helloWorld.sayHello("Mahrous"), containsString("Mahrous")));
    }

    @Test
    @DisplayName("isPositiveNumber | Null input")
    void isPositiveNumber_nullName() {
        boolean isPositiveNumber = helloWorld.isPositiveNumber(null);
        assertFalse(isPositiveNumber);
    }

    @Test
    @DisplayName("isPositiveNumber | Invalid input")
    void isPositiveNumber_invalidInput() {
        assertThrows(NumberFormatException.class, () -> helloWorld.isPositiveNumber("iufhiuewhfuhewui"));
    }


    @Test
    void dummy1() {
        System.out.println("OK 1");
    }

    @Test
    void dummy2() {
        System.out.println("OK 2");
    }
}
