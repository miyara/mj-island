package com.simantyu_engineer.mjisland.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TestController {

    @GetMapping("/Test")
    private String readForm() {
        return "test";
    }
}

// http://localhost:8765/Test
