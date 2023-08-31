package com.simantyu_engineer.mjisland.domain.model;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class GameSettingForm {

    private String  score_id;

    private Double  rating;

    private Integer chip_rating;

    private String  group_id;

    private String  score_title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date    event_date;

    private String  location;

    private String  comment;

    private Integer score_last_num;
    
    private char    favorite_flg;

    private String  create_user;

    private LocalDateTime    create_datetime;

    private String  update_user;

    private LocalDateTime    update_datetime;



    // SCR004.htmlに表記する初期値を設定
    final Double  RATING_DEFAULT_VALUE    = 1.0;        //レートの初期値
    final Integer CHIP_DEFAULT_VALUE      = 2;          //チップの初期値
    final Date    EVENTDATE_DEFAULT_VALUE = new Date(); //開催日の初期値（システム日付）
    
    // SCR004.htmlに表記する初期値を入力
    public GameSettingForm initialSetting() {
        GameSettingForm form = new GameSettingForm();
        form.setRating(RATING_DEFAULT_VALUE);
        form.setChip_rating(CHIP_DEFAULT_VALUE);
        form.setEvent_date(EVENTDATE_DEFAULT_VALUE);
        return form;
    }

    //テスト用　本番では使用厳禁
    public GameSettingForm test() {
        GameSettingForm form = new GameSettingForm();
        form.setScore_id("1234");
        form.setRating(2.0);
        form.setChip_rating(10);
        form.setGroup_id("5678");
        form.setScore_title("石垣杯");
        form.setEvent_date(new Date());
        form.setLocation("世持家");
        form.setComment("commnetcommnetcommnetcommnetcommnetcommnet");
        form.setScore_last_num(100000);
        form.setFavorite_flg('t');
        form.setCreate_user("大濵");
        form.setCreate_datetime(LocalDateTime.now());
        form.setUpdate_user("宮良");
        form.setUpdate_datetime(LocalDateTime.now());
        return form;
    }
}
