package com.simantyu_engineer.mjisland.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simantyu_engineer.mjisland.domain.form.PlayerForm;
import com.simantyu_engineer.mjisland.domain.form.PlayerListForm;
import com.simantyu_engineer.mjisland.domain.model.GroupList;
import com.simantyu_engineer.mjisland.domain.model.PlayerInGroup;
import com.simantyu_engineer.mjisland.domain.model.PlayerList;
import com.simantyu_engineer.mjisland.service.GroupListService;
import com.simantyu_engineer.mjisland.service.PlayerInGroupService;
import com.simantyu_engineer.mjisland.service.PlayerListService;

/**
 * playerListService.create(playerForm);下の遷移先未設定
 */
@Controller
public class PlayerListController {

    private final PlayerListService playerListService;
    private final GroupListService groupListService;
    private final PlayerInGroupService playerInGroupService;

    public PlayerListController(
        PlayerListService playerListService, GroupListService groupListService, PlayerInGroupService playerInGroupService) {
        this.playerListService = playerListService;
        this.groupListService = groupListService;
        this.playerInGroupService = playerInGroupService;
    }

    /**
     * プレイヤー登録画面
     * @param playerForm
     * @return
     */
    @GetMapping("/PlayerRegistration")
    public String playerRegistration(Model model) {

        // プレイヤーフォームを作成
        PlayerForm playerForm = new PlayerForm();

        // グループリストをグループ名の順で取得
        List<GroupList> groupList = groupListService.getAllGroupListSortedByGroupName();

        // グループの名前を、プレイヤーフォームにリストとして取得
        playerListService.setGroupList(playerForm, groupList);

        // モデルに追加
        model.addAttribute("playerForm", playerForm);

        return "SCR007playerRegistry";
    }// http://localhost:8765/PlayerRegistration

    /**
     * プレイヤー登録実行
     * @param playerForm
     * @param bindingResult
     * @param redirectAttributes
     * @param playerInGroups
     * @return
     */
    @PostMapping("/PlayerRegistration")
    public String playerRegistration(
            @Validated @ModelAttribute PlayerForm playerForm, BindingResult bindingResult,
            @Autowired RedirectAttributes redirectAttributes,
            @RequestParam(name = "playerInGroup", required = false) List<String> playerInGroups) {

        // グループリストをグループ名の順で取得
        List<GroupList> groupList = groupListService.getAllGroupListSortedByGroupName();

        // グループの名前を、プレイヤーフォームにリストとして取得
        playerListService.setGroupList(playerForm, groupList);

        // 重複チェック（groupId）
        if (playerListService.duplicateCheck(playerForm.getPlayerId())) {
            redirectAttributes.addFlashAttribute("message", "※データは既に存在します、別のIDを入力してください。");
            return "redirect:/PlayerRegistration";
        }

        // 入力チェック
        if (bindingResult.hasErrors()) {
            return "SCR007playerRegistry";
        }

        // 登録するためのentityをformから取得
        PlayerList playerList = playerListService.changeEntity(playerForm);

        // 登録するためのplayerListをセットアップ
        playerListService.setUp(playerList);

        // 登録するためのplayerInGroupをセットアップ
        List<PlayerInGroup> playerInGroupList = playerInGroupService.setUp(playerForm, playerInGroups);

        // 登録
        playerListService.create(playerList);
        playerInGroupService.createAll(playerInGroupList);
        

        // 注意！ 遷移先未設定
        // return "SCR007playerRegistry";
        return "SCR008playerList";
    }// http://localhost:8765/PlayerRegistration

    @GetMapping("/PlayerList")
    public String playerList(Model model) {

        // フォームをセット
        List<PlayerListForm> playerListForm = playerListService.setFormList();

        // モデルに追加
        model.addAttribute("playerListForm", playerListForm);

        return "SCR008playerList";
    }// http://localhost:8765/PlayerList
}