package com.muhtar.dummy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping
    public String test(@RequestParam String name) {
        if (name != null && name.length() > 0) {
            return "Hello " + name + ":)";
        } else {
            return "Hello world !";
        }
    }
}
