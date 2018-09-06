package com.test.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.Bean.LoginBean;
import com.test.Bean.LoginBeanSimple;
import com.test.util.ConnectDB;
import com.test.util.KasikornDB;

@Repository
public class LoginDao {

	public LoginBean login (LoginBeanSimple beansim) throws SQLException{
		LoginBean bean = new LoginBean();
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		Connection conn = con.openConnect();
		
		try {
			sql.append(" SELECT * FROM  usertable WHERE lo_email = ? AND lo_password = ? ");
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
	
	
	
	public LoginBean loginfas (LoginBeanSimple beansim) throws SQLException{
		LoginBean bean = new LoginBean();
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		Connection conn = con.openConnect();
		
		try {
			sql.append(" SELECT * FROM  usertable WHERE lo_email = ? ");
			prepared = conn.prepareStatement(sql.toString());
			prepared.setString(1,beansim.getEmail());
		

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
	
	public List<LoginBean> login22 () throws SQLException{
		LoginBean bean = new LoginBean();
		List<LoginBean> list  = new ArrayList<LoginBean>();
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		Connection conn = con.openConnect();
		
		try {
			sql.append(" SELECT * FROM  usertable ");
			prepared = conn.prepareStatement(sql.toString());
			

			ResultSet rs = prepared.executeQuery();
			while (rs.next()) {
				bean = new LoginBean();
				bean.setLoStatus(rs.getString("lo_status"));
				if(bean.getLoStatus().equals("1")) {
					
				}
				else {
					bean.setLoEmail(rs.getString("lo_email"));
					bean.setLoPassword(rs.getString("lo_password"));
					bean.setLoStatus(rs.getString("lo_id"));
					bean.setLoStatus(rs.getString("lo_status"));
					list.add(bean);
				}
			
			}

	}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		
		return list ;
	}
	
	public void sssser21(String email , String repass) throws SQLException {

		KasikornDB con = new KasikornDB();
		Connection conn = con.openConnect();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();

		try {
			sql.append(" UPDATE usertable SET ga_mont = ? , ga_year = ? , ga_fistPeriod = ? WHERE  ga_id = ? ");
			prepared = conn.prepareStatement(sql.toString());

			prepared.setString(1, email);
			prepared.setString(2, repass);

			prepared.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			conn.close();
		}

	}

	//End Class
}
