package com.simantyu_engineer.mjisland.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simantyu_engineer.mjisland.domain.model.memberMst;
import com.simantyu_engineer.mjisland.service.ScoreListService;

@Controller
public class ScoreListController {
    @Autowired
    private ScoreListController controller;

    @RequestMapping("/ScoreList")
    public String SCR005ScoreList(Model model) {
        //お試し行を追加
        model.addAttribute("hello", "Hello World!!");

        //会員マスタの取得
        List<memberMst> memberAll =  ScoreListService.findAllMemberMst();
        model.addAttribute("memberList", memberAll);

        return "SCR005ScoreList";
    }

}
