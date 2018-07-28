package com.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.Bean.SaveTable1Bean;

@Controller
public class MemberController {
	public String groupTypeBean, carMakeBean, carMake2Bean, lessmoneyBean, lessyearBean;

	@RequestMapping(value = "/welcome")
	public String welcome(Model model) {
		model.addAttribute("save", "1");
		return "member/welcome";
	}

	@RequestMapping(value = "/gotobank")
	public String gotocredit(String groupType, String carMake, String carMake2, String lessmoney, String lessyear,
			HttpServletRequest request ,Model model) {
		SaveTable1Bean bean = new SaveTable1Bean();
		bean.setCarMake(carMake);
		bean.setCarMake2(carMake2);
		bean.setGroupType(groupType);
		bean.setLessmoney(lessmoney);
		bean.setLessyear(lessyear);
		groupTypeBean = groupType;
		carMakeBean = carMake;
		carMake2Bean = carMake2;
		lessmoneyBean = lessmoney;
		lessyearBean = lessyear;
		model.addAttribute("save", "1");
		request.getSession().setAttribute("bean", bean);
		return "member/CreditForm";
	}

	@RequestMapping(value = "/123")
	public String test1() {
		return "member/CreditForm";
	}
	@RequestMapping(value = "/gotopage2")
	public String gotopage2(Model model) {
		model.addAttribute("save", "2");
		return "member/CreditForm";
	}
	@RequestMapping(value = "/gotopage3")
	public String gotopage3(Model model) {
		model.addAttribute("save", "3");
		return "member/CreditForm";
	}
	@RequestMapping(value = "/gotopage4")
	public String gotopage4(Model model) {
		model.addAttribute("save", "4");
		return "member/CreditForm";
	}
	// end class
}
