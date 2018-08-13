package com.test.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.test.BankBean.ScbeasyPriceBean;
import com.test.util.ScbeasyDB;



@Repository
public class ScbeasyServer {

	
	// scbeasy_price
		public ScbeasyPriceBean checkpricesc(String carYear, String carMake2) throws SQLException {
			ScbeasyPriceBean scbean = new ScbeasyPriceBean();
			ScbeasyDB con = new ScbeasyDB();
			PreparedStatement prepared = null;
			StringBuilder sql = new StringBuilder();
			Connection conn = con.openConnect();
			try {
				sql.append(" SELECT * FROM scbeasy_price WHERE  ye_year= ? and br_name= ? ");
				prepared = conn.prepareStatement(sql.toString());
				prepared.setString(1, carYear);
				prepared.setString(2, carMake2);
				ResultSet rs = prepared.executeQuery();
				while (rs.next()) {
					scbean.setScPrice(rs.getInt("sc_price"));
					scbean.setScPrice(rs.getInt("sc_price"));
					
				}
			} catch (Exception e) {

				// TODO: handle exception
			}
			finally {
				conn.close();
			}
			return scbean;
		}
}
