package com.test.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.test.BankBean.KrungsriPriceBean;
import com.test.util.KrungsriDB;



@Repository
public class KrungsriServer {


	// krungsri_price
	public KrungsriPriceBean checkpricekr(String carYear, String carMake2) throws SQLException {
		KrungsriPriceBean krbean = new KrungsriPriceBean();
		KrungsriDB con = new KrungsriDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		Connection conn = con.openConnect();
		try {
			sql.append(" SELECT * FROM krungsri_price WHERE  ye_year= ? and br_name= ? ");
			prepared = conn.prepareStatement(sql.toString());
			prepared.setString(1, carYear);
			prepared.setString(2, carMake2);
			ResultSet rs = prepared.executeQuery();
			while (rs.next()) {
				krbean.setKrPrice(rs.getInt("kr_price"));
				krbean.setKrPrice(rs.getInt("kr_price"));
			}
		} catch (Exception e) {

			// TODO: handle exception
		}
		finally {
			conn.close();
		}
		return krbean;

	}
	
}
