package com.test.controller;

import java.util.*;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.BankBean.KasikornPriceBean;
import com.test.BankBean.KrungsriPriceBean;
import com.test.BankBean.ScbeasyPriceBean;
import com.test.BankBean.ThanachartPriceBean;
import com.test.Bean.FormMemBean;
import com.test.Bean.FormregiterBean;
import com.test.Bean.IdFormReBean;
import com.test.Bean.LoginBean;
import com.test.Bean.LoginBeanSimple;
import com.test.Bean.SaveTable1Bean;
import com.test.Bean.YearCarBean;
import com.test.Dao.FormRegisterDao;
import com.test.Dao.LoginDao;
import com.test.Dao.ProvinceDao;
import com.test.Dao.RegisterDao;
import com.test.ServarDao.KasikornDao;
import com.test.ServarDao.KrungsriDao;
import com.test.ServarDao.ScbeasyDao;
import com.test.ServarDao.ThanachartDao;
import com.test.server.KasikornServer;
import com.test.server.KrungsriServer;
import com.test.server.ScbeasyServer;
import com.test.server.ThanachartServer;


@Controller
public class MemberController {
	@Autowired
	KasikornServer kasikornServer;
	@Autowired
	KrungsriServer krungsriServer;
	@Autowired
	ScbeasyServer scbeasyServer;
	@Autowired
	ThanachartServer thanachartServer;
	@Autowired
	ProvinceDao provinceDao;
	@Autowired
	FormRegisterDao formRegisterDao;
	@Autowired 
	KasikornDao kasikornDao;
	@Autowired
	KrungsriDao krungsriDao;
	@Autowired
	ScbeasyDao scbeasyDao;
	@Autowired
	ThanachartDao thanachartDao;
	@Autowired
	LoginDao loginDao;
	@Autowired 
	RegisterDao registerDao;

	@RequestMapping(value = "/welcome")
	public String welcome(Model model) {
		model.addAttribute("save", "1");
		return "member/welcome";
	}
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
					emailBean = bean.getLoEmail();
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

	@RequestMapping(value = "/gotobank")
	public String gotocredit(String groupType, String carMake, String carMake2, String lessmoney, String lessyear,
			HttpServletRequest request, Model model) throws SQLException {
		KasikornPriceBean kabean = new KasikornPriceBean();
		KrungsriPriceBean krbean = new KrungsriPriceBean();
		ScbeasyPriceBean scbean = new ScbeasyPriceBean();
		ThanachartPriceBean thbean = new ThanachartPriceBean();
		YearCarBean yebean = new YearCarBean();
		groupTypeBean = groupType;
		carMakeBean = carMake;
		carMake2Bean = carMake2;
		lessmoneyBean = lessmoney;
		lessyearBean = lessyear;
		kabean = kasikornServer.checkpriceKa(groupType, carMake2);
		krbean = krungsriServer.checkpricekr(groupType, carMake2);
		scbean = scbeasyServer.checkpricesc(groupType, carMake2);
		thbean = thanachartServer.checkpriceth(groupType, carMake2);
		yebean = provinceDao.yrbean(lessyear);
		request.getSession().setAttribute("kabean", kabean);
		request.getSession().setAttribute("krbean", krbean);
		request.getSession().setAttribute("scbean", scbean);
		request.getSession().setAttribute("thbean", thbean);
		request.getSession().setAttribute("yebean", yebean);
		return "member/SelBank";
	}

	@RequestMapping(value = "/gotoreg")
	public String gotobank(HttpServletRequest request, Model model, String typebank) {
		typeBankBean = typebank;
		SaveTable1Bean bean = new SaveTable1Bean();
		bean.setCarMake(carMakeBean);
		bean.setCarMake2(carMake2Bean);
		bean.setGroupType(groupTypeBean);
		bean.setLessmoney(lessmoneyBean);
		bean.setLessyear(lessyearBean);

		model.addAttribute("save", "1");
		
		request.getSession().setAttribute("bean", bean);

		return "member/CreditForm";

	}

	@RequestMapping(value = "/123")
	public String test1() {
		return "member/CreditForm";
	}

