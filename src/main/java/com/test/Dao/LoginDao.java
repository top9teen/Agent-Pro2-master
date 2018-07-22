package com.test.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.test.Bean.LoginBean;
import com.test.Bean.LoginBeanSimple;
import com.test.util.ConnectDB;

@Repository
public class LoginDao {

	public LoginBean login (LoginBeanSimple beansim) throws SQLException{
		LoginBean bean = new LoginBean();
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		Connection conn = con.openConnect();
		
		try {
			sql.append(" SELECT * FROM  UserTable WHERE lo_email = ? AND lo_password = ? ");
			prepared = conn.prepareStatement(sql.toString());
			prepared.setString(1,beansim.getEmail());
			prepared.setString(2,beansim.getPassword());

			ResultSet rs = prepared.executeQuery();
			while (rs.next()) {
			bean.setLoEmail(rs.getString("lo_email"));
			bean.setLoPassword(rs.getString("lo_password"));
			bean.setLoStatus(rs.getString("lo_id"));
			bean.setLoStatus(rs.getString("lo_status"));
			}

	}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		
		return bean ;
	}
	//End Class
}
