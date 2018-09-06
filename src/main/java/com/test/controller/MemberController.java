package com.test.controller;

import java.util.*;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

import com.test.Bean.AmphurBean;
import com.test.Bean.DistrictBean;
import com.test.Bean.FormMemBean;
import com.test.Bean.FormregiterBean;
import com.test.Bean.GatherBean;
import com.test.Bean.IdFormReBean;
import com.test.Bean.LoginBean;
import com.test.Bean.LoginBeanSimple;
import com.test.Bean.MiradoBean;
import com.test.Bean.ProvinceBean;
import com.test.Bean.ReceiptBean;
import com.test.Bean.SaveTable1Bean;

import com.test.Bean.YearCarBean;
import com.test.Dao.CkDao;
import com.test.Dao.FormMonnyDao;
import com.test.Dao.FormRegisterDao;
import com.test.Dao.LoginDao;
import com.test.Dao.ProvinceDao;
import com.test.Dao.RegisterDao;
import com.test.Dao.SelTableDao;
import com.test.Dao.TransferDao;
import com.test.ServarDao.KasikornDao;
import com.test.ServarDao.KrungsriDao;
import com.test.ServarDao.ScbeasyDao;
import com.test.ServarDao.ThanachartDao;
import com.test.config.PaypalPaymentIntent;
import com.test.config.PaypalPaymentMethod;
import com.test.server.KasikornServer;
import com.test.server.KrungsriServer;
import com.test.server.ScbeasyServer;
import com.test.server.ThanachartServer;
import com.test.service.PaypalService;
import com.test.util.URLUtils;

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
	@Autowired
	SelTableDao selTableDao;
	@Autowired
	CkDao ckDao;
	@Autowired
	FormMonnyDao formMonnyDao;
	@Autowired
	TransferDao transferDao;


	public static final String PAYPAL_SUCCESS_URL = "success";
	public static final String PAYPAL_CANCEL_URL = "cancel";

	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private PaypalService paypalService;

	@RequestMapping(value = "/welcome")
	public String welcome(Model model) {
		model.addAttribute("save", "1");

		return "member/welcome";
	}

	public int BosTERS;

	// paypal
	@RequestMapping(value = "/pay")
	public String MBS(HttpServletRequest request, int regid) throws SQLException {
		String cancelUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_CANCEL_URL;
		String successUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_SUCCESS_URL;
		BosTERS = regid;
		GatherBean bean = new GatherBean();
		bean = formMonnyDao.vss(regid);

		try {
			int a = bean.getGaPrie();
			Payment payment = paypalService.createPayment(a + .00, "USD", PaypalPaymentMethod.paypal,
					PaypalPaymentIntent.sale, "payment description", cancelUrl, successUrl);
			for (Links links : payment.getLinks()) {
				if (links.getRel().equals("approval_url")) {
					return "redirect:" + links.getHref();
				}
			}
		} catch (PayPalRESTException e) {
			log.error(e.getMessage());
		}
		return "redirect:/";
	}

	@RequestMapping(method = RequestMethod.GET, value = PAYPAL_CANCEL_URL)
	public String cancelPay(HttpServletRequest request) throws ParseException, SQLException {
		List<GatherBean> list = new ArrayList<>();
		String email = emailBean;
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date today = sdf.parse("14/11/2018");
		Calendar cal = Calendar.getInstance();
		today = new Date();
		cal.setTime(today);
		int M = 0, D = 0;
		M = cal.get(Calendar.MONTH);
		D = cal.get(Calendar.DATE);
		list = formMonnyDao.branddd(email, M + 1, D);

		request.getSession().setAttribute("list", list);
		return "member/FormUser";
	}

	// ทำต่อ
	@RequestMapping(method = RequestMethod.GET, value = PAYPAL_SUCCESS_URL)
	public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId,
			HttpServletRequest request) throws SQLException, ParseException {
		GatherBean bean = new GatherBean();
		ReceiptBean cev = new ReceiptBean();
		FormregiterBean rebean = new FormregiterBean();
		int a = 0, m = 0, n = 0, p = 0;
		List<GatherBean> list = new ArrayList<>();
		String email = emailBean;
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date today = sdf.parse("14/11/2018");
		Calendar cal = Calendar.getInstance();
		today = new Date();
		cal.setTime(today);
		int M = 0, D = 0, Y = 0;
		M = cal.get(Calendar.MONTH);
		D = cal.get(Calendar.DATE);
		Y = cal.get(Calendar.YEAR);
		bean = formMonnyDao.vss(BosTERS);
		a = bean.getGaId();
		m = M + 2;
		n = Y;
		p = bean.getGaFistPeriod() - 1;
		String Mo[] = { "มกราคม", "กุมภาพันธ์", "มีนาคม", "เมษายน", "พฤษภาคม", "มิถุนายน", "กรกฎาคม", "สิงหาคม",
				"กันยายน", "ตุลาคม", "พฤศจิกายน", "ธันวาคม" };

		rebean = formRegisterDao.vvvv(bean.getGaUser());
		cev.setReAdmin("แอดมินเว็บไซต์");
		cev.setReBank("กสิกร");
		cev.setReDay(D);
		cev.setReMont(Mo[M]);
		cev.setReEmail(bean.getGaEmail());
		cev.setReIdga(bean.getGaId());
		String vp = String.valueOf(bean.getGaPrie());
		cev.setReMonny(vp);
		cev.setReName(rebean.getFoFNameTH()+"        " + rebean.getFoLNameTH());
		cev.setReYrar(n);
		cev.setReCar(rebean.getFoCarMake());
		cev.setReCaryear(rebean.getFoGroupType());
		cev.setReCarmodel(rebean.getFoCarMake2());
		try {
			Payment payment = paypalService.executePayment(paymentId, payerId);
			formMonnyDao.sot(m, n, a, p);
			formMonnyDao.msaw(cev);

			if (payment.getState().equals("approved")) {

			}
		} catch (PayPalRESTException e) {
			log.error(e.getMessage());
		}
		list = formMonnyDao.branddd(email, M + 1, D);
		request.getSession().setAttribute("list", list);
		return "member/FormUser";
	}
	// end paypal
	
	// face book
	@RequestMapping(value = "/facebook")
	public String facebook( String regid, Model model, HttpServletRequest request) {
		System.out.println(regid);
		String page = "";
		LoginBean bean = new LoginBean();
		LoginBeanSimple beansim = new LoginBeanSimple();
		beansim.setEmail(regid);
		
		try {
			bean = loginDao.loginfas(beansim);
			if (bean.getLoEmail() != null) {
				if (bean.getLoStatus().equals("1")) {
					model.addAttribute("msg", "L");
					page = "admin/welcome";
				} else if (bean.getLoStatus().equals("2")) {
					model.addAttribute("save", "1");
					model.addAttribute("msg", "L");
					page = "member/welcome";
					emailBean = bean.getLoEmail();
				}else if (bean.getLoStatus().equals("3")) {
					model.addAttribute("msg", "G");
					page = "index";
					
				}


			} else if(bean.getLoEmail() == null) {
				registerDao.registerfas(beansim);
				bean = loginDao.loginfas(beansim);
				if (bean.getLoStatus().equals("1")) {
					model.addAttribute("msg", "L");
					page = "admin/welcome";
				} else if (bean.getLoStatus().equals("2")) {
					model.addAttribute("save", "1");
					model.addAttribute("msg", "L");
					page = "member/welcome";
					emailBean = bean.getLoEmail();
				}else if (bean.getLoStatus().equals("3")) {
					model.addAttribute("msg", "G");
					page = "index";
					
				}
				model.addAttribute("msg", "F");
				page = "index";
			}else {
				model.addAttribute("msg", "F");
				page = "index";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return page;
	}

	// google api
	@RequestMapping(value = "/google")
	public String google( String regid2, Model model, HttpServletRequest request) {
		System.out.println(regid2);
		String page = "";
		LoginBean bean = new LoginBean();
		LoginBeanSimple beansim = new LoginBeanSimple();
		beansim.setEmail(regid2);
		
		try {
			bean = loginDao.loginfas(beansim);
			if (bean.getLoEmail() != null) {
				if (bean.getLoStatus().equals("1")) {
					model.addAttribute("msg", "L");
					page = "admin/welcome";
				} else if (bean.getLoStatus().equals("2")) {
					model.addAttribute("save", "1");
					model.addAttribute("msg", "L");
					page = "member/welcome";
					emailBean = bean.getLoEmail();
				}else if (bean.getLoStatus().equals("3")) {
					model.addAttribute("msg", "G");
					page = "index";
					
				}


			} else if(bean.getLoEmail() == null) {
				registerDao.registerfas(beansim);
				bean = loginDao.loginfas(beansim);
				if (bean.getLoStatus().equals("1")) {
					model.addAttribute("msg", "L");
					page = "admin/welcome";
				} else if (bean.getLoStatus().equals("2")) {
					model.addAttribute("save", "1");
					model.addAttribute("msg", "L");
					page = "member/welcome";
					emailBean = bean.getLoEmail();
				}else if (bean.getLoStatus().equals("3")) {
					model.addAttribute("msg", "G");
					page = "index";
					
				}
				model.addAttribute("msg", "F");
				page = "index";
			}else {
				model.addAttribute("msg", "F");
				page = "index";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return page;
	}


	
	
	@RequestMapping(value = "/ddd")
	public String ddd(Model model, HttpServletRequest request) throws SQLException, ParseException {
		List<GatherBean> list = new ArrayList<>();
		String email = emailBean;
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date today = sdf.parse("14/11/2018");
		Calendar cal = Calendar.getInstance();
		today = new Date();
		cal.setTime(today);
		int M = 0, D = 0;
		M = cal.get(Calendar.MONTH);
		D = cal.get(Calendar.DATE);

		if (D <= 31) {

			list = formMonnyDao.branddd(email, M + 1, D);

		}

		request.getSession().setAttribute("list", list);

		return "member/FormUser";
	}

	@RequestMapping(value = "/gotologin")
	public String login(String email, String password, Model model, HttpServletRequest request) {
		String page = "";
		LoginBean bean = new LoginBean();
		LoginBeanSimple beansim = new LoginBeanSimple();
		beansim.setEmail(email);
		beansim.setPassword(password);
		try {
			bean = loginDao.login(beansim);
			if (bean.getLoEmail() != null) {
				if (bean.getLoStatus().equals("1")) {
					model.addAttribute("msg", "L");
					page = "admin/welcome";
				} else if (bean.getLoStatus().equals("2")) {
					model.addAttribute("save", "1");
					model.addAttribute("msg", "L");
					page = "member/welcome";
					emailBean = bean.getLoEmail();
				}else if (bean.getLoStatus().equals("3")) {
					model.addAttribute("msg", "G");
					page = "index";
					
				}


			} else {
				model.addAttribute("msg", "F");
				page = "index";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return page;
	}

	@RequestMapping(value = "/gotobank")
	public String gotocredit(String groupType, String carMake, String carMake2, String lessmoney, String lessyear,
			HttpServletRequest request, Model model, String mos) throws SQLException {
		/*KasikornPriceBean kabean = new KasikornPriceBean();
		KrungsriPriceBean krbean = new KrungsriPriceBean();
		ScbeasyPriceBean scbean = new ScbeasyPriceBean();
		ThanachartPriceBean thbean = new ThanachartPriceBean();
	*/
		YearCarBean yebean = new YearCarBean();
		MiradoBean mibean = new MiradoBean();
		mibean.setGroupType(groupType);
		mibean.setCarMake2(carMake2);
		groupTypeBean = groupType;
		carMakeBean = carMake;
		carMake2Bean = carMake2;
		lessmoneyBean = lessmoney;
		lessyearBean = lessyear;
	
		int bos = Integer.valueOf(mos);

		MoTesBean = bos;
		yebean = provinceDao.yrbean(lessyear);
	
	/*	kabean = kasikornServer.checkpriceKa(groupType, carMake2);
		krbean = krungsriServer.checkpricekr(groupType, carMake2);
		scbean = scbeasyServer.checkpricesc(groupType, carMake2);
		thbean = thanachartServer.checkpriceth(groupType, carMake2);
		
		request.getSession().setAttribute("kabean", kabean);
		request.getSession().setAttribute("krbean", krbean);
		request.getSession().setAttribute("scbean", scbean);
		request.getSession().setAttribute("thbean", thbean);
		*/
		request.getSession().setAttribute("yebean", yebean);
		request.getSession().setAttribute("mibean", mibean);
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
			String Incheckbox4, HttpServletRequest request) {
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
			String job, String salary, HttpServletRequest request, String yearOfService, String monthOfService,
			String bureauPaidedStatusPaid) {
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
	public int idsee, MoTesBean;
	public String groupTypeBean, carMakeBean, carMake2Bean, lessmoneyBean, lessyearBean, typeBankBean;
	public String Incheckbox1Bean, Incheckbox2Bean, Incheckbox3Bean, Incheckbox4Bean;
	public String prefixBean, fNameTHBean, lNameTHBean, birthDayBean, birthMonthBean, birthYearBean, refIDBean,
			mobilePhoneBean, emailBean, availableTimeBean, jobBean, salaryBean, yearOfServiceBean, monthOfServiceBean,
			bureauPaidedStatusPaidBean;

	@RequestMapping(value = "/register")
	public String register(Model model, String propertyProjectName, int province, int amphur, int district,
			String Radio, String prefix2, String fname2, String lname2, String birthDay2, String birthMonth2,
			String birthYear2, String talaphone2, String email2, String job2, String salary2, String yearOfService2,
			String monthOfService2, HttpServletRequest request, AmphurBean amp, ProvinceBean pro, DistrictBean dis)
			throws SQLException {
		FormMemBean membean = new FormMemBean();
		amp = ckDao.amphur(amphur);
		pro = ckDao.province(province);
		dis = ckDao.dis(district);
		propertyProjectNameBean = propertyProjectName;
		provinceBean = pro.getProvinceName();
		amphurBean = amp.getAmphurName();
		districtBean = dis.getDistrictName();
		RadioBean = Radio;
		prefix2Bean = prefix2;
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
		FormregiterBean formregiterBean = new FormregiterBean();
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
		formregiterBean.setFoReMonny(MoTesBean);
		formRegisterDao.formRegister(formregiterBean);
		if (RadioBean.equals("1")) {
			IdFormReBean bean2 = new IdFormReBean();
			bean2 = formRegisterDao.idform(formregiterBean);
			idsee = bean2.getFoId();
			membean.setMeId(bean2.getFoId());

			formRegisterDao.formRegisterff(membean);
		} else {
		}

		// include type Blank
		if (typeBankBean.equals("ka1")) {
			String a = Integer.toString(idsee);
			formregiterBean.setFoTypebank(a);
			kasikornDao.formRegister(formregiterBean);
			if (RadioBean.equals("1")) {
				IdFormReBean bean2 = new IdFormReBean();
				bean2 = kasikornDao.idform(formregiterBean);
				membean.setMeId(bean2.getFoId());
				kasikornDao.formRegisterff(membean);
			}

		} else if (typeBankBean.equals("kr1")) {
			String a = Integer.toString(idsee);
			formregiterBean.setFoTypebank(a);
			krungsriDao.formRegister(formregiterBean);
			if (RadioBean.equals("1")) {
				IdFormReBean bean2 = new IdFormReBean();
				bean2 = krungsriDao.idform(formregiterBean);
				membean.setMeId(bean2.getFoId());
				krungsriDao.formRegisterff(membean);
			}

		} else if (typeBankBean.equals("th1")) {
			String a = Integer.toString(idsee);
			formregiterBean.setFoTypebank(a);
			thanachartDao.formRegister(formregiterBean);
			if (RadioBean.equals("1")) {
				IdFormReBean bean2 = new IdFormReBean();
				bean2 = thanachartDao.idform(formregiterBean);
				membean.setMeId(bean2.getFoId());
				thanachartDao.formRegisterff(membean);
			}

		} else if (typeBankBean.equals("sc1")) {
			String a = Integer.toString(idsee);
			formregiterBean.setFoTypebank(a);
			scbeasyDao.formRegister(formregiterBean);
			if (RadioBean.equals("1")) {
				IdFormReBean bean2 = new IdFormReBean();
				bean2 = scbeasyDao.idform(formregiterBean);
				membean.setMeId(bean2.getFoId());
				scbeasyDao.formRegisterff(membean);
			}

		}

		// Session
		request.getSession().setAttribute("kabean", formregiterBean);
		model.addAttribute("save", "1");
		return "member/welcome";
	}

	@RequestMapping(value = "/gotoCreditAnalysis")
	public String tableTest(HttpServletRequest requst) throws SQLException {
		List<FormregiterBean> list = new ArrayList<>();
		list = selTableDao.selre(emailBean);
		
		requst.getSession().setAttribute("listUser", list);

		return "member/CreditAnalysis";
	}

	@RequestMapping(value = "/gotoSelPrivice")
	public String tableTest2(HttpServletRequest requst, int regid) throws SQLException {
		FormMemBean beanmem = new FormMemBean();
		FormregiterBean beanres = new FormregiterBean();

		beanmem = selTableDao.selre2(regid);
		beanres = selTableDao.selre3(regid);
		requst.getSession().setAttribute("beanres", beanres);
		requst.getSession().setAttribute("beanmem", beanmem);
		return "member/CreditAnalysis";
	}
	@RequestMapping(value = "/gototran")
	public String gototran(HttpServletRequest requst) throws SQLException {
			List<ReceiptBean> list = new ArrayList<>();
		list = transferDao.Trensasda(emailBean);
		requst.getSession().setAttribute("list", list);
		return "member/Transfer";
	}
	
	@RequestMapping(value = "/repassword")
	public String repassword(Model model){
		
			model.addAttribute("re", "");
		
		
		return "member/repassword";
	}
	
	@RequestMapping(value = "/refass")
	public String refass(Model model,String newpass ){
		LoginBean bean = new LoginBean();
		LoginBeanSimple beansim = new LoginBeanSimple();
		beansim.setEmail(emailBean);
		beansim.setPassword(newpass);
		try {
			bean = loginDao.login(beansim);
			model.addAttribute("re", "L");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
		
		return "member/repassword";
	}
	
	// end class
}