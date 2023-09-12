package com.simantyu_engineer.mjisland.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.simantyu_engineer.mjisland.domain.form.GroupListForm;
import com.simantyu_engineer.mjisland.domain.form.GroupListForm2;
import com.simantyu_engineer.mjisland.domain.model.GroupList;
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

    /**
     * グループIDで重複チェック
     * @param groupId
     * @return
     */
    public boolean duplicateCheck(String groupId) {
        return groupListRepository.existsByGroupId(groupId);
    }

    /**
     * グループ一覧 全件取得
     * @return
     */
    public List<GroupList> findAllGroupList() {
        return groupListRepository.findAll();
    }

    /**
     * グループ一覧 全件取得(group_name順)
     * @return
     */
    public List<GroupList> getAllGroupListSortedByGroupName() {
        Sort sort = Sort.by(Sort.Order.asc("groupName")); // ソート条件を指定
        return groupListRepository.findAll(sort);
    }

    /**
     * グループ一覧 全件取得(group_id順)
     * @return
     */
    public List<GroupList> getAllGroupListSortedByGroupId() {
        Sort sort = Sort.by(Sort.Order.asc("groupId")); // ソート条件を指定
        return groupListRepository.findAll(sort);
    }

    /**
     * データベースから取得したList<groupList>をList<GroupListForm2>に変換
     * @param listGroupList
     * @return
     */
    public List<GroupListForm2> changeFormList2(List<GroupList> listGroupList) {
        List<GroupListForm2> listForm = new ArrayList<GroupListForm2>();
        for (GroupList entity : listGroupList) {
            GroupListForm2 form = changeForm2(entity);
            listForm.add(form);
        }
        return listForm;
    }

    // グループ一覧 1件取得
    public GroupListForm findGroupList(String groupId) {
        return changeForm(groupListRepository.findByGroupId(groupId));
    }

    // List<groupList>からList<GroupListForm>に変換
    public List<GroupListForm> changeFormList(List<GroupList> listGroupList) {
        List<GroupListForm> listGroupListForm = new ArrayList<GroupListForm>();
        for (GroupListForm groupListForm : listGroupListForm) {
            listGroupListForm.add(groupListForm);
        }
        return listGroupListForm;
    }

    // GroupListFormからgroupListに入れ替える
    public GroupList changeEntity(GroupListForm groupListForm) {
        GroupList groupList = new GroupList();
        groupList.setGroupId(groupListForm.getGroupId());
        groupList.setGroupName(groupListForm.getGroup_name());
        groupList.setComment(groupListForm.getComment());
        groupList.setCreate_member_id(groupListForm.getCreate_member_id());
        groupList.setCreate_user(groupListForm.getCreate_user());
        groupList.setCreate_datetime(groupListForm.getCreate_datetime());
        groupList.setUpdate_user(groupListForm.getUpdate_user());
        groupList.setUpdate_datetime(groupListForm.getUpdate_datetime());
        return groupList;
    }

    // groupListからGroupListFormに入れ替える
    public GroupListForm changeForm(GroupList groupList) {
        GroupListForm groupListForm = new GroupListForm();
        groupListForm.setGroupId(groupList.getGroupId());
        groupListForm.setGroup_name(groupList.getGroupName());
        groupListForm.setComment(groupList.getComment());
        groupListForm.setCreate_member_id(groupList.getCreate_member_id());
        groupListForm.setCreate_user(groupList.getCreate_user());
        groupListForm.setCreate_datetime(groupList.getCreate_datetime());
        groupListForm.setUpdate_user(groupList.getUpdate_user());
        groupListForm.setUpdate_datetime(groupList.getUpdate_datetime());
        return groupListForm;
    }

    /**
     * groupListからGroupListFormに入れ替える
     * 
     * @param groupList
     * @return
     */
    public GroupListForm2 changeForm2(GroupList groupList) {
        GroupListForm2 groupListForm = new GroupListForm2();
        groupListForm.setGroupId(groupList.getGroupId());
        groupListForm.setGroup_name(groupList.getGroupName());
        groupListForm.setComment(groupList.getComment());

        return groupListForm;
    }

}
