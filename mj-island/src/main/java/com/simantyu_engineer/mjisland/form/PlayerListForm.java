package com.simantyu_engineer.mjisland.form;

import lombok.Data;

@Data
public class PlayerListForm {

    /**
     * プレイヤーID
     */
    private String playerId;

    /**
     * プレイヤー名＆ID
     */
    private String playerIdName;
    
    /**
     * プレイヤーが所属するグループ名
     * カンマ区切りで表示
     */
    private String playerInGroup;
    
    /**
     * プレイヤーに関するコメント
     */
    private String comment;
}