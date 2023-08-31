package com.simantyu_engineer.mjisland.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

// import com.google.appengine.repackaged.com.google.type.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name="game_setting")
public class gameSetting {

    @Id
    @Column(name="score_id")
    private String score_id;

    @Column(name="rating")
    private BigDecimal rating;

    @Column(name="chip_rating")
    private Integer chip_rating;

    @Column(name="group_id")
    private String group_id;

    @Column(name="score_title")
    private String score_title;

    @Column(name="event_date")
    private Date event_date;

    @Column(name="location")
    private String location;

    @Column(name="comment")
    private String comment;

    @Column(name="score_last_num")
    private Integer score_last_num;
    
    @Column(name="favorite_flg")
    private char favorite_flg;

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
