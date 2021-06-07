package com.javalearning.keyvalue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KeyValueController {

    private final KeyValueService keyValueService;

    @Autowired
    public KeyValueController(KeyValueService keyValueService) {
        this.keyValueService = keyValueService;
    }

    @GetMapping
    public String getDefault() {
        return "Hello";
    }

    @GetMapping("/get")
    public String getValue(@RequestParam String key) {
        return keyValueService.getValue(key);
    }

    @PostMapping("/post")
    public void addKeyValue(@RequestParam String key, String value) {
        keyValueService.addKeyValue(key, value);
    }
}
