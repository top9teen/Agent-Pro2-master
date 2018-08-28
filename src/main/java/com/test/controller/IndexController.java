package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class IndexController {

	@RequestMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("msg", "");
		return "index";
	}
	@RequestMapping(value = "/logout")
	public String logout(Model model) {
		model.addAttribute("msg", "L");
		
		return "index";
	}
	
	@RequestMapping(value = "/44")
	public String admin() {
		
		return "admin/welcome";
	}
}
