package com.simantyu_engineer.mjisland.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.simantyu_engineer.mjisland.domain.model.GroupListForm;
import com.simantyu_engineer.mjisland.service.GroupListService;

@Controller
public class GroupListController {

    private final GroupListService groupListService;

    public GroupListController(GroupListService groupListService) {
        this.groupListService = groupListService;
    }

    @GetMapping("/GroupList")
    public String readForm(Model model) {
        GroupListForm groupListForm = new GroupListForm();
        model.addAttribute("groupListForm", groupListForm.test());
        return "SCR013";
    }

    @PostMapping("/GroupList")
    public String confirm(@Validated @ModelAttribute GroupListForm groupListForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "SCR013";
        }

        groupListService.create(groupListForm);
        // 遷移先未設定！　要確認！
        return "redirect:/form";
    }
}
// http://localhost:8765/GroupList