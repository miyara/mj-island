package com.simantyu_engineer.mjisland.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "group_list")
public class groupList {

    @Id
    // @Pattern(regexp = "^[a-zA-Z0-9]{1,10}$", message = "文字数は10文字以内で半角英数字のみで入力してください")
    @Column(name = "group_id")
    private String groupId;

    // @NotBlank(message = "入力してください")
    // @Length(max = 20, message = "20文字以内で入力してください")
    @Column(name = "group_name")
    private String group_name;
    
    // @NotBlank(message = "入力してください")
    // @Length(max = 100, message = "100文字以内で入力してください")
    @Column(name = "comment")
    private String comment;

    @Column(name = "create_member_id")
    private String create_member_id;

    @Column(name = "create_user")
    private String create_user;
    
    @Column(name = "create_datetime")
    // @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime create_datetime;
    
    @Column(name = "update_user")
    private String update_user;

    @Column(name = "update_datetime")
    // @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime update_datetime;

}
