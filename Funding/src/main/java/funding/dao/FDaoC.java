package funding.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import funding.dto.FDtoNotice;

public class FDaoC {
	DataSource dataSource;

	public FDaoC() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/funding_system");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// constructor

	public String login(String id, String pw) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		String customer_id = null;
		try {
			connection = dataSource.getConnection();
			String query = "SELECT customer_id FROM customer WHERE customer_id = ? AND customer_pw = ?";
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, id);
			preparedstatement.setString(2, pw);
			resultset = preparedstatement.executeQuery();
			
			if(resultset.next()) {
				customer_id = resultset.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) connection.close();
				if (preparedstatement != null) preparedstatement.close();
				if (resultset != null) resultset.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return customer_id;

	}//login

	public void signUp(String customer_id, String customer_pw, String customer_name, 
			String customer_phone, String customer_pw_q, String customer_pw_a) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		try {
			connection = dataSource.getConnection();
			String query = "INSERT INTO customer(customer_id, customer_pw, customer_name, customer_phone, customer_pw_q, customer_pw_a) "
					+ "values(?, ?, ?, ?, ?, ?)";
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, customer_id);
			preparedstatement.setString(2, customer_pw);
			preparedstatement.setString(3, customer_name);
			preparedstatement.setString(4, customer_phone);
			preparedstatement.setString(5, customer_pw_q);
			preparedstatement.setString(6, customer_pw_a);
			preparedstatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) connection.close();
				if (preparedstatement != null) preparedstatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}//signup
	public void addAddress(String customer_id, String address1, String address2, String address3) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		try {
			connection = dataSource.getConnection();
			String query = "INSERT INTO address (address_customer, address_state, address_city, address_line) "
					+ "values(?, ?, ?, ?)";
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, customer_id);
			preparedstatement.setString(2, address1);
			preparedstatement.setString(3, address2);
			preparedstatement.setString(4, address3);
			preparedstatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) connection.close();
				if (preparedstatement != null) preparedstatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}//addAddress
	public ArrayList<FDtoNotice> notice_list() {
		ArrayList<FDtoNotice> list = new ArrayList<FDtoNotice>();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			connection = dataSource.getConnection();
			String query = "SELECT notice_num, notice_title, notice_At FROM notice";
			preparedstatement = connection.prepareStatement(query);
			resultset = preparedstatement.executeQuery();
			
			while(resultset.next()) {
				int notice_num = resultset.getInt(1);
				String notice_title = resultset.getString(2);
				Timestamp notice_At = resultset.getTimestamp(3);
				
				FDtoNotice dto = new FDtoNotice(notice_num, notice_title, notice_At);
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) connection.close();
				if (preparedstatement != null) preparedstatement.close();
				if (resultset != null) resultset.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}//notice_list
	
	public FDtoNotice notice_detail(String num) {
		FDtoNotice dto = null;
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			connection = dataSource.getConnection();
			String query = "SELECT * FROM notice WHERE notice_num = ?";
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, num);
			resultset = preparedstatement.executeQuery();
			
			while(resultset.next()) {
				int notice_num = resultset.getInt(1);
				String notice_admin = resultset.getString(2);
				String notice_title = resultset.getString(3);
				String notice_content = resultset.getString(4);
				Timestamp notice_At = resultset.getTimestamp(5);
				
				dto = new FDtoNotice(notice_num, notice_admin, notice_title, notice_content, notice_At);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) connection.close();
				if (preparedstatement != null) preparedstatement.close();
				if (resultset != null) resultset.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
	public String findId(String name, String phone) {
		String Id = null;
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			connection = dataSource.getConnection();
			String query = "SELECT customer_id FROM customer WHERE customer_name = ? AND customer_phone = ?";
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, name);
			preparedstatement.setString(2, phone);
			resultset = preparedstatement.executeQuery();
			
			if(resultset.next()) {
				Id = resultset.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) connection.close();
				if (preparedstatement != null) preparedstatement.close();
				if (resultset != null) resultset.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return Id;
	}
}
