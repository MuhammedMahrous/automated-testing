package com.example.demo.controller;

import com.example.demo.component.IHelloWorld;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/hello")
public class HelloWorldController {
    private IHelloWorld helloWorld;

    @GetMapping("/sayHello")
    public ResponseEntity<String> sayHello(@RequestParam(value = "name", required = false) String name) {
        if (!StringUtils.isEmpty(name) && name.contains("NOT_ALLOWED"))
            return ResponseEntity.badRequest().body("Please send a valid name");
        else {
            String message = helloWorld.sayHello(name);
            return ResponseEntity.ok(message);
        }
    }
}
