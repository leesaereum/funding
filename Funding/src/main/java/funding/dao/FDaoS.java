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
	}//constructor

	
	//ssignUp --> sign up for seller
	public void ssignUp(String seller_id, String seller_pw, String seller_pw2, String seller_number, String seller_profile, String seller_name
			           , String seller_phone, String seller_person_name, String seller_person_phone) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into seller (seller_id, seller_pw, seller_number, seller_profile, seller_name "
					       + ", seller_phone, seller_person_name, seller_person_phone, seller_state) values (?, ?, ?, ?, ?, ?, ?, ?, "+
					"'승인대기'"+")";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, seller_id);
			preparedStatement.setString(2, seller_pw);
			preparedStatement.setString(3, seller_number);
			preparedStatement.setString(4, seller_profile);
			preparedStatement.setString(5, seller_name);
			preparedStatement.setString(6, seller_phone);
			preparedStatement.setString(7, seller_person_name);
			preparedStatement.setString(8, seller_person_phone);

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
	public String slogin(String id, String pw) {
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
		
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				seller_id = resultSet.getString("seller_id");
			}
			
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