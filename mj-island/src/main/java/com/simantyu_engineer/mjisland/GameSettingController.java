package com.simantyu_engineer.mjisland;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GameSettingController {

    // トップページから遷移した時のみ初期値を設定（Get送信のみ）
    @ModelAttribute
    public GameSettingObject setUp() {
        GameSettingExecution gse = new GameSettingExecution();
        GameSettingObject gso = gse.initialSetting();
        return gso;
    }
    
    @GetMapping("/GameSetting")
    private String readForm() {
        return "/common/SCR004";
    }

    @PostMapping("/GameSetting")
    private String confirm(@ModelAttribute GameSettingObject gameSettingObject) {
        
        return "/common/SCR004";
    }
}
// http://localhost:8765/GameSetting
