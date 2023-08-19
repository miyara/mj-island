package com.simantyu_engineer.mjisland;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class GameSettingObject {
    private Integer scoreId;        //スコアID
    private Double  rating;         //レート
    private Integer chip;           //チップ
    private Integer groupId;        //グループID
    private String  scoreTitle;     //タイトル
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date    eventDate;      //開催日
    private String  location;       //場所
    private String  comment;        //メモ
    private String  scoreNumTotal;  //
    private String  createUser;     //
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date    createDateTime; //
    private String  updateUser;     //
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date    updateDateTime; //

    public Integer getScoreId() {
        return scoreId;
    }
    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }
    public Double getRating() {
        return rating;
    }
    public void setRating(Double rating) {
        this.rating = rating;
    }
    public Integer getChip() {
        return chip;
    }
    public void setChip(Integer chip) {
        this.chip = chip;
    }
    public Integer getGroupId() {
        return groupId;
    }
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
    public String getScoreTitle() {
        return scoreTitle;
    }
    public void setScoreTitle(String scoreTitle) {
        this.scoreTitle = scoreTitle;
    }
    public Date getEventDate() {
        return eventDate;
    }
    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public String getScoreNumTotal() {
        return scoreNumTotal;
    }
    public void setScoreNumTotal(String scoreNumTotal) {
        this.scoreNumTotal = scoreNumTotal;
    }
    public String getCreateUser() {
        return createUser;
    }
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    public Date getCreateDateTime() {
        return createDateTime;
    }
    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }
    public String getUpdateUser() {
        return updateUser;
    }
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
    public Date getUpdateDateTime() {
        return updateDateTime;
    }
    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
    }
}
