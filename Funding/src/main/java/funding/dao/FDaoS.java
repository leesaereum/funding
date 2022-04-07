package funding.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import funding.dto.FDtoFundingQuestion;

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
	
	
	public void fundingDataInsert(String funding_seller, String funding_banner, String funding_title, Date funding_openAt, Date funding_closeAt, int funding_purpose, String funding_category, int funding_fee) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "INSERT INTO funding (funding_seller, funding_banner, funding_title, funding_openAt, funding_closeAt, funding_purpose, funding_category, funding_fee) values(?, ?, ?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, funding_seller);
			preparedStatement.setString(2, funding_banner);
			preparedStatement.setString(3, funding_title);
			preparedStatement.setDate(4, funding_openAt);
			preparedStatement.setDate(5, funding_closeAt);
			preparedStatement.setInt(6, funding_purpose);
			preparedStatement.setString(7, funding_category);
			preparedStatement.setInt(8, funding_fee);
			
	
	
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		
	}//fundingDataInsert
	
	public int funding_num(String funding_title) {
		//list
		
		Integer funding_num = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select funding_num from funding where funding_title = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, funding_title);

			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
		
				int get_funding_num = resultSet.getInt("funding_num"); 
		
				
				funding_num = get_funding_num;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();;
			}
		}
		return funding_num;
	} //funding_num end
	
	
	
public void optionDataInsert(int option_numbering, String option_name, int option_price, int option_amount, int option_funding) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "INSERT INTO funding_option (option_numbering, option_name, option_price, option_amount, option_funding) values(?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, option_numbering);
			preparedStatement.setString(2, option_name);
			preparedStatement.setInt(3, option_price);
			preparedStatement.setInt(4, option_amount);
			preparedStatement.setInt(5, option_funding);
		
	
	
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	
}

public void fundingContentInsert(int funding_num, String funding_content) {
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	
	try {
		connection = dataSource.getConnection();
		String query = "INSERT INTO funding_content (content_funding, content_content) values(?, ?)";
		preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setInt(1, funding_num);
		preparedStatement.setString(2, funding_content);
	
	

		preparedStatement.executeUpdate();
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally {
		try {
			if(preparedStatement != null) preparedStatement.close();
			if(connection != null) connection.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}



}