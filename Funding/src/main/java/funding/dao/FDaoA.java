package funding.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import funding.dto.FDtoC;
import funding.dto.FDtoCalculate;
import funding.dto.FDtoFunding;
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

				FDtoC dto01 = new FDtoC(customer_id, customer_name, customer_phone, address_state, address_city, address_line);

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
	} //list end

	// sellerapplylist

	public ArrayList<FDtoSeller> sellerapplylist() {

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
				String seller_name = resultSet.getString("seller_name");
				String seller_phone = resultSet.getString("seller_phone");
				String seller_person_name = resultSet.getString("seller_person_name");
				String seller_person_phone = resultSet.getString("seller_person_phone");
				String seller_state = resultSet.getString("seller_state");
				
				FDtoSeller dto02 = new FDtoSeller(seller_id, seller_license, seller_number, seller_profile, seller_name, seller_phone, seller_person_name, seller_person_phone, seller_state);

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

	// seller Qualify
	public FDtoSeller sellerqualify(String seller_Id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		FDtoSeller dto = null;

		try {
			connection = dataSource.getConnection();
			String query = "UPDATE seller SET seller_state = '승인' Where seller_id = ?";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, seller_Id);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}// seller Qualify end
	
	
	// seller reject
	public FDtoSeller sellerreject(String seller_Id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		FDtoSeller dto = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "UPDATE seller SET seller_state = '반려' Where seller_id = ?";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, seller_Id);
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}// seller reject end
	
	
	
	// fapprovewaitlist

	public ArrayList<FDtoFunding> fapprovewaitlist() {

		ArrayList<FDtoFunding> dtos = new ArrayList<FDtoFunding>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "SELECT funding_num, funding_seller, funding_title, funding_state FROM funding WHERE funding_state NOT IN ('승인')";

			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int funding_num = resultSet.getInt("funding_num");
				String funding_seller = resultSet.getString("funding_seller");
				String funding_title = resultSet.getString("funding_title");
				String funding_state = resultSet.getString("funding_state");

				FDtoFunding dto03 = new FDtoFunding(funding_num, funding_seller, funding_title, funding_state);

				dtos.add(dto03);
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
	} // fapprovewaitlist end
	
	
	
	// fundingapprove
	public FDtoFunding fundingapprove(String funding_num) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		FDtoFunding dto = null;

		try {
			connection = dataSource.getConnection();
			String query = "UPDATE funding SET funding_state = '승인' Where funding_num = ?";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, funding_num);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}// fundingapprove end
	
	// fundingreject
	public FDtoFunding fundingreject(String funding_num) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		FDtoFunding dto = null;

		try {
			connection = dataSource.getConnection();
			String query = "UPDATE funding SET funding_state = '반려' Where funding_num = ?";
			System.out.println(funding_num);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, funding_num);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}// fundingreject end
	
	
	
	//calculate approve wait list
	
	public ArrayList<FDtoCalculate> calapprovewaitlist() {

		ArrayList<FDtoCalculate> dtos = new ArrayList<FDtoCalculate>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "SELECT calculate_num, calculate_funding, calculate_seller, calculate_cost, calculate_state FROM calculate WHERE calculate_state NOT IN ('승인')";

			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int calculate_num = resultSet.getInt("calculate_num");
				int calculate_funding = resultSet.getInt("calculate_funding");
				String calculate_seller = resultSet.getString("calculate_seller");
				int calculate_cost = resultSet.getInt("calculate_cost");
				String calculate_state = resultSet.getString("calculate_state");

				FDtoCalculate dto04 = new FDtoCalculate(calculate_num, calculate_funding, calculate_seller, calculate_cost, calculate_state);

				dtos.add(dto04);
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
	} // calculate approve wait list end
	
	
	
	
	// calculate approve 
	public FDtoCalculate calapprove(String calculate_num) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		FDtoCalculate dto = null;

		try {
			connection = dataSource.getConnection();
			String query = "UPDATE calculate SET calculate_state = '승인' Where calculate_num = ?";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, calculate_num);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}// calculate approve end
	
	
	
	//calculate reject
	
	public FDtoCalculate calreject(String calculate_num) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		FDtoCalculate dto = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "UPDATE calculate SET calculate_state = '반려' Where calculate_num = ?";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, calculate_num);
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}// calculate reject end
	

	

}
