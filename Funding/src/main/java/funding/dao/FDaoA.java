package funding.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import funding.dto.FDtoC;
import funding.dto.FDtoSeller;

public class FDaoA {
	DataSource dataSource;

	public FDaoA() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/funding_system");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// constructor

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

			if (resultSet.next()) {
				aId = resultSet.getString("admin_id");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return aId;

	} // AlogIn end

	// clist
	public ArrayList<FDtoC> clist(String aId) {
		// clist

		ArrayList<FDtoC> dtos = new ArrayList<FDtoC>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "select customer_id, customer_name, customer_phone, address_state, address_city, address_line from customer, address where customer.customer_id = address.address_id";

			preparedStatement = connection.prepareStatement(query);
			// preparedStatement.setString(1, "1");
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String customer_id = resultSet.getString("customer_id");
				String customer_name = resultSet.getString("customer_name");
				String customer_phone = resultSet.getString("customer_phone");
				String address_state = resultSet.getString("address_state");
				String address_city = resultSet.getString("address_city");
				String address_line = resultSet.getString("address_line");

				FDtoC dto01 = new FDtoC(customer_id, customer_name, customer_phone, address_state, address_city,
						address_line);

				dtos.add(dto01);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	} // clist end

	// sellerapplylist

	public ArrayList<FDtoSeller> sellerapplylist(String aId) {

		ArrayList<FDtoSeller> dtos = new ArrayList<FDtoSeller>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "SELECT * FROM seller WHERE seller_state NOT IN ('승인')";

			preparedStatement = connection.prepareStatement(query);
			// preparedStatement.setString(1, "1");
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String seller_id = resultSet.getString("seller_id");
				String seller_license = resultSet.getString("seller_license");
				String seller_number = resultSet.getString("seller_number");
				String seller_profile = resultSet.getString("seller_profile");
				String seller_person_name = resultSet.getString("seller_person_name");
				String seller_person_phone = resultSet.getString("seller_person_phone");
				String seller_state = resultSet.getString("seller_state");

				System.out.println(seller_id);
				System.out.println(seller_license);

				FDtoSeller dto02 = new FDtoSeller(seller_id, seller_license, seller_number, seller_profile, seller_person_name, seller_person_phone, seller_state);

				dtos.add(dto02);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	} // sellerapplylist end
	
	
	
	
	
	//seller Qualify
	public void sellerqualify(String seller_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;


		try {
			connection = dataSource.getConnection();
			String query = "UPDATE seller_state SET lContent = ? Where seller_id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, "승인");
			preparedStatement.executeUpdate();

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {

				if(preparedStatement!=null) preparedStatement.close();
				if(connection!=null) connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}//modify
	
	
	
	
	
	

}
