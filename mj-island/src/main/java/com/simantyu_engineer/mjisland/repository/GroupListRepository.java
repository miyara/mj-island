package com.simantyu_engineer.mjisland.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simantyu_engineer.mjisland.domain.model.groupList;

@Repository
public interface GroupListRepository extends JpaRepository <groupList, Long> {

    /**
     * 重複チェック(groupId)
     * @param groupIdValue
     * @return
     */
    public boolean existsByGroupId(String groupIdValue);

    /**
     * 条件検索(groupId)
     * @param groupId
     * @return
     */
    public groupList findByGroupId(String groupId);

    /**
     * 条件検索(groupName)
     * @param groupName
     * @return
     */
    public groupList findByGroupName(String groupName);
}
