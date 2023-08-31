package com.simantyu_engineer.mjisland.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simantyu_engineer.mjisland.domain.model.groupList;
import com.simantyu_engineer.mjisland.repository.GroupListRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class GroupListService {

    @Autowired
    GroupListRepository groupListRepository;

    /**
     * ゲーム設定登録
     * 
     * @param groupList ゲーム設定
     */
    public void create(groupList form) {
        groupListRepository.save(form);
        
    }

}
