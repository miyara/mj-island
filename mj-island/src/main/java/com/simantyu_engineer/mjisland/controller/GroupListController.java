package com.simantyu_engineer.mjisland.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.simantyu_engineer.mjisland.domain.model.groupList;
import com.simantyu_engineer.mjisland.service.GroupListService;


//遷移先未確定　注意
@Controller
public class GroupListController {

    private final GroupListService service;

    public GroupListController(GroupListService service) {
        this.service = service;
    }

    @GetMapping("/GroupList")
    private String readForm(Model model) {
        groupList form = new groupList();
        model.addAttribute("form", form.test());
        return "SCR013";
    }

    @PostMapping("/GroupList")
    private String confirm(@Validated @ModelAttribute groupList form, BindingResult result) {
        if (result.hasErrors()) {
            return "SCR013";
        }

        service.create(form);
        // ルートパス("/") にリダイレクトします
        return "SCR001login";
    }
}

// http://localhost:8765/GroupList