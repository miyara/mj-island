package com.simantyu_engineer.mjisland.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simantyu_engineer.mjisland.domain.form.ScoreListForm;
import com.simantyu_engineer.mjisland.service.ScoreListService;

@Controller
public class ScoreListController {
    @Autowired
    private ScoreListService service;

    @RequestMapping("/ScoreList")
    public String SCR005ScoreList(Model model, 
                                @ModelAttribute ScoreListForm scoreListForm) {

        // 初期設定項目の設定
        model.addAttribute("groupList", service.findAllGroupList());

        // 検索結果を設定
        model.addAttribute("scoreList", service.findScoreList(scoreListForm.getEventDateFrom(), 
                                                                            scoreListForm.getEventDateTo(),
                                                                            scoreListForm.getGroupId()));

        return "SCR005scoreList";
    }

    // 未入力の項目をすべてNullに変換してくれる便利関数
    @InitBinder
    public void initbinder(WebDataBinder binder){
           binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}
