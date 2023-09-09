package com.simantyu_engineer.mjisland.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.simantyu_engineer.mjisland.domain.model.PlayerForm;
import com.simantyu_engineer.mjisland.domain.model.groupList;
import com.simantyu_engineer.mjisland.domain.model.playerInGroup;
import com.simantyu_engineer.mjisland.domain.model.playerList;
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
    
    /**
     * プレイヤー登録
     * @param playerList
     */
    public void create(playerList playerList) {
        playerListRepository.save(playerList);
    }
 
    /**
     * playerIdの重複チェック
     * @param playerId
     * @return
     */
    public boolean duplicateCheck(String playerId) {
        return playerListRepository.existsByPlayerId(playerId);
    }

    /**
     * プレイヤー一覧 全件取得
     * @return
     */
    public List<playerList> findAllPlayerList() {
        return playerListRepository.findAll();
    }

    /**
     * プレイヤー一覧 全件取得(player_name順)
     * @return
     */
    public List<playerList> getAllPlayerListSortedByPlayerName() {
        Sort sort = Sort.by(Sort.Order.asc("playerName")); // ソート条件を指定
        return playerListRepository.findAll(sort);
    }

    /**
     * プレイヤー一覧 全件取得(playerId順)
     * @return
     */
    public List<playerList> getAllPlayerListSortedByPlayerId() {
        Sort sort = Sort.by(Sort.Order.asc("playerId")); // ソート条件を指定
        return playerListRepository.findAll(sort);
    }

    /**
     * プレイヤーをキー検索（playerId）
     * @param playerId
     * @return playerList
     */
    public playerList findPlayerList(String playerId) {
        return playerListRepository.findByPlayerId(playerId);
    }

    /**
     * groupList.groupName(String)をPlayerForm.PlayerInGroup(List<String>)に代入
     * @param playerForm
     * @param groupList
     * @return
     */
    public void setGroupList(PlayerForm playerForm,List<groupList> groupList) {
        List<String> groupNameList = new ArrayList<>();
        for(groupList group : groupList) {
            groupNameList.add(group.getGroupName());
        }
        playerForm.setPlayerInGroup(groupNameList);
    }

    /**
     * データベースに登録する際のセットアップ　！テスト段階！
     * @param List
     * @return
     */
    public void setUp(playerList playerList) {
        playerList.setPlayer_id_name("test");
        playerList.setCreate_member_id("test");
        playerList.setCreate_user("test");
        playerList.setCreate_datetime(LocalDateTime.now());
        playerList.setUpdate_user("test");
        playerList.setUpdate_datetime(LocalDateTime.now());
    }

    
    /**
     * List<playerList>からList<PlayerForm>に変換
     * @param formList
     * @return
     */
    public List<PlayerForm> changeFormList(List<playerList> listPlayerList) {
        List<PlayerForm> formList = new ArrayList<PlayerForm>();
        for (playerList entity : listPlayerList) {
            PlayerForm form = changeForm(entity); 
            formList.add(form);
        }
        return formList;
    }

    /**
     * PlayerFormからplayerListに入れ替える
     * @param playerForm
     * @return
     */
    public playerList changeEntity(PlayerForm playerForm) {
        playerList playerList = new playerList();
        playerList.setPlayerId(playerForm.getPlayerId());
        playerList.setPlayer_name(playerForm.getPlayer_name());
        playerList.setComment(playerForm.getComment());
        return playerList;
    }

    /**
     * playerListからPlayerFormに入れ替える
     * @param playerList
     * @return
     */
    public PlayerForm changeForm(playerList playerList) {
        PlayerForm playerForm = new PlayerForm();
        playerForm.setPlayerId(playerList.getPlayerId());
        playerForm.setPlayer_name(playerList.getPlayer_name());
        playerForm.setComment(playerList.getComment());
        return playerForm;
    }
}
