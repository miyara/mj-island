package com.simantyu_engineer.mjisland.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simantyu_engineer.mjisland.domain.model.gameSetting;

@Repository
public interface GameSettingRepository extends JpaRepository <gameSetting, Long> {

}
