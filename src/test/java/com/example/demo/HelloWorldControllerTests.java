package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

public class HelloWorldControllerTests {

    /**
     * TODO (2.1): @WebMvcTest and and ExtendWith and its auto configuration
     * TODO (2.2): @ComponentScan
     * TODO (2.3): MockMvc
     * TODO (2.4): simple get(), status().isOk()
     * TODO (2.5):  get(), status().isBadRequest() and param()
     * TODO (2.6):  get(), status().isOk() and content().contentType() content().json()
     * TODO (2.7):  get(), status().isOk() and jsonPath(,Matchers.is())
     * TODO (2.8): andReturn().getResponse() => handler
     * TODO (2.9): andDo()
     */
    private MockMvc mockMvc;

    @Test
    void test() throws Exception {

    }
}
