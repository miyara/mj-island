package com.simantyu_engineer.mjisland.domain.model;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class GroupListForm {
    @NotBlank(message = "※入力してください")
    @Size(max = 10, message = "※10文字以内で入力してください")
    private String group_id;
    
    @NotBlank(message = "※入力してください")
    @Size(max = 20, message = "※20文字以内で入力してください")
    private String group_name;
    
    @NotBlank(message = "※入力してください")
    @Size(max = 100, message = "※100文字以内で入力してください")
    private String comment;

    private String create_member_id;

    private String create_user;
    
    private LocalDateTime create_datetime;
    
    private String update_user;

    private LocalDateTime update_datetime;

    //  テスト用　本番では使用厳禁
    public groupList test() {
        groupList form = new groupList();

        form.setGroup_id("5678");
        form.setGroup_name("1234");
        form.setComment("commnetcommnetcommnetcommnetcommnetcommnet");
        form.setCreate_member_id("p1p2p3p4");
        form.setCreate_user("大濵");
        form.setCreate_datetime(LocalDateTime.now());
        form.setUpdate_user("宮良");
        form.setUpdate_datetime(LocalDateTime.now());
        
        return form;
    }
    
}