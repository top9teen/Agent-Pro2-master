package com.test.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.test.Bean.LoginBean;
import com.test.Bean.LoginBeanSimple;

import com.test.Dao.LoginDao;
import com.test.Dao.RegisterDao;


@Controller
public class NormalPersonController {


	@Autowired
	LoginDao loginDao;
	@Autowired 
	RegisterDao registerDao;
	
	
	@RequestMapping(value="/gotologin")
	public String login(String email , String password, Model model, HttpServletRequest request) {
		String page="" ;
		LoginBean bean =new LoginBean();
		LoginBeanSimple beansim =new LoginBeanSimple();
		beansim.setEmail(email);
		beansim.setPassword(password);
		try {
			bean=loginDao.login(beansim);
			if(bean.getLoEmail() != null) {
				if(bean.getLoStatus().equals("1")) {
					page = "admin";
				}
				else if (bean.getLoStatus().equals("2")) {
					model.addAttribute("save", "1");
					page = "member/welcome";
				}
				
				
			}
			else {
				page = "index";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return page;
	}
	
	@RequestMapping(value="/gotoregister")
	public String register(String email , String password) {
		LoginBeanSimple beansim =new LoginBeanSimple();
		beansim.setEmail(email);
		beansim.setPassword(password);
		LoginBean bean =new LoginBean();
		try {
			bean=loginDao.login(beansim);
			
			if (bean.getLoEmail() == null) {
				registerDao.register(beansim);
			
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "index";
	}
	//end class
}