	@RequestMapping(value = "/gotopage2")
	public String gotopage2(Model model, String lessmoney, String Incheckbox1, String Incheckbox2, String Incheckbox3,
			String Incheckbox4,HttpServletRequest request) {
		IdFormReBean bean = new IdFormReBean();
		lessmoneyBean = lessmoney;
		Incheckbox1Bean = Incheckbox1;
		Incheckbox2Bean = Incheckbox2;
		Incheckbox3Bean = Incheckbox3;
		Incheckbox4Bean = Incheckbox4;
		/*
		 * System.out.println(Incheckbox1Bean); System.out.println(Incheckbox2Bean);
		 * System.out.println(Incheckbox3Bean); System.out.println(Incheckbox4Bean);
		 */
		bean.setEmailTest(emailBean);
		request.getSession().setAttribute("bean", bean);
		model.addAttribute("save", "2");
		return "member/CreditForm";
	}

	@RequestMapping(value = "/gotopage3")
	public String gotopage3(Model model, String prefix, String fNameTH, String lNameTH, String birthDay,
			String birthMonth, String birthYear, String refID, String mobilePhone, String email, String availableTime,
			String job, String salary, HttpServletRequest request,String yearOfService, String monthOfService, String bureauPaidedStatusPaid) {
		prefixBean = prefix;
		fNameTHBean = fNameTH;
		lNameTHBean = lNameTH;
		birthDayBean = birthDay;
		birthMonthBean = birthMonth;
		birthYearBean = birthYear;
		refIDBean = refID;
		mobilePhoneBean = mobilePhone;
		availableTimeBean = availableTime;
		jobBean = job;
		salaryBean = salary;
		yearOfServiceBean = yearOfService;
		monthOfServiceBean = monthOfService;
		bureauPaidedStatusPaidBean = bureauPaidedStatusPaid;
		
		model.addAttribute("save", "3");
		return "member/CreditForm";
	}

	@RequestMapping(value = "/gotopage4")
	public String gotopage4(Model model) {
		model.addAttribute("save", "4");
		return "member/CreditForm";
	}

	public String propertyProjectNameBean, provinceBean, amphurBean, districtBean, RadioBean, prefix2Bean, fname2Bean,
			lname2Bean, birthDay2Bean, birthMonth2Bean, birthYear2Bean, talaphone2Bean, email2Bean, job2Bean,
			salary2Bean, yearOfService2Bean, monthOfService2Bean;
	public int idsee ;
	public String groupTypeBean, carMakeBean, carMake2Bean, lessmoneyBean, lessyearBean, typeBankBean;
	public String Incheckbox1Bean, Incheckbox2Bean, Incheckbox3Bean, Incheckbox4Bean;
	public String prefixBean, fNameTHBean, lNameTHBean, birthDayBean, birthMonthBean, birthYearBean, refIDBean,
			mobilePhoneBean, emailBean, availableTimeBean, jobBean, salaryBean, yearOfServiceBean, monthOfServiceBean,
			bureauPaidedStatusPaidBean;

