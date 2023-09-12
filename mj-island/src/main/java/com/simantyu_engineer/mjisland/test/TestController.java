package com.simantyu_engineer.mjisland.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.simantyu_engineer.mjisland.service.GroupListService;

/**
 * test用　自由に使ってどぞ
 */
@Controller
public class TestController {

    @Autowired
    TestRepository testRepository;

    @Autowired
    GroupListService groupListService;


   

}
// http://localhost:8765/test