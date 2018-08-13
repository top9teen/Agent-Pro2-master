package com.test.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.test.BankBean.ThanachartPriceBean;
import com.test.util.ThanachartDB;


@Repository
public class ThanachartServer {

	// thanachart_price
		public ThanachartPriceBean checkpriceth(String carYear, String carMake2) throws SQLException  {
			ThanachartPriceBean thbean = new ThanachartPriceBean();
			ThanachartDB con = new ThanachartDB();
			PreparedStatement prepared = null;
			StringBuilder sql = new StringBuilder();
			Connection conn = con.openConnect();
			try {
				sql.append(" SELECT * FROM thanachart_price WHERE  ye_year= ? and br_name= ? ");
				prepared = conn.prepareStatement(sql.toString());
				prepared.setString(1, carYear);
				prepared.setString(2, carMake2);
				ResultSet rs = prepared.executeQuery();
				while (rs.next()) {
					thbean.setThPrice(rs.getInt("th_price"));
				}
			} catch (Exception e) {

				// TODO: handle exception
			}
			finally {
				conn.close();
			}
			return thbean;
		}

}
