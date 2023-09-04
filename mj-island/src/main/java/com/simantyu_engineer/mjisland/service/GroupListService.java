package com.simantyu_engineer.mjisland.service;

import java.util.ArrayList;
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

    // グループ登録
    public void create(GroupListForm groupListForm) {
        groupListRepository.save(changeEntity(groupListForm));
    }

    // 重複チェック
    public boolean duplicateCheck(String groupIdValue) {
        return groupListRepository.existsByGroupId(groupIdValue);
    }

    // グループ一覧 全件取得
    public List<groupList> findAllGroupList() {
        return groupListRepository.findAll();
    }

    // グループ一覧 1件取得
    public GroupListForm findGroupList(String groupId) {
        return changeForm(groupListRepository.findByGroupId(groupId));
    }

    //List<groupList>からList<GroupListForm>に変換
    public List<GroupListForm> changeFormList(List<groupList> listGroupList){
        List<GroupListForm> listGroupListForm= new ArrayList<GroupListForm>();
        for(GroupListForm groupListForm : listGroupListForm){
            listGroupListForm.add(groupListForm);
        }
        return listGroupListForm;
    }

    //GroupListFormからgroupListに入れ替える
    public groupList changeEntity(GroupListForm groupListForm) {
        groupList groupList = new groupList();
        groupList.setGroupId(groupListForm.getGroupId());
        groupList.setGroup_name(groupListForm.getGroup_name());
        groupList.setComment(groupListForm.getComment());
        groupList.setCreate_member_id(groupListForm.getCreate_member_id());
        groupList.setCreate_user(groupListForm.getCreate_user());
        groupList.setCreate_datetime(groupListForm.getCreate_datetime());
        groupList.setUpdate_user(groupListForm.getUpdate_user());
        groupList.setUpdate_datetime(groupListForm.getUpdate_datetime());
        return groupList;
    }

    //groupListからGroupListFormに入れ替える
    public GroupListForm changeForm(groupList groupList) {
        GroupListForm groupListForm = new GroupListForm();
        groupListForm.setGroupId(groupList.getGroupId());
        groupListForm.setGroup_name(groupList.getGroup_name());
        groupListForm.setComment(groupList.getComment());
        groupListForm.setCreate_member_id(groupList.getCreate_member_id());
        groupListForm.setCreate_user(groupList.getCreate_user());
        groupListForm.setCreate_datetime(groupList.getCreate_datetime());
        groupListForm.setUpdate_user(groupList.getUpdate_user());
        groupListForm.setUpdate_datetime(groupList.getUpdate_datetime());
        return groupListForm;
    }
}
