package com.simantyu_engineer.mjisland.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simantyu_engineer.mjisland.domain.model.playerList;

@Repository
public interface PlayerListRepository extends JpaRepository<playerList, Long>{

    /**
     * 重複チェック(playerId)
     * @param playerIdValue
     * @return
     */
    public boolean existsByPlayerId(String playerIdValue);

    /**
     * 条件検索(PlayerId)
     * @param PlayerIdValue
     * @return
     */
    public playerList findByPlayerId(String PlayerIdValue);
}
