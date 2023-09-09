package com.simantyu_engineer.mjisland.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

        // 初期設定項目の設定
        model.addAttribute("groupList", service.findAllGroupList());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = new Date();
        Date toDate = new Date();

        try {
            fromDate = sdf.parse("2023-08-30");
            toDate = sdf.parse("2023-08-31");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        model.addAttribute("scoreList", service.findScoreList(fromDate, toDate, "GRP0000001"));

        return "SCR005scoreList";
    }
}
