package com.simantyu_engineer.mjisland.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simantyu_engineer.mjisland.domain.model.PlayerForm;
import com.simantyu_engineer.mjisland.domain.model.groupList;
import com.simantyu_engineer.mjisland.domain.model.playerInGroup;
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
    public void createAll(List<playerInGroup> playerInGroupList) {
        playerInGroupRepository.saveAll(playerInGroupList);
    }

    
    /**
     * playerInGroupをデータベースに登録するためのセットアップ
     * @param playerForm
     * @param playerInGroups
     * @return
     */
    public List<playerInGroup> setUp(PlayerForm playerForm, List<String> playerInGroups) {
        
        //必要インスタンスをそれぞれ生成
        List<playerInGroup> playerInGroupList = new ArrayList<>();
        playerInGroup playerInGroup = new playerInGroup();
        groupList groupList = new groupList();

        //登録するためのセット(playerInGroup)
        this.setting(playerInGroup, playerForm);
        for(String groupName : playerInGroups) {
            //プレイヤーが所属するグループ名を検索
            groupList = groupListRepository.findByGroupName(groupName);
            //グループIDをplayerInGroupに代入
            playerInGroup.setGroupId(groupList.getGroupId());
            //登録するリストに代入
            playerInGroupList.add(newInstance(playerInGroup));
        }
        return playerInGroupList;
    }

    /**
     * playerInGroupを登録するためのセット　！未実装
     * @param playerInGroup
     */
    public void setting(playerInGroup playerInGroup,PlayerForm playerForm) {
        playerInGroup.setPlayerId(playerForm.getPlayerId());
        playerInGroup.setCreate_user("test");
        playerInGroup.setCreate_datetime(LocalDateTime.now());
        playerInGroup.setUpdate_user("test");
        playerInGroup.setUpdate_datetime(LocalDateTime.now());
    }

    /**
     * インスタンスを新しく生成して返す
     * @param playerInGroup
     * @return
     */
    public playerInGroup newInstance(playerInGroup playerInGroup){
        playerInGroup newPlayerInGroup = new playerInGroup();
        newPlayerInGroup.setGroupId(playerInGroup.getGroupId());
        newPlayerInGroup.setPlayerId(playerInGroup.getPlayerId());
        newPlayerInGroup.setCreate_user(playerInGroup.getCreate_user());
        newPlayerInGroup.setCreate_datetime(playerInGroup.getCreate_datetime());
        newPlayerInGroup.setUpdate_user(playerInGroup.getUpdate_user());
        newPlayerInGroup.setUpdate_datetime(playerInGroup.getUpdate_datetime());
        return newPlayerInGroup;
    }
}
