package com.simantyu_engineer.mjisland.domain.form;

import java.util.List;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PlayerForm {

    /**
     * プレイヤーID
     */
    @Pattern(regexp = "^[a-zA-Z0-9]{1,10}$", message = "※10文字以内の半角英数字のみで必ず入力してください")
    private String playerId;
    
    /**
     * プレイヤー名
     */
    @Pattern(regexp = "^.{1,10}$", message = "※10文字以内で必ず入力してください")
    private String player_name;
    
    /**
     * プレイヤーに関するコメント
     */
    @Pattern(regexp = "^.{1,50}$", message = "※50文字以内必ずで入力してください")
    private String comment;
    
    
    /**
     * プレイヤーが所属するグループ名のリスト
     */
    private List<String> playerInGroup;
    
}