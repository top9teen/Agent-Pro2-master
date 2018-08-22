package com.test.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;

import com.test.Bean.FormMemBean;
import com.test.Bean.FormregiterBean;
import com.test.Bean.IdFormReBean;

import com.test.util.ConnectDB;

@Repository
public class FormRegisterDao {

	public void formRegister(FormregiterBean formregiterBean) throws SQLException {
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		Connection conn = con.openConnect();
		try {
			sql.append(
					" INSERT INTO formregiter (fo_groupType,fo_carMake,fo_carMake2,fo_lessmoney,fo_lessyear,fo_typebank,fo_checkbox1,fo_checkbox2,fo_checkbox3,fo_checkbox4,fo_prefix,fo_fNameTH,fo_lNameTH,fo_birthDay,fo_birthMonth,fo_birthYear,fo_refID,fo_mobilePhone,fo_email,fo_availableTime,fo_job,fo_salary,fo_yearOfService,fo_monthOfService,fo_bureauPaidedStatusPaid,fo_propertyProjectName,fo_province,fo_amphur,fo_district,fo_Radio,fo_date,fo_reMonny,fo_us)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)  ");
			prepared = conn.prepareStatement(sql.toString());
			prepared.setString(1, formregiterBean.getFoGroupType());
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
			prepared.setString(33, "1");
			prepared.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

	}

	public void formRegisterff(FormMemBean formMemBean) throws SQLException {
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		Connection conn = con.openConnect();
		try {
			sql.append(
					" INSERT INTO formmen (me_id,me_prefix2,me_fname2,me_lname2,me_birthDay2,me_birthMonth2,me_birthYear2,me_talaphone2,me_email2,me_job2,me_salary2,me_yearOfService2,me_monthOfService2)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)  ");
			prepared = conn.prepareStatement(sql.toString());
			prepared.setInt(1, formMemBean.getMeId());
			prepared.setString(2, formMemBean.getMePrefix2());
			prepared.setString(3, formMemBean.getMeFname2());
			prepared.setString(4, formMemBean.getMeLname2());
			prepared.setString(5, formMemBean.getMeBirthDay2());
			prepared.setString(6, formMemBean.getMeBirthMonth2());
			prepared.setString(7, formMemBean.getMeBirthYear2());
			prepared.setString(8, formMemBean.getMeTalaphone2());
			prepared.setString(9, formMemBean.getMeEmail2());
			prepared.setString(10, formMemBean.getMeJob2());
			prepared.setString(11, formMemBean.getMeSalary2());
			prepared.setString(12, formMemBean.getMeYearOfService2());
			prepared.setString(13, formMemBean.getMeMonthOfService2());
			prepared.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

	}

	public IdFormReBean idform(FormregiterBean formregiterBean) throws SQLException {
		IdFormReBean bean = new IdFormReBean();
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		Connection conn = con.openConnect();

		try {
			sql.append(
					" SELECT fo_id FROM  formregiter WHERE fo_fNameTH = ? AND fo_lNameTH = ? AND fo_email = ? AND fo_groupType = ?  AND fo_carMake2 = ?");
			prepared = conn.prepareStatement(sql.toString());
			prepared.setString(1, formregiterBean.getFoFNameTH());
			prepared.setString(2, formregiterBean.getFoLNameTH());
			prepared.setString(3, formregiterBean.getFoEmail());
			prepared.setString(4, formregiterBean.getFoGroupType());
			prepared.setString(5, formregiterBean.getFoCarMake2());

			ResultSet rs = prepared.executeQuery();
			while (rs.next()) {
				bean.setFoId(rs.getInt("fo_id"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return bean;
	}

	public FormregiterBean vvvv(int simpleTestBean) throws SQLException {
		FormregiterBean bean = new FormregiterBean();
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		Connection conn = con.openConnect();

		try {
			sql.append(" SELECT * FROM  formregiter WHERE fo_id = ? ");
			prepared = conn.prepareStatement(sql.toString());
			prepared.setInt(1, simpleTestBean);

			ResultSet rs = prepared.executeQuery();
			while (rs.next()) {
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
				bean.setFoEmail(rs.getString("fo_email"));
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

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return bean;
	}

	public FormMemBean vvvv2(int simpleTestBean) throws SQLException {
		FormMemBean bean = new FormMemBean();
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		Connection conn = con.openConnect();

		try {
			sql.append(" SELECT * FROM  formmen WHERE me_id = ? ");
			prepared = conn.prepareStatement(sql.toString());
			prepared.setInt(1, simpleTestBean);

			ResultSet rs = prepared.executeQuery();
			while (rs.next()) {
				bean.setMeId(rs.getInt("me_id"));
				bean.setMePrefix2(rs.getString("me_prefix2"));
				bean.setMeFname2(rs.getString("me_fname2"));
				bean.setMeLname2(rs.getString("me_lname2"));
				bean.setMeBirthDay2(rs.getString("me_birthDay2"));
				bean.setMeBirthMonth2(rs.getString("me_birthMonth2"));
				bean.setMeBirthMonth2(rs.getString("me_birthYear2"));
				bean.setMeTalaphone2(rs.getString("me_talaphone2"));
				bean.setMeEmail2(rs.getString("me_email2"));
				bean.setMeJob2(rs.getString("me_job2"));
				bean.setMeSalary2(rs.getString("me_salary2"));
				bean.setMeMonthOfService2(rs.getString("me_monthOfService2"));
				bean.setMeYearOfService2(rs.getString("me_yearOfService2"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return bean;
	}

	// end class
}
