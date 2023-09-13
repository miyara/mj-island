package com.simantyu_engineer.mjisland.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.simantyu_engineer.mjisland.domain.form.GameSettingForm;
import com.simantyu_engineer.mjisland.service.GameSettingService;


//遷移先未確定　注意
@Controller
public class GameSettingController {

    private final GameSettingService service;

    public GameSettingController(GameSettingService service) {
        this.service = service;
    }

    @GetMapping("/GameSetting")
    private String readForm(Model model) {
        GameSettingForm gameSettingForm = new GameSettingForm();
        model.addAttribute("gameSettingForm", gameSettingForm.initialSetting());
        return "SCR004gameSetting";
    }

    @PostMapping("/GameSetting")
    private String confirm(@Validated @ModelAttribute GameSettingForm gameSettingForm, BindingResult result) {
        if (result.hasErrors()) {
            return "SCR004gameSetting";
        }

        service.create(gameSettingForm);
        // ルートパス("/") にリダイレクトします
        return "SCR001login";
    }// http://localhost:8765/GameSetting
}