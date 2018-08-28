package com.test.controller;





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
	
	
	
	
	@RequestMapping(value="/gotoregister")
	public String register(String email , String password,Model model) {
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
		model.addAttribute("msg", "");
		return "index";
	}
	//end class
}
