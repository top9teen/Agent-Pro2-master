package com.test.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.Bean.BrandBean;
import com.test.Bean.CarBean;
import com.test.Bean.SimBean;
import com.test.Bean.YearBean;
import com.test.util.ConnectDB;

@Repository
public class SearchCarDao {
	public CarBean brand(SimBean si ) throws SQLException {
		CarBean bean = new CarBean();
		ConnectDB con = new ConnectDB();
		Connection conn = con.openConnect();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
	
		try {
			sql.append(" SELECT * FROM car WHERE  ye_year = ? and car_name = ? ");
			prepared = conn.prepareStatement(sql.toString());
			prepared.setString(1, si.getMyYear());
			prepared.setString(2, si.getMycar());
			ResultSet rs = prepared.executeQuery();

			while (rs.next()) {
				bean.setCarName(rs.getString("car_name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			conn.close();
		}
		

		return bean;
	}

	public BrandBean model1(SimBean si) throws SQLException {
		BrandBean bean = new BrandBean();
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		Connection conn = con.openConnect();
		
		try {
			sql.append(" SELECT * FROM brand WHERE  ye_year = ?  and br_name = ?  ");
			prepared = conn.prepareStatement(sql.toString());
			prepared.setString(1, si.getMyYear());
			prepared.setString(2, si.getName());
			ResultSet rs = prepared.executeQuery();
			

			while (rs.next()) {
			
				bean.setBrName(rs.getString("br_name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			conn.close();
		}

		return bean;
	}
	public YearBean year1(SimBean si) throws SQLException{
		YearBean bean = new YearBean();
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		Connection conn = con.openConnect();
		try {
			sql.append(" SELECT * FROM year WHERE  ");
			prepared = conn.prepareStatement(sql.toString());
			prepared.setString(1, si.getMyYear());
			ResultSet rs = prepared.executeQuery();
			while (rs.next()) {
				bean.setYeYear(rs.getString("ye_year"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		finally {
			conn.close();
		}
		return bean;
	}
	
	public List<YearBean> findAll() throws SQLException{
		
		YearBean bean = new YearBean();
		List<YearBean> list = new ArrayList<YearBean>();
//		query master data
		
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		Connection conn = con.openConnect();

		try {
			sql.append(" SELECT * FROM year ");
			prepared = conn.prepareStatement(sql.toString());
			ResultSet rs = prepared.executeQuery();

			while (rs.next()) {
				bean = new YearBean();
				bean.setYeYear(rs.getString("ye_year"));
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
	public List<CarBean> findAll(String year) throws SQLException {
		
		CarBean bean = new CarBean();
		List<CarBean> list = new ArrayList<CarBean>();
//		query master data
		
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		Connection conn = con.openConnect();

		try {
			sql.append(" SELECT * FROM car  WHERE ye_year = ?  ");
			prepared = conn.prepareStatement(sql.toString());
			prepared.setString(1,year);
			ResultSet rs = prepared.executeQuery();

			while (rs.next()) {
				bean = new CarBean();
				bean.setCarName(rs.getString("car_name"));
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
public List<BrandBean> findAll(String year ,String brand) throws SQLException {
		
	BrandBean bean = new BrandBean();
		List<BrandBean> list = new ArrayList<BrandBean>();
//		query master data
		
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		Connection conn = con.openConnect();

		try {
			sql.append(" SELECT * FROM brand WHERE ye_year = ? AND car_name = ?  ");
			prepared = conn.prepareStatement(sql.toString());
			prepared.setString(1,year);
			prepared.setString(2,brand);
			ResultSet rs = prepared.executeQuery();

			while (rs.next()) {
				bean = new BrandBean();
				bean.setBrName(rs.getString("br_name"));
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
