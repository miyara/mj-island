package com.simantyu_engineer.mjisland.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simantyu_engineer.mjisland.domain.model.gameSetting;

public interface ScoreListRepository extends JpaRepository <gameSetting, Long> {

}
