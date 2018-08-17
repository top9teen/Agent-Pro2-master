package com.test.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.test.Bean.AmphurBean;
import com.test.Bean.DistrictBean;
import com.test.Bean.ProvinceBean;
import com.test.util.ConnectDB;

@Repository
public class CkDao {
	public ProvinceBean province(int a) throws SQLException{
		ProvinceBean bean = new ProvinceBean();
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		Connection conn = con.openConnect();
		
		try {
			sql.append(" SELECT * FROM province WHERE PROVINCE_ID = ? ");
			prepared = conn.prepareStatement(sql.toString());
			prepared.setInt(1, a);
			ResultSet rs = prepared.executeQuery();
			while (rs.next()) {
				bean.setProvinceName(rs.getString("PROVINCE_NAME"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			conn.close();
		}
		
		return bean;
	}
	public AmphurBean amphur(int b) throws SQLException{
		AmphurBean bean = new AmphurBean();
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		Connection conn = con.openConnect();
		try {
			sql.append(" SELECT * FROM amphur WHERE AMPHUR_ID = ? ");
			prepared = conn.prepareStatement(sql.toString());
			prepared.setInt(1, b);
			ResultSet rs = prepared.executeQuery();
	
		while (rs.next()) {
			bean.setAmphurName(rs.getString("AMPHUR_NAME"));
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
		finally {
			conn.close();
		}
	
	return bean;
}

	public DistrictBean dis(int c) throws SQLException{
		DistrictBean bean = new DistrictBean();
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		Connection conn = con.openConnect();
		try {
			sql.append(" SELECT * FROM district WHERE DISTRICT_ID = ? ");
			prepared = conn.prepareStatement(sql.toString());
			prepared.setInt(1, c);
			ResultSet rs = prepared.executeQuery();
			while (rs.next()) {
				bean.setDistrictName(rs.getString("DISTRICT_NAME"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			conn.close();
		}
	return bean;
	}
	
	//end class
}
