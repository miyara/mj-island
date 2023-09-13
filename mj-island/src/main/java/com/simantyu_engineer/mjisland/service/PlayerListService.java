package com.simantyu_engineer.mjisland.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.simantyu_engineer.mjisland.domain.form.PlayerForm;
import com.simantyu_engineer.mjisland.domain.form.PlayerListForm;
import com.simantyu_engineer.mjisland.domain.model.GroupList;
import com.simantyu_engineer.mjisland.domain.model.PlayerInGroup;
import com.simantyu_engineer.mjisland.domain.model.PlayerList;
import com.simantyu_engineer.mjisland.repository.GroupListRepository;
import com.simantyu_engineer.mjisland.repository.PlayerInGroupRepository;
import com.simantyu_engineer.mjisland.repository.PlayerListRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PlayerListService {

    @Autowired
    PlayerListRepository playerListRepository;

    @Autowired
    PlayerInGroupRepository playerInGroupRepository;

    @Autowired
    GroupListRepository groupListRepository;

    @Autowired
    PlayerInGroupService playerInGroupService;

    @Autowired
    GroupListService groupListService;

    /**
     * プレイヤー登録
     * 
     * @param playerList
     */
    public void create(PlayerList playerList) {
        playerListRepository.save(playerList);
    }

    /**
     * playerIdの重複チェック
     * 
     * @param playerId
     * @return
     */
    public boolean duplicateCheck(String playerId) {
        return playerListRepository.existsByPlayerId(playerId);
    }

    /**
     * プレイヤー一覧 全件取得
     * 
     * @return
     */
    public List<PlayerList> findAllPlayerList() {
        return playerListRepository.findAll();
    }

    /**
     * プレイヤー一覧 全件取得(player_name順)
     * 
     * @return
     */
    public List<PlayerList> getAllPlayerListSortedByPlayerName() {
        Sort sort = Sort.by(Sort.Order.asc("playerName")); // ソート条件を指定
        return playerListRepository.findAll(sort);
    }

    /**
     * プレイヤー一覧 全件取得(playerId順)
     * 
     * @return
     */
    public List<PlayerList> getAllPlayerListSortedByPlayerId() {
        Sort sort = Sort.by(Sort.Order.asc("playerId")); // ソート条件を指定
        return playerListRepository.findAll(sort);
    }

    /**
     * プレイヤーをキー検索（playerId）
     * 
     * @param playerId
     * @return
     */
    public PlayerList findPlayerList(String playerId) {
        return playerListRepository.findByPlayerId(playerId);
    }

    /**
     * groupList.groupName(String)をPlayerForm.PlayerInGroup(List<String>)に代入
     * 
     * @param playerForm
     * @param groupList
     * @return
     */
    public void setGroupList(PlayerForm playerForm, List<GroupList> groupList) {
        List<String> groupNameList = new ArrayList<>();
        for (GroupList group : groupList) {
            groupNameList.add(group.getGroupName());
        }
        playerForm.setPlayerInGroup(groupNameList);
    }

    /**
     * データベースに登録する際のセットアップ ！テスト段階！
     * 
     * @param List
     * @return
     */
    public void setUp(PlayerList playerList) {
        playerList.setPlayer_id_name("test");
        playerList.setCreate_member_id("test");
        playerList.setCreate_user("test");
        playerList.setCreate_datetime(LocalDateTime.now());
        playerList.setUpdate_user("test");
        playerList.setUpdate_datetime(LocalDateTime.now());
    }

    /**
     * List<playerList>からList<PlayerForm>に変換
     * 
     * @param formList
     * @return
     */
    public List<PlayerForm> changeFormList(List<PlayerList> listPlayerList) {
        List<PlayerForm> formList = new ArrayList<PlayerForm>();
        for (PlayerList entity : listPlayerList) {
            PlayerForm form = changeForm(entity);
            formList.add(form);
        }
        return formList;
    }

    /**
     * PlayerFormからplayerListに入れ替える
     * 
     * @param playerForm
     * @return
     */
    public PlayerList changeEntity(PlayerForm playerForm) {
        PlayerList playerList = new PlayerList();
        playerList.setPlayerId(playerForm.getPlayerId());
        playerList.setPlayer_name(playerForm.getPlayer_name());
        playerList.setComment(playerForm.getComment());
        return playerList;
    }

    /**
     * playerListからPlayerFormに入れ替える
     * 
     * @param playerList
     * @return
     */
    public PlayerForm changeForm(PlayerList playerList) {
        PlayerForm playerForm = new PlayerForm();
        playerForm.setPlayerId(playerList.getPlayerId());
        playerForm.setPlayer_name(playerList.getPlayer_name());
        playerForm.setComment(playerList.getComment());
        return playerForm;
    }

    /**
     * SCR008playerListに表示するフォームのセット
     * 
     * @param list
     */
    public void setFormList(List<PlayerListForm> list, String sort) {
        // リストに追加するためのインスタンスを生成
        PlayerListForm playerListForm = new PlayerListForm();

        // 登録されているプレイヤーを全件取得
        List<PlayerList> PlayerLists = this.findAllPlayerList();

        // ソートがプレイヤーネームならプレイヤーネーム順にプレイヤーリストを並び変える（元はプレイヤーID順）
        if (sort.equals("playerName")) {
            Collections.sort(PlayerLists);
        }
        
        for (PlayerList playerList : PlayerLists) {

            // プレイヤーの所属するグループIDをリストで取得
            List<PlayerInGroup> PlayerInGroups = playerInGroupService.findPlayerList(playerList.getPlayerId());

            // プレイヤーが所属するグループ名を、文字列で取得するためのインスタンスを生成
            StringBuilder sb = new StringBuilder();
            for (PlayerInGroup playerInGroup : PlayerInGroups) {

                // プレイヤーが所属するグループを取得
                GroupList groupList = groupListService.findGroupList(playerInGroup.getGroupId());

                // グループ名を取得
                sb.append(groupList.getGroupName());
                if (PlayerInGroups.size() == PlayerInGroups.indexOf(playerInGroup) + 1) {

                    // プレイヤーリストから各要素を取得しフォームにセット
                    playerListForm.setPlayerId(playerList.getPlayerId());
                    playerListForm.setPlayerIdName(playerList.getPlayer_name() + "(" + playerList.getPlayerId() + ")");
                    playerListForm.setPlayerInGroup(sb.toString());
                    playerListForm.setComment(playerList.getComment());
                    // リストに追加
                    list.add(playerListForm.newInstance());
                    break;
                }
                // グループ名の後に 、 を追加（最後には付かないようにする）
                sb.append(",");
            }

        }
    }
}
