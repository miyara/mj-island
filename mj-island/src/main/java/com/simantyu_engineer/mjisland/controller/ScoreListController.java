package com.simantyu_engineer.mjisland.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.servlet.ModelAndView;
// import org.springframework.ui.Model;

import com.simantyu_engineer.mjisland.domain.model.memberMst;
import com.simantyu_engineer.mjisland.service.ScoreListService;

@Controller
public class ScoreListController {
    @Autowired
    private ScoreListService service;

    @RequestMapping("/ScoreList")
    public String SCR005ScoreList(Model model) {
        //お試し行を追加
        String str = "morning!!";
        model.addAttribute("hello", "HelloWorld");
        model.addAttribute("morning", str);

        //会員マスタの取得
        List<memberMst> memberAll =  service.findAllMemberMst();
        model.addAttribute("memberList", memberAll);
        
        return "SCR005scoreList";

    }

}
