package com.simantyu_engineer.mjisland.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.simantyu_engineer.mjisland.domain.model.GameSettingEntity;
import com.simantyu_engineer.mjisland.domain.model.GameSettingForm;
import com.simantyu_engineer.mjisland.repository.GameSettingRepository;
import com.simantyu_engineer.mjisland.service.GameSettingService;

@Controller
public class GameSettingController {

    private final GameSettingRepository repository;

    //@Autowired ← コンストラクタが１つの場合、@Autowiredは省略できます
    public GameSettingController(GameSettingRepository repository) {
        this.repository = repository;
    }

    //トップページから遷移した時のみ初期値を設定
        GameSettingService service = new GameSettingService();
        GameSettingForm form = service.initialSetting();


    @GetMapping("/GameSetting")
    private String readForm(Model model) {
        model.addAttribute("form", form);
        return "SCR004";
    }

    @PostMapping("/GameSetting")
    private String confirm(@Validated @ModelAttribute GameSettingEntity entity, BindingResult result) {
        if (result.hasErrors()) {
            return "SCR001login";
        }
        // COMMENTテーブル：コメント登録
        repository.save(entity);
        // ルートパス("/") にリダイレクトします
        return "redirect:/SCR001login";
    }
}
// http://localhost:8765/GameSetting
