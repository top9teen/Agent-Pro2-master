package com.test.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.Bean.ReceiptBean;
import com.test.util.ConnectDB;

@Repository
public class TransferDao {

	
	public List<ReceiptBean> Trens () throws SQLException{
		List<ReceiptBean>  list = new ArrayList<>();
		ReceiptBean bean  = new ReceiptBean();
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		Connection conn = con.openConnect();
		

		try {
			sql.append(" SELECT * FROM  receipt  ");
			prepared = conn.prepareStatement(sql.toString());
	

			ResultSet rs = prepared.executeQuery();
			while (rs.next()) {
				bean = new ReceiptBean();
				bean.setReName(rs.getString("re_name"));
				bean.setReEmail(rs.getString("re_email"));
				bean.setReDay(rs.getInt("re_day"));
				bean.setReMont(rs.getString("re_mont"));
				bean.setReYrar(rs.getInt("re_year"));
				bean.setReMonny(rs.getString("re_monny"));
				bean.setReBank(rs.getString("re_bank"));
				bean.setReAdmin(rs.getString("re_admin"));
				bean.setReCaryear(rs.getString("re_caryear"));
				bean.setReIdga(rs.getInt("re_idGa"));
				bean.setReCar(rs.getString("re_car"));
				bean.setReCarmodel(rs.getString("re_carmodel"));
				list.add(bean);
			}

	}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		
		return list  ; 
	}
}
