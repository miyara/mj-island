package com.simantyu_engineer.mjisland.domain.model;

import java.util.Date;

//初期値を設定するためのクラス
public class GameSettingExecution {

    // SCR004.htmlに表記する初期値を設定
    final Double  RATING_DEFAULT_VALUE    = 1.0;        //レートの初期値
    final Integer CHIP_DEFAULT_VALUE      = 2;          //チップの初期値
    final Date    EVENTDATE_DEFAULT_VALUE = new Date(); //開催日の初期値（システム日付）
    
    // SCR004.htmlに表記する初期値を入力
    public GameSettingForm initialSetting() {
        GameSettingForm form = new GameSettingForm();
        form.setRating(RATING_DEFAULT_VALUE);
        form.setChip(CHIP_DEFAULT_VALUE);
        form.setEventDate(EVENTDATE_DEFAULT_VALUE);
        return form;
    }

}