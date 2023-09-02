package com.simantyu_engineer.mjisland.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simantyu_engineer.mjisland.domain.model.GroupListForm;
import com.simantyu_engineer.mjisland.domain.model.groupList;
import com.simantyu_engineer.mjisland.repository.GroupListRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class GroupListService {

    @Autowired
    GroupListRepository groupListRepository;

    //グループ登録
    public void create(GroupListForm groupListForm) {
        groupList groupList = new groupList();

        groupList.setGroupId(groupListForm.getGroupId());
        groupList.setGroup_name(groupListForm.getGroup_name());
        groupList.setComment(groupListForm.getComment());
        groupList.setCreate_member_id(groupListForm.getCreate_member_id());
        groupList.setCreate_user(groupListForm.getCreate_user());
        groupList.setCreate_datetime(groupListForm.getCreate_datetime());
        groupList.setUpdate_user(groupListForm.getUpdate_user());
        groupList.setUpdate_datetime(groupListForm.getUpdate_datetime());
        
        groupListRepository.save(groupList);
    }

    //重複チェック
    public boolean duplicateCheck(String groupIdValue) {
        return groupListRepository.existsByGroupId(groupIdValue);
    }

    //グループ一覧　全件取得
    public List<groupList> findAllGroupList(){
        return groupListRepository.findAll();
    }
}
