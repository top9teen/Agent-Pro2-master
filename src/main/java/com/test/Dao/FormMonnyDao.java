package com.test.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


import com.test.Bean.GatherBean;

import com.test.util.KasikornDB;

@Repository
public class FormMonnyDao {

	public List<GatherBean> branddd(String email,int M ,int D) throws SQLException {
		GatherBean bean = new GatherBean();
		List<GatherBean> list = new ArrayList<GatherBean>();
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
				bean.setGaDay(rs.getInt("ga_day"));
				if(D <= 5) {
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

}
