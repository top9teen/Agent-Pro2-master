package com.test.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.test.Bean.LoginBeanSimple;
import com.test.util.ConnectDB;

@Repository
public class RegisterDao {

	public void register (LoginBeanSimple beansim) throws SQLException{
		
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		Connection conn = con.openConnect();
		
		try {
			sql.append(" INSERT INTO UserTable (lo_email,lo_password,lo_status)VALUES(?,?,'2') ");
			prepared = conn.prepareStatement(sql.toString());
			prepared.setString(1,beansim.getEmail());
			prepared.setString(2,beansim.getPassword());
			prepared.executeUpdate();
			

	}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		
		
	}
}
