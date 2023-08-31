package com.simantyu_engineer.mjisland.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simantyu_engineer.mjisland.domain.model.GameSettingForm;
import com.simantyu_engineer.mjisland.domain.model.gameSetting;
import com.simantyu_engineer.mjisland.repository.GameSettingRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class GameSettingService {

    @Autowired
    GameSettingRepository gameSettingRepository;

    /**
     * ゲーム設定登録
     * 
     * @param GameSettingForm ゲーム設定
     */
    public void create(GameSettingForm form) {
        gameSettingRepository.save(createGameSetting(form));
    }

    private gameSetting createGameSetting(GameSettingForm form) {
        gameSetting setting = new gameSetting();
        
        setting.setScore_id(form.getScore_id());
        setting.setRating(new BigDecimal(form.getRating()));
        setting.setChip_rating(form.getChip_rating());
        setting.setGroup_id(form.getGroup_id());
        setting.setScore_title(form.getScore_title());
        setting.setEvent_date(form.getEvent_date());
        setting.setLocation(form.getLocation());
        setting.setComment(form.getComment());
        setting.setScore_last_num(form.getScore_last_num());
        setting.setFavorite_flg(form.getFavorite_flg());
        setting.setCreate_user(form.getCreate_user());
        setting.setCreate_datetime(LocalDateTime.now());
        setting.setUpdate_user(form.getUpdate_user());
        setting.setUpdate_datetime(LocalDateTime.now());

        return setting;
    }
}
