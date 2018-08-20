package com.test.ServarDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.test.Bean.FormMemBean;
import com.test.Bean.FormregiterBean;
import com.test.Bean.IdFormReBean;
import com.test.util.ThanachartDB;

@Repository
public class ThanachartDao {

	
	
	public void formRegister(FormregiterBean formregiterBean) throws SQLException {
		ThanachartDB con = new ThanachartDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		Connection conn = con.openConnect();
		try {
			sql.append(
					" INSERT INTO formregiter (fo_groupType,fo_carMake,fo_carMake2,fo_lessmoney,fo_lessyear,fo_typebank,fo_checkbox1,fo_checkbox2,fo_checkbox3,fo_checkbox4,fo_prefix,fo_fNameTH,fo_lNameTH,fo_birthDay,fo_birthMonth,fo_birthYear,fo_refID,fo_mobilePhone,fo_email,fo_availableTime,fo_job,fo_salary,fo_yearOfService,fo_monthOfService,fo_bureauPaidedStatusPaid,fo_propertyProjectName,fo_province,fo_amphur,fo_district,fo_Radio,fo_date,fo_reMonny)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)  ");
			prepared = conn.prepareStatement(sql.toString());
			prepared.setString(1,formregiterBean.getFoGroupType());
			prepared.setString(2, formregiterBean.getFoCarMake());
			prepared.setString(3, formregiterBean.getFoCarMake2());
			prepared.setString(4, formregiterBean.getFoLessmoney());
			prepared.setString(5, formregiterBean.getFoLessyear());
			prepared.setString(6, formregiterBean.getFoTypebank());
			prepared.setString(7, formregiterBean.getFoCheckbox1());
			prepared.setString(8, formregiterBean.getFoCheckbox2());
			prepared.setString(9, formregiterBean.getFoCheckbox3());
			prepared.setString(10, formregiterBean.getFoCheckbox4());
			prepared.setString(11, formregiterBean.getFoPrefix());
			prepared.setString(12, formregiterBean.getFoFNameTH());
			prepared.setString(13, formregiterBean.getFoLNameTH());
			prepared.setString(14, formregiterBean.getFoBirthDay());
			prepared.setString(15, formregiterBean.getFoBirthMonth());
			prepared.setString(16, formregiterBean.getFoBirthYear());
			prepared.setString(17, formregiterBean.getFoRefID());
			prepared.setString(18, formregiterBean.getFoMobilePhone());
			prepared.setString(19, formregiterBean.getFoEmail());
			prepared.setString(20, formregiterBean.getFoAvailableTime());
			prepared.setString(21, formregiterBean.getFoJob());
			prepared.setString(22, formregiterBean.getFoSalary());
			prepared.setString(23, formregiterBean.getFoYearOfService());
			prepared.setString(24, formregiterBean.getFoMonthOfService());
			prepared.setString(25, formregiterBean.getFoBureauPaidedStatusPaid());
			prepared.setString(26, formregiterBean.getFoPropertyProjectName());
			prepared.setString(27, formregiterBean.getFoProvince());
			prepared.setString(28, formregiterBean.getFoAmphur());
			prepared.setString(29, formregiterBean.getFoDistrict());
			prepared.setString(30, formregiterBean.getFoRadio());
			prepared.setDate(31, new Date(formregiterBean.getFoDate().getTime()));
			prepared.setInt(32, formregiterBean.getFoReMonny());
			prepared.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

	}
	
	public void formRegisterff(FormMemBean formMemBean) throws SQLException {
		ThanachartDB con = new ThanachartDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		Connection conn = con.openConnect();
		try {
			sql.append(
					" INSERT INTO formmen (me_id,me_prefix2,me_fname2,me_lname2,me_birthDay2,me_birthMonth2,me_birthYear2,me_talaphone2,me_email2,me_job2,me_salary2,me_yearOfService2,me_monthOfService2)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)  ");
			prepared = conn.prepareStatement(sql.toString());
			prepared.setInt(1,formMemBean.getMeId());
			prepared.setString(2,formMemBean.getMePrefix2());
			prepared.setString(3,formMemBean.getMeFname2());
			prepared.setString(4,formMemBean.getMeLname2());
			prepared.setString(5,formMemBean.getMeBirthDay2());
			prepared.setString(6,formMemBean.getMeBirthMonth2());
			prepared.setString(7,formMemBean.getMeBirthYear2());
			prepared.setString(8,formMemBean.getMeTalaphone2());
			prepared.setString(9,formMemBean.getMeEmail2());
			prepared.setString(10,formMemBean.getMeJob2());
			prepared.setString(11,formMemBean.getMeSalary2());
			prepared.setString(12,formMemBean.getMeYearOfService2());
			prepared.setString(13,formMemBean.getMeMonthOfService2());
			prepared.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

	}
	public IdFormReBean idform (FormregiterBean formregiterBean) throws SQLException{
		IdFormReBean bean = new IdFormReBean();
		ThanachartDB con = new ThanachartDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		Connection conn = con.openConnect();
		
		try {
			sql.append(" SELECT fo_id FROM  formregiter WHERE fo_fNameTH = ? AND fo_lNameTH = ? AND fo_email = ? AND fo_groupType = ?  AND fo_carMake2 = ?");
			prepared = conn.prepareStatement(sql.toString());
			prepared.setString(1, formregiterBean.getFoFNameTH());
			prepared.setString(2, formregiterBean.getFoLNameTH());
			prepared.setString(3, formregiterBean.getFoEmail());
			prepared.setString(4,formregiterBean.getFoGroupType());
			prepared.setString(5, formregiterBean.getFoCarMake2());

			ResultSet rs = prepared.executeQuery();
			while (rs.next()) {
			bean.setFoId(rs.getInt("fo_id"));
		
			}

	}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		
		return bean ;
	}
	
	
	// end class
}
