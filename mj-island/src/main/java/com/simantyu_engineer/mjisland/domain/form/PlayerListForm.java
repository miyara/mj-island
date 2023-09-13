package com.simantyu_engineer.mjisland.domain.form;

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

    /**
     * PlayerListFormの新しいインスタンスを生成して返す
     * @param playerListForm
     * @return
     */
    public PlayerListForm newInstance() {
        PlayerListForm newPlayerListForm = new PlayerListForm();
        newPlayerListForm.setPlayerId(this.playerId);
        newPlayerListForm.setPlayerIdName(this.playerIdName);
        newPlayerListForm.setPlayerInGroup(this.playerInGroup);
        newPlayerListForm.setComment(this.comment);
        return newPlayerListForm;
    }
}