package com.simantyu_engineer.mjisland;

import java.util.Date;

public class GameSettingExecution {

    // SCR004.htmlに表記する初期値を設定
    final Double  RATING_DEFAULT_VALUE    = 1.0;        //レートの初期値
    final Integer CHIP_DEFAULT_VALUE      = 2;          //チップの初期値
    final Date    EVENTDATE_DEFAULT_VALUE = new Date(); //開催日の初期値（システム日付）
    
    // SCR004.htmlに表記する初期値を入力
    public GameSettingObject initialSetting() {
        GameSettingObject obj = new GameSettingObject();
        obj.setRating(RATING_DEFAULT_VALUE);
        obj.setChip(CHIP_DEFAULT_VALUE);
        obj.setEventDate(EVENTDATE_DEFAULT_VALUE);
        return obj;
    }

    // //システム日付を取得後、String型に変換
    // private String today() {
    //     LocalDateTime today = LocalDateTime.now();
    //     DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    //     return today.format(dateTimeFormatter);
    // }


    // //前日を取得するメソッド
    // private LocalDateTime previousDay() {
    //     LocalDateTime day = LocalDateTime.now();
    //     return day.minusDays(1);
    // }
}