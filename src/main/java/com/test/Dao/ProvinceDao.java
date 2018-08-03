package com.test.Dao;

import org.springframework.stereotype.Repository;

import com.test.Bean.AmphurBean;
import com.test.Bean.DistrictBean;
import com.test.Bean.ProvinceBean;
import com.test.util.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ProvinceDao {
	public List<ProvinceBean> findallProvince() throws SQLException{
		ProvinceBean bean = new ProvinceBean();
		List<ProvinceBean> list = new ArrayList<>();
//		query master data
		
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		Connection conn = con.openConnect();

		try {
			sql.append(" SELECT PROVINCE_NAME,PROVINCE_ID FROM province ");
			prepared = conn.prepareStatement(sql.toString());
			ResultSet rs = prepared.executeQuery();

			while (rs.next()) {
				bean = new ProvinceBean();
				bean.setProvinceName(rs.getString("PROVINCE_NAME"));
				bean.setProvinceId(rs.getInt("PROVINCE_ID"));
				list.add(bean);
		
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			conn.close();
		}
		
		return list ;
	}
	
public List<AmphurBean> findAllaumhur(int xxx)  throws SQLException {
		
	AmphurBean bean = new AmphurBean();
		List<AmphurBean> list = new ArrayList<AmphurBean>();
//		query master data
		
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		Connection conn = con.openConnect();

		try {
			sql.append(" SELECT * FROM amphur  WHERE PROVINCE_ID = ?  ");
			prepared = conn.prepareStatement(sql.toString());
			prepared.setInt(1,xxx);
			ResultSet rs = prepared.executeQuery();

			while (rs.next()) {
				bean = new AmphurBean();
				bean.setAmphurName(rs.getString("AMPHUR_NAME"));
				bean.setAmphurId(rs.getInt("AMPHUR_ID"));
				list.add(bean);
		
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			conn.close();
		}
		return list;
	}
public List<DistrictBean> findAlldistrict(int xxx) throws SQLException {
	
	DistrictBean bean = new DistrictBean();
		List<DistrictBean> list = new ArrayList<DistrictBean>();
//		query master data
		
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		Connection conn = con.openConnect();


		try {
			sql.append(" SELECT * FROM district  WHERE AMPHUR_ID = ?  ");
			prepared = conn.prepareStatement(sql.toString());
			prepared.setInt(1,xxx);
			ResultSet rs = prepared.executeQuery();

			while (rs.next()) {
				bean = new DistrictBean();
				bean.setDistrictName(rs.getString("DISTRICT_NAME"));
				bean.setDistrictId(rs.getInt("DISTRICT_ID"));
				list.add(bean);
		
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			conn.close();
		}
		return list;
	}

//end class
}
