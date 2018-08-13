package com.test.Dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;
import com.test.Bean.FormregiterBean;
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
					" INSERT INTO formregiter (fo_groupType,fo_carMake,fo_carMake2,fo_lessmoney,fo_lessyear,fo_typebank,fo_checkbox1,fo_checkbox2,fo_checkbox3,fo_checkbox4,fo_prefix,fo_fNameTH,fo_lNameTH,fo_birthDay,fo_birthMonth,fo_birthYear,fo_refID,fo_mobilePhone,fo_email,fo_availableTime,fo_job,fo_salary,fo_yearOfService,fo_monthOfService,fo_bureauPaidedStatusPaid,fo_propertyProjectName,fo_province,fo_amphur,fo_district,fo_Radio,fo_date)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)  ");
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
			prepared.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

	}
}
