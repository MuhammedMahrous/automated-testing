package com.example.demo;

import com.example.demo.component.IHelloWorld;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
@MockitoSettings(strictness = Strictness.WARN)
@WithMockUser
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
     * TODO (2.10): @MockBean
     * TODO (2.10): @WithMockUser
     */

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IHelloWorld helloWorld;

    @BeforeEach
    void setUp() {
        Mockito.when(helloWorld.sayHello("Gamal")).thenReturn("Hello Gamal");
    }

    @Test
    void isOK() throws Exception {
        mockMvc.perform(get("/hello/sayHello")).andExpect(status().isOk());
    }

    @Test
    void isBadRequest() throws Exception {
        mockMvc.perform(
                get("/hello/sayHello")
                        .param("name", "Gamal NOT_ALLOWED")
        ).andExpect(status().isBadRequest());
    }


    @Test
    @DisplayName("Is OK With Content Check")
    void isOKWithContent() throws Exception {
        mockMvc.perform(
                get("/hello/sayHello").param("name", "Gamal"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    @DisplayName("Is OK With Content Check JSON")
    void isOKWithContentJSON() throws Exception {
        mockMvc
                .perform(get("/hello/sayHello").param("name", "Gamal"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json("{\"message\":\"Hello Gamal\"}"));

        // TODO: Check content().json("{}");
    }

    @Test
    @DisplayName("Is OK With Content Check JSONPath")
    void isOKWithContentJSONPath() throws Exception {
        mockMvc
                .perform(get("/hello/sayHello").param("name", "Gamal"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.message", Matchers.is("Hello Gamal")));

        // TODO: Check content().json("{}");
    }

    /**
     *  - Flyway --> Db Migration
     *  - Spring Test => Kafka ==>
     */

    /**
     *
     * $.name => Gamal
     * {
     *     "name":"Gamal"
     * }
     */
}
