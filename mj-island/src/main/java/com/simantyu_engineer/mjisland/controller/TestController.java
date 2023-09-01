package com.simantyu_engineer.mjisland.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class TestController {

    @GetMapping("/Test")
    private String testRead() {
        return "test";
    }

    @PostMapping("/Test")
    private String confirm() {
        return "test";
    }
}

// http://localhost:8765/Test
