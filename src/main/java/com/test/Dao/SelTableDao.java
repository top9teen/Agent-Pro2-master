package com.test.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.Bean.FormMemBean;
import com.test.Bean.FormregiterBean;
import com.test.util.ConnectDB;

@Repository
public class SelTableDao {

	public List<FormregiterBean> selre (String email) throws SQLException{
		FormregiterBean bean = new FormregiterBean();
		List<FormregiterBean> list = new ArrayList<>();
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		Connection conn = con.openConnect();
		try {
			sql.append(" SELECT * FROM  formregiter WHERE fo_email = ? ");
			prepared = conn.prepareStatement(sql.toString());
			prepared.setString(1, email);
			ResultSet rs = prepared.executeQuery();

			while (rs.next()) {
				bean = new FormregiterBean();
				bean.setFoUs(rs.getString("fo_us"));
				if(bean.getFoUs().equals("1")) {
					bean.setFoId(rs.getInt("fo_id"));
					bean.setFoGroupType(rs.getString("fo_groupType"));
					bean.setFoCarMake(rs.getString("fo_carMake"));
					bean.setFoCarMake2(rs.getString("fo_carMake2"));
					bean.setFoLessmoney(rs.getString("fo_lessmoney"));
					bean.setFoLessyear(rs.getString("fo_lessyear"));
					bean.setFoTypebank(rs.getString("fo_typebank"));
					bean.setFoCheckbox1(rs.getString("fo_checkbox1"));
					bean.setFoCheckbox2(rs.getString("fo_checkbox2"));
					bean.setFoCheckbox3(rs.getString("fo_checkbox3"));
					bean.setFoCheckbox4(rs.getString("fo_checkbox4"));
					bean.setFoPrefix(rs.getString("fo_prefix"));
					bean.setFoFNameTH(rs.getString("fo_fNameTH"));
					bean.setFoLNameTH(rs.getString("fo_lNameTH"));
					bean.setFoBirthDay(rs.getString("fo_birthDay"));
					bean.setFoBirthMonth(rs.getString("fo_birthMonth"));
					bean.setFoBirthYear(rs.getString("fo_birthYear"));
					bean.setFoRefID(rs.getString("fo_refID"));
					bean.setFoMobilePhone(rs.getString("fo_mobilePhone"));
					bean.setFoAvailableTime(rs.getString("fo_availableTime"));
					bean.setFoJob(rs.getString("fo_job"));
					bean.setFoSalary(rs.getString("fo_salary"));
					bean.setFoYearOfService(rs.getString("fo_yearOfService"));
					bean.setFoMonthOfService(rs.getString("fo_monthOfService"));
					bean.setFoBureauPaidedStatusPaid(rs.getString("fo_bureauPaidedStatusPaid"));
					bean.setFoPropertyProjectName(rs.getString("fo_propertyProjectName"));
					bean.setFoProvince(rs.getString("fo_province"));
					bean.setFoAmphur(rs.getString("fo_amphur"));
					bean.setFoDistrict(rs.getString("fo_district"));
					bean.setFoRadio(rs.getString("fo_Radio"));
						
						list.add(bean);
				}
			
					
				
				
		
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			conn.close();
		}
		
		return list ;
	}
	
	public FormregiterBean selre3 (int idss) throws SQLException{
		FormregiterBean bean = new FormregiterBean();
		
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		Connection conn = con.openConnect();
		try {
			sql.append(" SELECT * FROM  formregiter WHERE fo_id = ? ");
			prepared = conn.prepareStatement(sql.toString());
			prepared.setInt(1, idss);
			ResultSet rs = prepared.executeQuery();

			while (rs.next()) {
				bean = new FormregiterBean();
				bean.setFoId(rs.getInt("fo_id"));
				bean.setFoGroupType(rs.getString("fo_groupType"));
				bean.setFoCarMake(rs.getString("fo_carMake"));
				bean.setFoCarMake2(rs.getString("fo_carMake2"));
				bean.setFoLessmoney(rs.getString("fo_lessmoney"));
				bean.setFoLessyear(rs.getString("fo_lessyear"));
				bean.setFoTypebank(rs.getString("fo_typebank"));
				bean.setFoCheckbox1(rs.getString("fo_checkbox1"));
				bean.setFoCheckbox2(rs.getString("fo_checkbox2"));
				bean.setFoCheckbox3(rs.getString("fo_checkbox3"));
				bean.setFoCheckbox4(rs.getString("fo_checkbox4"));
				bean.setFoPrefix(rs.getString("fo_prefix"));
				bean.setFoFNameTH(rs.getString("fo_fNameTH"));
				bean.setFoLNameTH(rs.getString("fo_lNameTH"));
				bean.setFoBirthDay(rs.getString("fo_birthDay"));
				bean.setFoBirthMonth(rs.getString("fo_birthMonth"));
				bean.setFoBirthYear(rs.getString("fo_birthYear"));
				bean.setFoRefID(rs.getString("fo_refID"));
				bean.setFoMobilePhone(rs.getString("fo_mobilePhone"));
				bean.setFoAvailableTime(rs.getString("fo_availableTime"));
				bean.setFoJob(rs.getString("fo_job"));
				bean.setFoSalary(rs.getString("fo_salary"));
				bean.setFoYearOfService(rs.getString("fo_yearOfService"));
				bean.setFoMonthOfService(rs.getString("fo_monthOfService"));
				bean.setFoBureauPaidedStatusPaid(rs.getString("fo_bureauPaidedStatusPaid"));
				bean.setFoPropertyProjectName(rs.getString("fo_propertyProjectName"));
				bean.setFoProvince(rs.getString("fo_province"));
				bean.setFoAmphur(rs.getString("fo_amphur"));
				bean.setFoDistrict(rs.getString("fo_district"));
				bean.setFoRadio(rs.getString("fo_Radio"));
				bean.setFoEmail(rs.getString("fo_email"));
		
					
					
				
				
		
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			conn.close();
		}
		
		return bean ;
	}
	
	public FormMemBean selre2 (int ida) throws SQLException{
		FormMemBean bean = new FormMemBean();
		
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		Connection conn = con.openConnect();
		try {
			sql.append(" SELECT * FROM  formmen WHERE me_id = ? ");
			prepared = conn.prepareStatement(sql.toString());
			prepared.setInt(1, ida);
			ResultSet rs = prepared.executeQuery();

			while (rs.next()) {
				
				bean.setMePrefix2(rs.getString("me_prefix2"));
				bean.setMeFname2(rs.getString("me_fname2"));
				bean.setMeLname2(rs.getString("me_lname2"));
				bean.setMeBirthDay2(rs.getString("me_birthDay2"));
				bean.setMeBirthMonth2(rs.getString("me_birthMonth2"));
				bean.setMeBirthYear2(rs.getString("me_birthYear2"));
				bean.setMeTalaphone2(rs.getString("me_talaphone2"));
				bean.setMeEmail2(rs.getString("me_email2"));
				bean.setMeJob2(rs.getString("me_job2"));
				bean.setMeSalary2(rs.getString("me_salary2"));
				bean.setMeYearOfService2(rs.getString("me_yearOfService2"));
				bean.setMeMonthOfService2(rs.getString("me_monthOfService2"));
					
					
					
				
				
		
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			conn.close();
		}
		
		return bean ;
	}
	
	//end class
}
