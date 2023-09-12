package com.simantyu_engineer.mjisland.domain.form;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class GroupListForm {
    @Pattern(regexp = "^[a-zA-Z0-9]{1,10}$", message = "10文字以内の半角英数字のみで必ず入力してください")
    private String groupId;
    
    @Pattern(regexp = "^.{1,20}$", message = "20文字以内で必ず入力してください")
    private String group_name;
    
    @Pattern(regexp = "^.{0,100}$", message = "100文字以内で入力してください")
    private String comment;

    private String create_member_id;

    private String create_user;
    
    private LocalDateTime create_datetime;
    
    private String update_user;

    private LocalDateTime update_datetime;

    /**
     * 登録する際の初期設定　！未完成！以下のセッターは前画面から取得する
     * @return form
     */
    public GroupListForm initialSetting(GroupListForm form) {
        form.setCreate_member_id("p1p2p3p4");
        form.setCreate_user("大濵");
        form.setCreate_datetime(LocalDateTime.now());
        form.setUpdate_user("宮良");
        form.setUpdate_datetime(LocalDateTime.now());
        
        return form;
    }
}