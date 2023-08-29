package com.simantyu_engineer.mjisland.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simantyu_engineer.mjisland.domain.model.memberMst;
import com.simantyu_engineer.mjisland.service.ScoreListService;

@Controller
public class ScoreListController {
    @Autowired
    private ScoreListService service;

    @RequestMapping("/ScoreList")
    public String SCR005ScoreList(Model model) {
        
        //初期設定項目の設定
        List<memberMst> memberAll =  service.findAllMemberMst();
        model.addAttribute("memberList", memberAll);
        model.addAttribute("playerList", service.findAllPlayerList());
        model.addAttribute("scoreList", service.findAllScoreList());
        
        return "SCR005scoreList";

    }

}
