package com.simantyu_engineer.mjisland.domain.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class GameSettingForm {

    private Integer scoreId;

    private Double  rating;

    private Integer chip;

    private Integer groupId;

    private String  scoreTitle;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date    eventDate;

    private String  location;

    private String  comment;

    private String  scoreNumTotal;

    private String  createUser;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date    createDatetime;

    private String  updateUser;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date    updateDatetime;
}
