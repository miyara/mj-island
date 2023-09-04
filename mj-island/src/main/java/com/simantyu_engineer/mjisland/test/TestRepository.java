package com.simantyu_engineer.mjisland.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simantyu_engineer.mjisland.domain.model.groupList;

@Repository
public interface TestRepository extends JpaRepository <groupList, Long> {

}
