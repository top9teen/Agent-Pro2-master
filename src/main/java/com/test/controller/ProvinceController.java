package com.test.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.Bean.AmphurBean;
import com.test.Bean.CriteriaBean;
import com.test.Bean.DistrictBean;
import com.test.Bean.ProvinceBean;
import com.test.Dao.ProvinceDao;

@RestController
public class ProvinceController {

	
	@Autowired
	ProvinceDao provinceDao;
	
	@RequestMapping(value="/province")
	public List<ProvinceBean> province()throws SQLException {
		List<ProvinceBean> list = new ArrayList<ProvinceBean>();
	
		list = provinceDao.findallProvince();
		return list;
	}
	
	@RequestMapping(value="/amphur", method = RequestMethod.POST)
	public List<AmphurBean> amphur(@RequestBody CriteriaBean criteriaBean)throws SQLException {
		
		List<AmphurBean> list2 = new ArrayList<>();
		list2  = provinceDao.findAllaumhur(criteriaBean.getXxx());
		return list2;
	}
	
	@RequestMapping(value="/district", method = RequestMethod.POST)
	public List<DistrictBean> district(@RequestBody CriteriaBean criteriaBean) throws SQLException{
		
		List<DistrictBean> list2 = new ArrayList<>();
		list2  = provinceDao.findAlldistrict(criteriaBean.getXxx());
		return list2;
	}
	
//End Class	
}
