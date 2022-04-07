package funding.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import funding.dto.FDtoFunding;
import funding.dto.FDtoFundingOption;
import funding.dto.FDtoFundingQuestion;
import funding.dto.FDtoOrder;

import java.sql.Timestamp;

public class FDaoC {
	DataSource dataSource;

	public FDaoC() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/funding_system");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//constructor
	
	//그냥 펀딩정보
	public ArrayList<FDtoFunding> list(String funding_num) {
		//list
		
		ArrayList<FDtoFunding> FDtoFunding = new ArrayList<FDtoFunding>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select funding_title, funding_openAt, funding_closeAt, funding_purpose, content_content from funding, funding_content where funding_num = ? and content_funding = ? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, funding_num);
			preparedStatement.setString(2, funding_num);
	
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
		
				String funding_title = resultSet.getString("funding_title"); 
				Timestamp funding_openAt = resultSet.getTimestamp("funding_openAt"); 
				Timestamp funding_closeAt = resultSet.getTimestamp("funding_closeAt"); 
				int funding_purpose = resultSet.getInt("funding_purpose"); 
				String content_content = resultSet.getString("content_content");
				
//				String option_name = resultSet.getString("option_name");
//				int option_price = resultSet.getInt("option_price");
//				int option_amount = resultSet.getInt("option_amount");
//		
				
				
				FDtoFunding dto1 = new FDtoFunding(funding_title, funding_openAt, funding_closeAt, funding_purpose, content_content);
				
				FDtoFunding.add(dto1);
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
		return FDtoFunding;
	} //list end
	
	public ArrayList<FDtoFundingOption> optionList(String funding_num) {
		//list
		
		ArrayList<FDtoFundingOption> FDtoFundingOption = new ArrayList<FDtoFundingOption>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select option_name, option_price, option_amount from funding_option where option_funding = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, funding_num);

			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
		
				String option_name = resultSet.getString("option_name"); 
				int option_price = resultSet.getInt("option_price"); 
				int option_amount = resultSet.getInt("option_amount"); 
		
			

				FDtoFundingOption dto2 = new FDtoFundingOption(option_name, option_price, option_amount);
				FDtoFundingOption.add(dto2);
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
		return FDtoFundingOption;
	} //optionlist end
	
	
	//
	public ArrayList<FDtoFundingQuestion> questionList(String funding_num) {
		//list
		
		ArrayList<FDtoFundingQuestion> FDtoFundingQuestion = new ArrayList<FDtoFundingQuestion>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select question_customer, question_title, question_content, question_at, question_answer from funding_question where question_funding = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, funding_num);

			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
		
				String question_customer = resultSet.getString("question_customer"); 
				String question_title = resultSet.getString("question_title"); 
				String question_content = resultSet.getString("question_content"); 
				Timestamp question_at = resultSet.getTimestamp("question_at"); 
				String question_answer = resultSet.getString("question_answer"); 
		
		
				FDtoFundingQuestion dto3 = new FDtoFundingQuestion(question_customer, question_title, question_content, question_at, question_answer);
				
				FDtoFundingQuestion.add(dto3);
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
		return FDtoFundingQuestion;
	} //optionlist end
	
	
	public void likeInsert(String like_customer, int like_funding, Date like_at) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into funding_like (like_customer, like_funding, like_At) values (?, ?, ?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, like_customer);
			preparedStatement.setInt(2, like_funding);
			preparedStatement.setDate(3, like_at);
	
	
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
	}//likeInsert
	
	public void OrderInsert(String order_customer, int order_funding, int order_option, int order_price, 
			int order_count, int order_address) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "INSERT INTO order1 (order_customer, order_funding, order_option, order_price, order_count, order_At, order_address) values(?, ?, ?, ?, ?, now(), ?)";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, order_customer);
			preparedStatement.setInt(2, order_funding);
			preparedStatement.setInt(3, order_option);
			preparedStatement.setInt(4, order_price);
			preparedStatement.setInt(5, order_count);
			preparedStatement.setInt(6, order_address);
	
	
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
	}//OrderInsert
	
	public ArrayList<FDtoOrder> orderList(String funding_num) {
		//list
		
		ArrayList<FDtoOrder> FDtoOrder = new ArrayList<FDtoOrder>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select distinct order_customer from order1 where order_funding = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, funding_num);

			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
		
				String order_customer = resultSet.getString("order_customer"); 
		
		
				FDtoOrder dtoorder = new FDtoOrder(order_customer);
				
				FDtoOrder.add(dtoorder);
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
		return FDtoOrder;
	} //optionlist end


}
