package com.simantyu_engineer.mjisland.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simantyu_engineer.mjisland.domain.model.memberMst;

@Repository
public interface MemberMstRepository extends JpaRepository<memberMst, String>{
}