	@RequestMapping(value = "/register")
	public String register(Model model, String propertyProjectName, String province, String amphur, String district,
			String Radio, String prefix2, String fname2, String lname2, String birthDay2, String birthMonth2,
			String birthYear2, String talaphone2, String email2, String job2, String salary2, String yearOfService2,
			String monthOfService2,HttpServletRequest request)  throws SQLException{
		FormMemBean membean = new FormMemBean();
	
		propertyProjectNameBean = propertyProjectName;
		provinceBean =province;
		amphurBean = amphur;
		districtBean = district;
		RadioBean = Radio;
		prefix2Bean =prefix2;
		fname2Bean = fname2;
		lname2Bean = lname2;
		birthDay2Bean = birthDay2;
		birthMonth2Bean = birthMonth2;
		birthYear2Bean = birthYear2;
		talaphone2Bean = talaphone2;
		email2Bean = email2;
		job2Bean = job2;
		salary2Bean = salary2;
		yearOfService2Bean = yearOfService2;
		monthOfService2Bean = monthOfService2;
		FormregiterBean formregiterBean = new FormregiterBean() ;
		formregiterBean.setFoGroupType(groupTypeBean);
		formregiterBean.setFoCarMake(carMakeBean);
		formregiterBean.setFoCarMake2(carMake2Bean);
		formregiterBean.setFoLessmoney(lessmoneyBean);
		formregiterBean.setFoLessyear(lessyearBean);
		formregiterBean.setFoTypebank(typeBankBean);
		formregiterBean.setFoCheckbox1(Incheckbox1Bean);
		formregiterBean.setFoCheckbox2(Incheckbox2Bean);
		formregiterBean.setFoCheckbox3(Incheckbox3Bean);
		formregiterBean.setFoCheckbox4(Incheckbox4Bean);
		formregiterBean.setFoPrefix(prefixBean);
		formregiterBean.setFoFNameTH(fNameTHBean);
		formregiterBean.setFoLNameTH(lNameTHBean);
		formregiterBean.setFoBirthDay(birthDayBean);
		formregiterBean.setFoBirthMonth(birthMonthBean);
		formregiterBean.setFoBirthYear(birthYearBean);
		formregiterBean.setFoRefID(refIDBean);
		formregiterBean.setFoMobilePhone(mobilePhoneBean);
		formregiterBean.setFoEmail(emailBean);
		formregiterBean.setFoAvailableTime(availableTimeBean);
		formregiterBean.setFoJob(jobBean);
		formregiterBean.setFoSalary(salaryBean);
		formregiterBean.setFoYearOfService(yearOfServiceBean);
		formregiterBean.setFoMonthOfService(monthOfServiceBean);
		formregiterBean.setFoBureauPaidedStatusPaid(bureauPaidedStatusPaidBean);
		formregiterBean.setFoPropertyProjectName(propertyProjectNameBean);
		formregiterBean.setFoProvince(provinceBean);
		formregiterBean.setFoAmphur(amphurBean);
		formregiterBean.setFoDistrict(districtBean);
		formregiterBean.setFoRadio(RadioBean);
		formregiterBean.setFoDate(new Date());
		membean.setMePrefix2(prefix2Bean);
		membean.setMeFname2(fname2Bean);
		membean.setMeLname2(lname2Bean);
		membean.setMeBirthDay2(birthDay2Bean);
		membean.setMeBirthMonth2(birthMonth2Bean);
		membean.setMeBirthYear2(birthYear2Bean);
		membean.setMeTalaphone2(talaphone2Bean);
		membean.setMeEmail2(email2Bean);
		membean.setMeJob2(job2Bean);
		membean.setMeSalary2(salary2Bean);
		membean.setMeYearOfService2(yearOfService2Bean);
		membean.setMeMonthOfService2(monthOfService2Bean);
		
		formRegisterDao.formRegister(formregiterBean);
		if(RadioBean.equals("1")) {
			IdFormReBean bean2 = new IdFormReBean();
			bean2=formRegisterDao.idform(formregiterBean);
			idsee=bean2.getFoId();
			membean.setMeId(bean2.getFoId());
			
			formRegisterDao.formRegisterff(membean);	
		}
		else {	
		}
		
		// include type Blank 
		if(typeBankBean.equals("ka1")) {
			String a = Integer.toString(idsee);
			formregiterBean.setFoTypebank(a);
			kasikornDao.formRegister(formregiterBean);
			if(RadioBean.equals("1")) {
				IdFormReBean bean2 = new IdFormReBean();
				bean2=kasikornDao.idform(formregiterBean);
				membean.setMeId(bean2.getFoId());
				kasikornDao.formRegisterff(membean);
			}
			
		} 
		else if (typeBankBean.equals("kr1")) {
			String a = Integer.toString(idsee);
			formregiterBean.setFoTypebank(a);
			krungsriDao.formRegister(formregiterBean);
			if(RadioBean.equals("1")) {
				IdFormReBean bean2 = new IdFormReBean();
				bean2=krungsriDao.idform(formregiterBean);
				membean.setMeId(bean2.getFoId());
				krungsriDao.formRegisterff(membean);
			}
			
			
		}else if (typeBankBean.equals("th1")) {
			String a = Integer.toString(idsee);
			formregiterBean.setFoTypebank(a);
			thanachartDao.formRegister(formregiterBean);
			if(RadioBean.equals("1")) {
				IdFormReBean bean2 = new IdFormReBean();
				bean2=thanachartDao.idform(formregiterBean);
				membean.setMeId(bean2.getFoId());
				thanachartDao.formRegisterff(membean);
			}
			
			
		}else if (typeBankBean.equals("sc1")) {
			String a = Integer.toString(idsee);
			formregiterBean.setFoTypebank(a);
			scbeasyDao.formRegister(formregiterBean);
			if(RadioBean.equals("1")) {
				IdFormReBean bean2 = new IdFormReBean();
				bean2=scbeasyDao.idform(formregiterBean);
				membean.setMeId(bean2.getFoId());
				scbeasyDao.formRegisterff(membean);
			}
			
		}

		// Session
		request.getSession().setAttribute("kabean", formregiterBean);
		model.addAttribute("save", "1");
		return "member/welcome";
	}
	// end class
}
