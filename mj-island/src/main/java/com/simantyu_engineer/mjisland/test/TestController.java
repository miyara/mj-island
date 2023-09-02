package com.simantyu_engineer.mjisland.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 *test
 */
@Controller
public class TestController {

    /*
     * test
     */
     @GetMapping("/test")
    public String test() {
        return "sample";
    }
}
// http://localhost:8765/test