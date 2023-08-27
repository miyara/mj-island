package com.simantyu_engineer.mjisland;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "game_setting")
public class GameSettingEntity {

    @Id
    @NotNull
    private Integer scoreId;

    @NotNull
    @Range(min = 0, max = 5 )
    private Double  rating;

    @NotNull
    @Range(min = 0, max = 30 )
    private Integer chip;

    private Integer groupId;

    @Length(max = 30)
    private String  scoreTitle;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date    eventDate;

    @Length(max = 30)
    private String  location;

    @Length(max = 100)
    private String  comment;

    @NotNull
    private String  scoreNumTotal;

    @NotNull
    @Length(max = 10)
    private String  createUser;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date    createDatetime;

    @NotNull
    @Length(max = 10)
    private String  updateUser;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date    updateDatetime;
}
