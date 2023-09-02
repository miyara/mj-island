package com.simantyu_engineer.mjisland.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simantyu_engineer.mjisland.domain.model.groupList;

@Repository
public interface GroupListRepository extends JpaRepository <groupList, Long> {
    boolean existsByGroupId(String group_idValue);
}
