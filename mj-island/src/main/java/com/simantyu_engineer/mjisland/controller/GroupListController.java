package com.simantyu_engineer.mjisland.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.simantyu_engineer.mjisland.domain.model.GroupListForm2;
import com.simantyu_engineer.mjisland.service.GroupListService;

/**
 * groupListService.create(groupListForm);下の遷移先未設定
 */
@Controller
public class GroupListController {

    private final GroupListService groupListService;

    public GroupListController(GroupListService groupListService) {
        this.groupListService = groupListService;
    }

    /**
     * グループ一覧画面(group_id順)
     * @param model
     * @return
     */
    @GetMapping("/GroupListSortByGroupId")
    public String groupListFindSortedByGroupId(Model model) {
        List<GroupListForm2> listForm= new ArrayList<GroupListForm2>();
        listForm = groupListService.changeFormList2(groupListService.getAllGroupListSortedByGroupId());
        model.addAttribute("listForm", listForm);
        model.addAttribute("sort", "groupId");
        return "SCR014";
    }
    
    /**
     * グループ一覧画面(group_name順)
     * @param model
     * @return
     */
    @GetMapping("/GroupListSortByGroupName")
    public String groupListFindSortedByGroupName(Model model) {
        List<GroupListForm2> listForm= new ArrayList<GroupListForm2>();
        listForm = groupListService.changeFormList2(groupListService.getAllGroupListSortedByGroupName());
        model.addAttribute("listForm", listForm);
        model.addAttribute("sort", "groupName");
        return "SCR014";
    }

    /**
     * グループ登録画面
     * @param groupListForm
     * @return
     */
    @GetMapping("/GroupRegistration")
    public String groupRegistration(@ModelAttribute GroupListForm groupListForm) {
        return "SCR013";
    }

    /**
     * グループ編集画面
     * @param groupId
     * @param model
     * @return
     */
    @GetMapping("/GroupEdit/{groupId}")
    public String getById(
            @PathVariable("groupId") String groupId, Model model) {
        model.addAttribute("groupListForm", groupListService.findGroupList(groupId));
        return "SCR013edit";
    }

    /**
     * グループ登録実行
     * @param groupListForm
     * @param bindingResult
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/GroupRegistration")
    public String groupRegistration(
            @Validated @ModelAttribute GroupListForm groupListForm, BindingResult bindingResult,
            @Autowired RedirectAttributes redirectAttributes) {

        //groupListForm初期設定　　注意！initialSetting未完成！！
        groupListForm = groupListForm.initialSetting(groupListForm);

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
        return "redirect:/GroupListSortByGroupId";
    }

    /**
     * グループ編集実行
     * @param groupListForm
     * @param bindingResult
     * @return
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
        return "redirect:/GroupListSortByGroupId";
    }
}
// http://localhost:8765/GroupListSortByGroupId  グループ一覧画面id順
// http://localhost:8765/GroupListSortByGroupName  グループ一覧画面name順
// http://localhost:8765/GroupRegistration  グループ登録実行