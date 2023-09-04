package com.simantyu_engineer.mjisland.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
     * グループ登録画面
     */
    @GetMapping("/GroupRegistration")
    public String groupRegistration(@ModelAttribute groupList groupList) {
        return "SCR013";
    }

    /*
     * グループ編集画面
     */
    @GetMapping("/GroupEdit/{groupId}")
    public String getById(
            @PathVariable("groupId") String groupId, Model model) {
        model.addAttribute("groupListForm", groupListService.findGroupList(groupId));
        return "SCR013edit";
    }

    /*
     * グループ編集画面
     */
    // @GetMapping("/GroupEdit/{groupId}")
    // public String groupEdit(@PathVariable long groupId, @ModelAttribute groupList
    // groupList) {
    // groupListService.findGroupList(groupId);
    // return "SCR013";
    // }

    /*
     * グループ登録画面
     */
    // @GetMapping("/GroupRegistration")
    // public String groupRegistration(@ModelAttribute GroupListForm groupListForm)
    // {
    // return "SCR013";
    // }

    /*
     * グループ一覧画面
     */
    @GetMapping("/GroupList")
    public String groupListFind(Model model) {
        model.addAttribute("groupList", groupListService.findAllGroupList());
        return "SCR014";
    }

    /*
     * グループ一覧画面 使用不可（原因不明）
     */
    // @GetMapping("/GroupList")
    // public String groupListFind(Model model) {
    // List<GroupListForm> groupList =
    // groupListService.changeFormList(groupListService.findAllGroupList()) ;
    // model.addAttribute("groupList", groupList);
    // return "SCR014";
    // }

    /*
     * グループ登録実行
     */
    @PostMapping("/GroupRegistration")
    public String groupRegistration(
            @Validated @ModelAttribute GroupListForm groupListForm, BindingResult bindingResult,
            @Autowired RedirectAttributes redirectAttributes) {

        // 重複チェック（groupId）
        if (groupListService.duplicateCheck(groupListForm.getGroupId())) {
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

    /*
     * グループ編集実行
     */
    @PostMapping("/GroupEdit")
    public String groupEdit(
            @Validated @ModelAttribute GroupListForm groupListForm, BindingResult bindingResult) {

        // 入力チェック
        if (bindingResult.hasErrors()) {
            return "SCR013edit";
        }

        // 登録
        groupListService.create(groupListForm);

        // 遷移先未設定！ 要確認！
        return "redirect:/form";
    }
}
// http://localhost:8765/GroupList
// http://localhost:8765/GroupRegistration