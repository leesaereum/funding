package funding.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class FDaoS {
	DataSource dataSource;

	public FDaoS() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/funding_system");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//ssignUp --> sign up for seller
	public void ssignUp(String seller_id, String seller_pw, String seller_licence, String seller_number,
			String seller_phone, String seller_person_name, String seller_person_phone, String seller_state) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = " insert into seller (seller_id, seller_pw, seller_licence, seller_number, seller_phone "
					       + ", seller_person_name, seller_person_phone, seller_state) values(?, ?, ?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, seller_id);
			preparedStatement.setString(2, seller_pw);
			preparedStatement.setString(3, seller_licence);
			preparedStatement.setString(4, seller_number);
			preparedStatement.setString(5, seller_phone);
			preparedStatement.setString(6, seller_person_name);
			preparedStatement.setString(7, seller_person_phone);
			preparedStatement.setString(8, seller_state);

			preparedStatement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null ) preparedStatement.close();
				if(connection != null ) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}//ssignUp end
	
	//ssignIn --> sign In for seller 
	public String ssignIn(String id, String pw) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String seller_id = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select seller_id from seller where seller_id = ? AND seller_pw = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, pw);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null ) preparedStatement.close();
				if(connection != null ) connection.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return seller_id;
	}//ssignIn end
	
	
}