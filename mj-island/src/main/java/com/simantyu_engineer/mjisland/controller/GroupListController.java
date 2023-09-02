package com.simantyu_engineer.mjisland.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simantyu_engineer.mjisland.domain.model.GroupListForm;
import com.simantyu_engineer.mjisland.domain.model.groupList;
import com.simantyu_engineer.mjisland.service.GroupListService;

/*
 * groupListService.create(groupListForm);下の遷移先未設定
 * 画面設計書SCR013の編集モード未実装
 */
@Controller
public class GroupListController {

    private final GroupListService groupListService;

    public GroupListController(GroupListService groupListService) {
        this.groupListService = groupListService;
    }

    /*
     * グループ一覧画面
     */
    @GetMapping("/GroupList")
    public String groupListFind(Model model) {
        List<groupList> groupList =  groupListService.findAllGroupList();
        model.addAttribute("groupList", groupList);
        return "SCR014";
    }

    /*
     * グループ登録画面
     */
    @GetMapping("/GroupRegistration")
    public String groupRegistration(Model model) {
        GroupListForm groupListForm = new GroupListForm();
        model.addAttribute("groupListForm", groupListForm.test());
        return "SCR013";
    }

    /*
     * グループ登録実行
     */
    @PostMapping("/GroupRegistration")
    public String confirm(
            RedirectAttributes redirectAttributes,
            @Validated @ModelAttribute
            GroupListForm groupListForm,
            BindingResult bindingResult) {

        // 重複チェック（groupId）
        boolean isDuplicate = groupListService.duplicateCheck(groupListForm.getGroupId());
        if (isDuplicate) {
            redirectAttributes.addFlashAttribute("message", "※データは既に存在します、別のIDを入力してください。");
            return "redirect:/GroupRegistration";
        }

        // 入力チェック
        if (bindingResult.hasErrors()) {
            return "SCR013";
        }

        // 登録
        groupListService.create(groupListForm);
        // 遷移先未設定！ 要確認！
        return "redirect:/form";
    }
}
// http://localhost:8765/GroupList
// http://localhost:8765/GroupRegistration