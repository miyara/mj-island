package com.simantyu_engineer.mjisland.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simantyu_engineer.mjisland.domain.model.GameSettingEntity;

public interface GameSettingRepository extends JpaRepository <GameSettingEntity, Long> {

}
