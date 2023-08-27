package com.simantyu_engineer.mjisland;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class MjIslandApplication {

	public static void main(String[] args) {
		SpringApplication.run(MjIslandApplication.class, args);
	}

	// @RequestMapping(value = "/")
	// public String index(Model model) {
	// 	model.addAttribute("moji", "hello world! by index");
	// 	return "index";
	// }

	// @GetMapping("/test2")
	// public String write2(Model model) {
	// 	return "SCP004_toppage";
	// }
//test2 kazuma
}
