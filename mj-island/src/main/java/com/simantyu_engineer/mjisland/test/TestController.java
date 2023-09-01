package com.simantyu_engineer.mjisland.test;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestController {
   @GetMapping("/form")
    public String showForm(@ModelAttribute MyForm myForm) {
        return "form";
    }

    @PostMapping("/form")
    public String submitForm(@Validated @ModelAttribute MyForm myForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        // バリデーション成功時の処理
        // ここでデータを保存などの操作を行う
        return "redirect:/success"; // 成功ページにリダイレクト
    }
}
// http://localhost:8765/form