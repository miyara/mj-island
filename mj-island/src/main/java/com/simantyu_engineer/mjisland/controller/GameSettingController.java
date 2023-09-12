package com.simantyu_engineer.mjisland.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.simantyu_engineer.mjisland.form.GameSettingForm;
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
        GameSettingForm form = new GameSettingForm();
        model.addAttribute("form", form.test());
        return "SCR004";
    }

    @PostMapping("/GameSetting")
    private String confirm(@Validated @ModelAttribute GameSettingForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "SCR001login";
        }

        service.create(form);
        // ルートパス("/") にリダイレクトします
        return "SCR001login";
    }
}

// http://localhost:8765/GameSetting
