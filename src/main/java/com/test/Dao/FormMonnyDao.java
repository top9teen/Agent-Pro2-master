package com.test.Dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


import com.test.Bean.GatherBean;
import com.test.Bean.ReceiptBean;
import com.test.util.ConnectDB;
import com.test.util.KasikornDB;

@Repository
public class FormMonnyDao {

	public List<GatherBean> branddd(String email,int M ,int D) throws SQLException {
		
		
		GatherBean bean = new GatherBean();
		List<GatherBean> list = new ArrayList<>();
		KasikornDB con = new KasikornDB();
		Connection conn = con.openConnect();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
	
		try {
			sql.append(" SELECT * FROM gather WHERE  ga_email = ? and ga_mont = ? ");
			prepared = conn.prepareStatement(sql.toString());
			prepared.setString(1, email);
			prepared.setInt(2, M);
			
			ResultSet rs = prepared.executeQuery();

			while (rs.next()) {
				
				bean = new GatherBean();
			if(D <= 27) {
					bean.setGaId(rs.getInt("ga_id"));
					bean.setGaName(rs.getString("ga_name"));
					bean.setGaCar(rs.getString("ga_car"));
					bean.setGaFistPeriod(rs.getInt("ga_fistPeriod"));
					bean.setGaLastPeriod(rs.getInt("ga_lastPeriod"));
					bean.setGaEmail(rs.getString("ga_email"));
					bean.setGaPrie(rs.getInt("ga_prie"));
					bean.setGaDay(rs.getInt("ga_day"));
					bean.setGaMont(rs.getInt("ga_mont"));
					bean.setGayear(rs.getInt("ga_year"));
					bean.setGaUser(rs.getInt("ga_user"));
					
					list.add(bean);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			conn.close();
		}
		

		return list;
	}

	
public GatherBean vss(int a) throws SQLException {
		
		
		GatherBean bean = new GatherBean();
		KasikornDB con = new KasikornDB();
		Connection conn = con.openConnect();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
	
		try {
			sql.append(" SELECT * FROM gather WHERE  ga_id = ? ");
			prepared = conn.prepareStatement(sql.toString());
			prepared.setInt(1, a);
			
			ResultSet rs = prepared.executeQuery();

			while (rs.next()) {
				
				bean = new GatherBean();
			
					bean.setGaId(rs.getInt("ga_id"));
					bean.setGaName(rs.getString("ga_name"));
					bean.setGaCar(rs.getString("ga_car"));
					bean.setGaFistPeriod(rs.getInt("ga_fistPeriod"));
					bean.setGaLastPeriod(rs.getInt("ga_lastPeriod"));
					bean.setGaEmail(rs.getString("ga_email"));
					bean.setGaPrie(rs.getInt("ga_prie"));
					bean.setGaDay(rs.getInt("ga_day"));
					bean.setGaMont(rs.getInt("ga_mont"));
					bean.setGayear(rs.getInt("ga_year"));
					bean.setGaUser(rs.getInt("ga_user"));
					
					
				}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			conn.close();
		}
		

		return bean;
	}
public void sot(int m,int n,int a,int p) throws SQLException {
	
	
	
	KasikornDB con = new KasikornDB();
	Connection conn = con.openConnect();
	PreparedStatement prepared = null;
	StringBuilder sql = new StringBuilder();

	try {
		sql.append(" UPDATE gather SET ga_mont = ? , ga_year = ? , ga_fistPeriod = ? WHERE  ga_id = ? ");
		prepared = conn.prepareStatement(sql.toString());
		
		prepared.setInt(1, m);
		prepared.setInt(2, n);
		prepared.setInt(3, p);
		prepared.setInt(4, a);
		
		prepared.executeUpdate();

				
				
			
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	finally {
		conn.close();
	}
	
}

public void msaw(ReceiptBean bean) throws SQLException{
	ConnectDB con = new ConnectDB();
	PreparedStatement prepared = null;
	StringBuilder sql = new StringBuilder();
	Connection conn = con.openConnect();
	try {
		sql.append("INSERT INTO receipt(re_name,re_email,re_day,re_mont,re_year,re_monny,re_bank,re_admin,re_idga) VALUES(?,?,?,?,?,?,?,?,?)");
		prepared = conn.prepareStatement(sql.toString());
		prepared.setString(1, bean.getReName());
		prepared.setString(2, bean.getReEmail());
		prepared.setInt(3, bean.getReDay());
		prepared.setString(4, bean.getReMont());
		prepared.setInt(5, bean.getReYrar());
		prepared.setString(6, bean.getReMonny());
		prepared.setString(7, bean.getReBank());
		prepared.setString(8, bean.getReAdmin());
		prepared.setInt(9, bean.getReIdga());
		prepared.executeUpdate();

	} catch (Exception e) {
		// TODO: handle exception
	}
	finally {
		conn.close();
	}

}

	// end class
	
}
