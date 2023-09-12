package com.simantyu_engineer.mjisland.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simantyu_engineer.mjisland.domain.model.PlayerInGroup;
import com.simantyu_engineer.mjisland.domain.model.PlayerInGroupKey;

@Repository
public interface PlayerInGroupRepository extends JpaRepository<PlayerInGroup, PlayerInGroupKey>{

    /**
     * 条件検索(playerId)
     * @param playerId
     * @return
     */
    public PlayerInGroup findByPlayerId(String playerId);

    /**
     * 条件検索(groupId)
     * @param groupId
     * @return
     */
    public PlayerInGroup findByGroupId(String groupId);
}
