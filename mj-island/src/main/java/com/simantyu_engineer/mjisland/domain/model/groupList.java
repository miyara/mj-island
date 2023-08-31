package com.simantyu_engineer.mjisland.domain.model;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "group_list")
public class groupList {

    @Id
    @Column(name = "group_id")
    private String group_id;

    @Column(name = "group_name")
    private String group_name;
    
    @Column(name = "comment")
    private String comment;

    //物理名と論理名が違います！
    @Column(name = "create_member_id")
    private String create_member_id;

    @Column(name = "create_user")
    private String create_user;

    @Column(name = "create_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime create_datetime;

    @Column(name = "update_user")
    private String update_user;

    @Column(name = "update_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime update_datetime;

     //テスト用　本番では使用厳禁
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
