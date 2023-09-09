package com.simantyu_engineer.mjisland.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simantyu_engineer.mjisland.domain.model.playerInGroup;
import com.simantyu_engineer.mjisland.domain.model.playerInGroupKey;

@Repository
public interface PlayerInGroupRepository extends JpaRepository<playerInGroup, playerInGroupKey>{

    /**
     * 条件検索(playerId)
     * @param playerId
     * @return
     */
    public playerInGroup findByPlayerId(String playerId);

    /**
     * 条件検索(groupId)
     * @param groupId
     * @return
     */
    public playerInGroup findByGroupId(String groupId);
}
