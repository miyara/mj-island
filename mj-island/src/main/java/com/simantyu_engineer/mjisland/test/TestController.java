package com.simantyu_engineer.mjisland.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.simantyu_engineer.mjisland.domain.model.GroupListForm;
import com.simantyu_engineer.mjisland.domain.model.groupList;
import com.simantyu_engineer.mjisland.service.GroupListService;

/*
 *test
 */
@Controller
public class TestController {

    @Autowired
    TestRepository testRepository;

    @Autowired
    GroupListService groupListService;


    /*
     * test
     */
     @GetMapping("/test")
    public String test() {
        List<GroupListForm> list = new ArrayList<>();
        List<groupList> testList =  testRepository.findAll();
        list = groupListService.changeFormList(testList);
        for(GroupListForm form : list){
            System.out.println(form.getComment());
        }
        System.out.println(list.toString());
        return "sample";
    }


}
// http://localhost:8765/test