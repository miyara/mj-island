package com.simantyu_engineer.mjisland.domain.model;

import lombok.Data;

/**
 * playerInGroupの主キー用
 */
@Data
public class PlayerInGroupKey {
    /**
     * プレイヤーID
     */
    private String playerId;
    /**
     * グループID
     */
    private String groupId;
}
