package funding.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import funding.dto.FDtoC;

public class FDaoA {
	DataSource dataSource;

	public FDaoA() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/funding_system");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//constructor
	
	
	// AlogIn
	public String AlogIn(String aid, String apw) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String aId = null;

		try {
			connection = dataSource.getConnection();
			String query = "select admin_id from admin where admin_id = ? AND admin_pw = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, aid);
			preparedStatement.setString(2, apw);

			
			resultSet = preparedStatement.executeQuery();
			System.out.println("4");

			if(resultSet.next()) {
				aId = resultSet.getString("admin_id");
			}


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}


		return aId;

	} //AlogIn end
	
	
	//clist
	public ArrayList<FDtoC> clist(String aId) {
		//clist
		
		ArrayList<FDtoC> dtos = new ArrayList<FDtoC>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select customer_id, customer_name, customer_phone from customer where customer_id = ? ORDER BY lIsimportant desc";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, aId);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				String customer_id = resultSet.getString("customer_id"); 
				String customer_name = resultSet.getString("customer_name"); 
				String customer_phone = resultSet.getString("customer_phone"); 

				FDtoC dto01 = new FDtoC(customer_id, customer_name, customer_phone);
				
				dtos.add(dto01);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	} //clist end
	
	
	
	
	
	
	
}
