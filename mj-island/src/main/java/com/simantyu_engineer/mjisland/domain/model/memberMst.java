package com.simantyu_engineer.mjisland.domain.model;

// import com.google.appengine.repackaged.org.joda.time.LocalDateTime;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
//import jakarta.persistence.MappedSuperclass;

//@MappedSuperclass
@Data
@Entity
@Table(name = "member_mst")
public class memberMst {
    @Id
    @Column(name = "member_id")
    private String member_id;

    @Column(name = "member_mail_address")
    private String member_mail_address;

    @Column(name = "member_password")
    private String member_password;

    @Column(name = "del_flg")
    private String del_flg;

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
}
