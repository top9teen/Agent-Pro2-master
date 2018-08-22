package com.test.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.Bean.BrandBean;
import com.test.Bean.CarBean;
import com.test.Bean.CriteriaBean;
import com.test.Bean.FormMemBean;
import com.test.Bean.FormregiterBean;
import com.test.Bean.SimpleTestBean;
import com.test.Bean.YearBean;
import com.test.Dao.FormRegisterDao;
import com.test.Dao.SearchCarDao;


@RestController
public class SearchCarController {
	
	@Autowired
	SearchCarDao searchCarDao;
	@Autowired
	FormRegisterDao formRegisterDao;
	@RequestMapping(value="/year")
	public List<YearBean> xxx() throws SQLException{
		List<YearBean> list = new ArrayList<YearBean>();
	
		list =searchCarDao.findAll();
		return list;
	}
	
	@RequestMapping(value="/brand", method = RequestMethod.POST)
	public List<CarBean> brand(@RequestBody CriteriaBean criteriaBean) throws SQLException{
		
		List<CarBean> list = new ArrayList<>();
		
//		query master data
	/*	for(int i=0; i<10; i++) {
			bean = new BrandBean();
			bean.setCarId(i);
			bean.setCarName("Top"+i);
			
			list.add(bean);
		}
		
		*/
		list  = searchCarDao.findAll(criteriaBean.getYear());
		return list;
	}
	
	@RequestMapping(value="/carmodel", method = RequestMethod.POST)
	public List<BrandBean> carmodel(@RequestBody CriteriaBean criteriaBean) throws SQLException{
		
		List<BrandBean> list = new ArrayList<>();

		list  = searchCarDao.findAll(criteriaBean.getYear(), criteriaBean.getBrand());
		return list;
	}
	
	@RequestMapping(value="/FFF", method = RequestMethod.POST)
	public FormregiterBean bean22(@RequestBody SimpleTestBean simpleTestBean) throws SQLException{
		
		FormregiterBean bean = new FormregiterBean();
		Integer x = Integer.valueOf(simpleTestBean.getXxx());

		bean  = formRegisterDao.vvvv(x);
		return bean;
	}
	@RequestMapping(value="/MFD", method = RequestMethod.POST)
	public FormMemBean bean22ss(@RequestBody SimpleTestBean simpleTestBean) throws SQLException{
		
		FormMemBean bean = new FormMemBean();
		Integer x = Integer.valueOf(simpleTestBean.getXxx());

		bean  = formRegisterDao.vvvv2(x);
		return bean;
	}
	

// end class
}
