package com.simantyu_engineer.mjisland.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simantyu_engineer.mjisland.domain.form.PlayerForm;
import com.simantyu_engineer.mjisland.domain.model.GroupList;
import com.simantyu_engineer.mjisland.domain.model.PlayerInGroup;
import com.simantyu_engineer.mjisland.domain.model.PlayerList;
import com.simantyu_engineer.mjisland.repository.GroupListRepository;
import com.simantyu_engineer.mjisland.repository.PlayerInGroupRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PlayerInGroupService {

    @Autowired
    PlayerInGroupRepository playerInGroupRepository;
    
    @Autowired
    GroupListRepository groupListRepository;

    /**
     * データベースに登録
     * @param playerInGroupList
     */
    public void createAll(List<PlayerInGroup> playerInGroupList) {
        playerInGroupRepository.saveAll(playerInGroupList);
    }

    
    /**
     * playerInGroupをデータベースに登録するためのセットアップ
     * @param playerForm
     * @param playerInGroups
     * @return
     */
    public List<PlayerInGroup> setUp(PlayerForm playerForm, List<String> playerInGroups) {
        
        //必要インスタンスをそれぞれ生成
        List<PlayerInGroup> playerInGroupList = new ArrayList<>();
        PlayerInGroup playerInGroup = new PlayerInGroup();
        GroupList groupList = new GroupList();

        //登録するためのセット(playerInGroup)
        this.setting(playerInGroup, playerForm);
        if(playerInGroups != null) {

            for(String groupName : playerInGroups) {
                //プレイヤーが所属するグループ名を検索
            groupList = groupListRepository.findByGroupName(groupName);
            //グループIDをplayerInGroupに代入
            playerInGroup.setGroupId(groupList.getGroupId());
            //登録するリストに代入
            playerInGroupList.add(newInstance(playerInGroup));
        }
    }
        return playerInGroupList;
    }

    /**
     * playerInGroupを登録するためのセット　！未実装
     * @param playerInGroup
     */
    public void setting(PlayerInGroup playerInGroup,PlayerForm playerForm) {
        playerInGroup.setPlayerId(playerForm.getPlayerId());
        playerInGroup.setCreate_user("test");
        playerInGroup.setCreate_datetime(LocalDateTime.now());
        playerInGroup.setUpdate_user("test");
        playerInGroup.setUpdate_datetime(LocalDateTime.now());
    }

    /**
     * 引数のインスタンスを新しく生成して返す
     * @param playerInGroup
     * @return
     */
    public PlayerInGroup newInstance(PlayerInGroup playerInGroup){
        PlayerInGroup newPlayerInGroup = new PlayerInGroup();
        newPlayerInGroup.setGroupId(playerInGroup.getGroupId());
        newPlayerInGroup.setPlayerId(playerInGroup.getPlayerId());
        newPlayerInGroup.setCreate_user(playerInGroup.getCreate_user());
        newPlayerInGroup.setCreate_datetime(playerInGroup.getCreate_datetime());
        newPlayerInGroup.setUpdate_user(playerInGroup.getUpdate_user());
        newPlayerInGroup.setUpdate_datetime(playerInGroup.getUpdate_datetime());
        return newPlayerInGroup;
    }

    /**
     * PlayerInGroupのリストを取得（playerId順）
     * @param playerId
     * @return
     */
    public List<PlayerInGroup> findPlayerList(String playerId) {
        return playerInGroupRepository.findByPlayerId(playerId);
    }
}
