package com.simantyu_engineer.mjisland;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GameSettingController {

    private final GameSettingRepository repository;

    //@Autowired ← コンストラクタが１つの場合、@Autowiredは省略できます
    public GameSettingController(GameSettingRepository repository) {
        this.repository = repository;
    }

    //トップページから遷移した時のみ初期値を設定
    @ModelAttribute
    public GameSettingForm setup() {
        GameSettingExecution gse = new GameSettingExecution();
        GameSettingForm form = gse.initialSetting();
        return form;
    }

    @GetMapping("/GameSetting")
    private String readForm() {
        return "SCR004";
    }

    @PostMapping("/GameSetting")
    private String confirm(@Validated @ModelAttribute GameSettingEntity entity, BindingResult result) {
        if (result.hasErrors()) {
            return "SCR004";
        }
        // COMMENTテーブル：コメント登録
        repository.save(entity);
        // ルートパス("/") にリダイレクトします
        return "redirect:/SCR001login";
    }
}
// http://localhost:8765/GameSetting
