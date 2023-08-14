package com.simantyu_engineer.mjisland;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class MjIslandApplication {

	public static void main(String[] args) {
		SpringApplication.run(MjIslandApplication.class, args);
	}

	@GetMapping("/test1")
	public String write1(Model model) {
		model.addAttribute("moji", "hello world!");
		return "hello";
	}

	@GetMapping("/test2")
	public String write2(Model model) {
		return "SCP004_toppage";
	}
//test2 kazuma
}
