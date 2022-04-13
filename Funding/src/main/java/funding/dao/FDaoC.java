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

import funding.dto.FDtoFunding;
import funding.dto.FDtoFundingOption;
import funding.dto.FDtoFundingQuestion;
import funding.dto.FDtoNotice;
import funding.dto.FDtoOrder;
import funding.dto.FDtoSystemQuestion;

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
	
	public void leave(String id) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		try {
			connection = dataSource.getConnection();
			
			String query = "DELETE FROM address WHERE address_customer = ?";
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, id);
			preparedstatement.executeUpdate();
			
			if (preparedstatement != null) preparedstatement.close();
			
			query = "DELETE FROM customer WHERE customer_id = ?";
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, id);
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
	}

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
	
	public int myFundingCount(String id){
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		int count = 0;
		try {
			connection = dataSource.getConnection();
			String query = "SELECT count(funding_num) "
					+ "FROM funding as f "
					+ "where funding_num in (select order_funding from order1 where order_customer = ? )";
			
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, id);
			resultset = preparedstatement.executeQuery();
			if(resultset.next()) {
				count =  resultset.getInt(1);
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
		return count;
	}
	
	public int myLikeCount(String id){
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		int count = 0;
		try {
			connection = dataSource.getConnection();
			String query = "SELECT count(funding_num) "
					+ "FROM funding as f "
					+ "where funding_num in (select like_funding from funding_like l where l.like_customer = ?)";
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, id);
			resultset = preparedstatement.executeQuery();
			
			if(resultset.next()) {
				count =  resultset.getInt(1);
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
		return count;
	}
	
	public int mySystemQuestionCount(String id){
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		int count = 0;
		try {
			connection = dataSource.getConnection();
			String query = "SELECT count(question_num) FROM system_question where question_customer = ?";
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, id);
			resultset = preparedstatement.executeQuery();
			
			if(resultset.next()) {
				count =  resultset.getInt(1);
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
		return count;
	}
	
	public int myFundingQuestionCount(String id){
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		int count = 0;
		try {
			connection = dataSource.getConnection();
			String query = "SELECT count(question_num)"
					+ " FROM funding_question q where question_customer = ?";

			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, id);
			resultset = preparedstatement.executeQuery();
			
			if(resultset.next()) {
				count =  resultset.getInt(1);
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
		return count;
	}
	
	
	public int countNotice(){
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		int count = 0;
		try {
			connection = dataSource.getConnection();
			String query = "SELECT count(notice_num) FROM notice";
			preparedstatement = connection.prepareStatement(query);
			resultset = preparedstatement.executeQuery();
			
			if(resultset.next()) {
				count =  resultset.getInt(1);
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
		return count;
	}
	public ArrayList<FDtoNotice> notice_list(int page) {
		ArrayList<FDtoNotice> list = new ArrayList<FDtoNotice>();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null; 
		try {
			connection = dataSource.getConnection();
			int offs = (page - 1) * 10;
			String query = "SELECT notice_num, notice_title, notice_At FROM notice order by notice_At desc limit 10 offset " + offs;
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
	public ArrayList<FDtoNotice> notice_search(String search) {
		ArrayList<FDtoNotice> list = new ArrayList<FDtoNotice>();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			connection = dataSource.getConnection();
			String query = "SELECT notice_num, notice_title, notice_At FROM notice WHERE notice_title LIKE '%"+search
					+"%' OR notice_content LIKE '%"+search+"%';";
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
	public String findpw(String id, String pw_q, String pw_a) {
		String pw = null;
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			connection = dataSource.getConnection();
			String query = "SELECT customer_pw FROM customer WHERE customer_id = ? AND customer_pw_q = ? AND customer_pw_a = ?";
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, id);
			preparedstatement.setString(2, pw_q);
			preparedstatement.setString(3, pw_a);
			resultset = preparedstatement.executeQuery();
			
			if(resultset.next()) {
				pw = resultset.getString(1);
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
		return pw;
	}
	public int countFunding(){
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		int count = 0;
		try {
			connection = dataSource.getConnection();
			String query = "SELECT count(funding_num) FROM funding where funding_state = '진행'";
			preparedstatement = connection.prepareStatement(query);
			resultset = preparedstatement.executeQuery();
			
			if(resultset.next()) {
				count =  resultset.getInt(1);
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
		return count;
	}

	public ArrayList<FDtoFunding> fundinglistview(int page) {
		ArrayList<FDtoFunding> list = new ArrayList<FDtoFunding>();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			connection = dataSource.getConnection();
			int offs = (page - 1) * 10;

			String query = "SELECT funding_num, funding_seller, funding_title, funding_openAt, funding_closeAt , "
					+ "(select seller_name from seller as s where f.funding_seller = s.seller_id) "
					+ "FROM funding as f where funding_state = '진행' order by funding_num desc limit 10 offset " + offs;
			preparedstatement = connection.prepareStatement(query);
			resultset = preparedstatement.executeQuery();
			
			while(resultset.next()) {
				int funding_num = resultset.getInt(1);
				String funding_seller = resultset.getString(6);
				String funding_title = resultset.getString(3);
				Timestamp funding_openAt = resultset.getTimestamp(4);
				Timestamp funding_closeAt = resultset.getTimestamp(5);
				
				FDtoFunding dto = new FDtoFunding(funding_num, funding_seller, funding_title, funding_openAt, funding_closeAt);
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
	}//funding list view
	public ArrayList<FDtoFunding> fundingsearch(String search) {
		ArrayList<FDtoFunding> list = new ArrayList<FDtoFunding>();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			connection = dataSource.getConnection();
			String query = "SELECT funding_num, funding_seller, funding_title, funding_openAt, funding_closeAt, "
					+ "(select seller_name from seller as s where f.funding_seller = s.seller_id)"
					+ "FROM funding as f WHERE funding_title Like '%";
			query += search+"%' OR (select seller_name from seller as s where f.funding_seller = s.seller_id) Like '%";
			query += search+"%'";
			
			preparedstatement = connection.prepareStatement(query);
			resultset = preparedstatement.executeQuery();
			
			while(resultset.next()) {
				int funding_num = resultset.getInt(1);
				String funding_seller = resultset.getString(6);
				String funding_title = resultset.getString(3);
				Timestamp funding_openAt = resultset.getTimestamp(4);
				Timestamp funding_closeAt = resultset.getTimestamp(5);
				
				FDtoFunding dto = new FDtoFunding(funding_num, funding_seller, funding_title, funding_openAt, funding_closeAt);
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
	}//funding search
	
	public int countQuestion(){
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		int count = 0;
		try {
			connection = dataSource.getConnection();
			String query = "SELECT count(question_num) FROM system_question";
			preparedstatement = connection.prepareStatement(query);
			resultset = preparedstatement.executeQuery();
			
			if(resultset.next()) {
				count =  resultset.getInt(1);
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
		return count;
	}
	
	public ArrayList<FDtoSystemQuestion>systemquestion_view(int page){
		ArrayList<FDtoSystemQuestion> list = new ArrayList<FDtoSystemQuestion>();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			connection = dataSource.getConnection();
			int offs = (page - 1) * 10;
			String query = "SELECT question_num, question_title, question_at, question_state FROM system_question order by question_at desc limit 10 offset " + offs;
			preparedstatement = connection.prepareStatement(query);
			resultset = preparedstatement.executeQuery();
			
			while(resultset.next()) {
				int question_num = resultset.getInt(1);
				String question_title = resultset.getString(2);
				Timestamp question_at = resultset.getTimestamp(3);
				String question_state = resultset.getString(4);
				FDtoSystemQuestion dto = new FDtoSystemQuestion(question_num, question_title, question_at, question_state);
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
	}
	public ArrayList<FDtoSystemQuestion>mysystemquestion_list(String id, int page){
		ArrayList<FDtoSystemQuestion> list = new ArrayList<FDtoSystemQuestion>();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			connection = dataSource.getConnection();
			int offs = (page - 1) * 10;
			String query = "SELECT * FROM system_question where question_customer = ? order by question_at desc limit 10 offset " + offs;
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, id);
			resultset = preparedstatement.executeQuery();
			
			while(resultset.next()) {
				int question_num = resultset.getInt(1);
				String question_title = resultset.getString(4);
				Timestamp question_at = resultset.getTimestamp(6);
				String question_state = resultset.getString(9);
				FDtoSystemQuestion dto = new FDtoSystemQuestion(question_num, question_title, question_at, question_state);
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
	}
	public ArrayList<FDtoFundingQuestion>myfundingquestion_list(String id, int page){
		ArrayList<FDtoFundingQuestion> list = new ArrayList<FDtoFundingQuestion>();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			connection = dataSource.getConnection();
			int offs = (page - 1) * 10;
			String query = "SELECT question_customer, (select funding_title from funding f where f.funding_num = q.question_funding),"
					+ " question_content, question_at, question_state, question_answer, question_answer_at, question_funding "
					+ " FROM funding_question q where question_customer = ? order by question_at desc limit 10 offset "+offs;
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, id);
			resultset = preparedstatement.executeQuery();
			
			while(resultset.next()) {
				String question_customer = resultset.getString(1);
				String question_funding_title = resultset.getString(2);
				String question_content = resultset.getString(3);
				Timestamp question_at = resultset.getTimestamp(4);
				String question_state = resultset.getString(5);
				String question_answer = resultset.getString(6);
				if(question_answer==null) question_answer="답변이 등록되지 않았습니다.";
				Timestamp question_answer_at = resultset.getTimestamp(7);
				int question_funding = resultset.getInt(8);
				FDtoFundingQuestion dto = new FDtoFundingQuestion(question_customer, question_content, question_funding_title, question_at, question_state, question_answer, question_answer_at,question_funding);
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
	}
	public ArrayList<FDtoSystemQuestion>systemquestion_search(String search){
		ArrayList<FDtoSystemQuestion> list = new ArrayList<FDtoSystemQuestion>();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			connection = dataSource.getConnection();
			String query = "SELECT * FROM system_question WHERE question_title LIKE '%"+search+"%' OR question_content LIKE '%"+search
					+"%' OR question_answer LIKE '%"+search+"%';";
			preparedstatement = connection.prepareStatement(query);
			resultset = preparedstatement.executeQuery();
			
			while(resultset.next()) {
				int question_num = resultset.getInt(1);
				String question_title = resultset.getString(4);
				Timestamp question_at = resultset.getTimestamp(6);
				String question_state = resultset.getString(9);
				FDtoSystemQuestion dto = new FDtoSystemQuestion(question_num, question_title, question_at, question_state);
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
	}//system question search
	public FDtoSystemQuestion systemquestion_detail(String num){
		FDtoSystemQuestion dto = null;
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			connection = dataSource.getConnection();
			String query = "SELECT * FROM system_question where question_num = ?";
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, num);
			resultset = preparedstatement.executeQuery();
			
			if(resultset.next()) {
				int question_num = resultset.getInt(1);
				String question_customer = resultset.getString(2);
				String question_admin = resultset.getString(3);
				String question_title = resultset.getString(4);
				String question_content = resultset.getString(5);
				Timestamp question_at = resultset.getTimestamp(6);
				String question_answer = resultset.getString(7);
				if(question_answer == null) question_answer = "답변이 등록되지 않았습니다. <br>빠른시일내로 답변 도와드리겠습니다.";
				Timestamp question_answer_at = resultset.getTimestamp(8);
				String question_state = resultset.getString(9);
				dto = new FDtoSystemQuestion(question_num, question_customer, question_admin, question_title, question_content, question_at, question_answer, question_answer_at, question_state);
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
	}//system_question_detail_view
	public void create_systemQuestion(String id, String title, String content) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "INSERT INTO system_question (question_customer, question_admin, question_title, question_content, question_at, question_state) values(?, 'admin@admin.com', ?, ?, now(), '답변대기');";
			preparedStatement = connection.prepareStatement(query);		
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, title);
			preparedStatement.setString(3, content);
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
	}//create_system_question
	
	public ArrayList<FDtoFunding> myfundinglist(String id, int page) {
		ArrayList<FDtoFunding> list = new ArrayList<FDtoFunding>();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			connection = dataSource.getConnection();
			int offs = (page - 1) * 10;
			
			String query = "SELECT funding_num, funding_seller, funding_title, funding_openAt, funding_closeAt , "
					+ "(select seller_name from seller as s where f.funding_seller = s.seller_id) "
					+ "FROM funding as f "
					+ "where funding_num in (select order_funding from order1 where order_customer = ? ) order by funding_num desc limit 10 offset " + offs;
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, id);
			resultset = preparedstatement.executeQuery();
			
			while(resultset.next()) {
				int funding_num = resultset.getInt(1);
				String funding_seller = resultset.getString(6);
				String funding_title = resultset.getString(3);
				Timestamp funding_openAt = resultset.getTimestamp(4);
				Timestamp funding_closeAt = resultset.getTimestamp(5);
				
				FDtoFunding dto = new FDtoFunding(funding_num, funding_seller, funding_title, funding_openAt, funding_closeAt);
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
	}//my funding list
	
	public boolean checkEmail(String email)  {
		boolean res = false;
		
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			connection = dataSource.getConnection();
			String query = "select customer_id from customer where customer_id = ?";
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, email);
			resultset = preparedstatement.executeQuery();
			
			if(resultset.next()) {
				res = true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return res;
		
	}
	
	public boolean checkLike(String cid, String fid) {
		boolean res = false;
		
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			connection = dataSource.getConnection();
			String query = "select * from funding_like where like_customer = ? and like_funding = ?";
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, cid);
			preparedstatement.setString(2, fid);
			resultset = preparedstatement.executeQuery();
			
			if(resultset.next()) {
				res = true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return res;
		
	}
	
	public ArrayList<FDtoFunding> mylikelist(String id, int page) {
		ArrayList<FDtoFunding> list = new ArrayList<FDtoFunding>();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			connection = dataSource.getConnection();
			int offs = (page - 1) * 10;
			String query = "SELECT funding_num, funding_seller, funding_title, funding_openAt, funding_closeAt , "
					+ "(select seller_name from seller as s where f.funding_seller = s.seller_id) "
					+ "FROM funding as f "
					+ "where funding_num in (select like_funding from funding_like l where l.like_customer = ?) order by funding_num desc limit 10 offset " + offs;
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, id);
			resultset = preparedstatement.executeQuery();
			
			while(resultset.next()) {
				int funding_num = resultset.getInt(1);
				String funding_seller = resultset.getString(6);
				String funding_title = resultset.getString(3);
				Timestamp funding_openAt = resultset.getTimestamp(4);
				Timestamp funding_closeAt = resultset.getTimestamp(5);
				
				FDtoFunding dto = new FDtoFunding(funding_num, funding_seller, funding_title, funding_openAt, funding_closeAt);
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
	}//my funding list
	
	public FDtoFunding funding_detail(String fnum) {
		FDtoFunding dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "SELECT funding_title, funding_banner, funding_purpose,funding_openAt, funding_closeAt, "
					+ "(select content_content from funding_content where funding_content.content_funding = f.funding_num)as content, "
					+ "(select sum(order_price*order_count) from order1 o where o.order_funding = f.funding_num group by order_funding)/funding_purpose*100 as achievement, "
					+ "(select seller_name from seller s where f.funding_seller = s.seller_id) as seller_name, "
					+ "(select sum(order_price*order_count) from order1 o where o.order_funding = f.funding_num group by order_funding) as total, "
					+ "(select count(distinct order_customer) from order1 o where o.order_funding = f.funding_num) as count,"
					+ "funding_num,  "
					+ "(select seller_profile from seller s where f.funding_seller = s.seller_id) as seller_profile "
					+ "from funding f where funding_num = ? ;";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, fnum);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
		
				String funding_title = resultSet.getString("funding_title"); 
				Timestamp funding_openAt = resultSet.getTimestamp("funding_openAt"); 
				Timestamp funding_closeAt = resultSet.getTimestamp("funding_closeAt"); 
				int funding_purpose = resultSet.getInt("funding_purpose"); 
				String content_content = resultSet.getString("content");
				String funding_banner = resultSet.getString("funding_banner");
				String funding_seller = resultSet.getString("seller_name");
				int funding_achievement = resultSet.getInt("achievement");
				int total = resultSet.getInt("total");
				int count = resultSet.getInt("count");
				int funding_num = resultSet.getInt("funding_num");
				String seller_profile = resultSet.getString("seller_profile");
				
				dto = new FDtoFunding(funding_banner, funding_seller, funding_title, funding_openAt, funding_closeAt, funding_purpose, funding_achievement, total, content_content, count,funding_num, seller_profile);
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
		return dto;
	} //list end
	
	public ArrayList<FDtoFundingOption> optionList(String funding_num) {
		//list
		
		ArrayList<FDtoFundingOption> FDtoFundingOption = new ArrayList<FDtoFundingOption>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select option_num, option_name, option_price, option_amount, count(option_num) from funding_option where option_funding = ? group by option_num";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, funding_num);

			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
		
				String option_name = resultSet.getString("option_name"); 
				int option_price = resultSet.getInt("option_price"); 
				int option_amount = resultSet.getInt("option_amount"); 
				int option_num = resultSet.getInt("option_num");
		
			

				FDtoFundingOption dto2 = new FDtoFundingOption(option_num, option_name, option_price, option_amount);
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
			String query = "select question_customer, question_content, question_at, question_answer, question_answer_at from funding_question where question_funding = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, funding_num);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
		
				String question_customer = resultSet.getString("question_customer"); 
				String question_content = resultSet.getString("question_content"); 
				Timestamp question_at = resultSet.getTimestamp("question_at"); 
				String question_answer = resultSet.getString("question_answer"); 
				if(question_answer == null) question_answer = "답변이 등록되지않았습니다. <br> 빠른 시일내로 답변 도와드리겠습니다.";
				Timestamp question_answer_at = resultSet.getTimestamp("question_answer_at"); 
		
				FDtoFundingQuestion dto3 = new FDtoFundingQuestion(question_customer, question_content, question_at, question_answer, question_answer_at);
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
	
public void unlike(String like_customer, int like_funding) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "delete from funding_like where like_customer = ? and like_funding = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, like_customer);
			preparedStatement.setInt(2, like_funding);
	
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
			int order_count) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "INSERT INTO order1 (order_customer, order_funding, order_option, order_price, order_count, order_At) values(?, ?, ?, ?, ?, now())";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, order_customer);
			preparedStatement.setInt(2, order_funding);
			preparedStatement.setInt(3, order_option);
			preparedStatement.setInt(4, order_price);
			preparedStatement.setInt(5, order_count);
	
	
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
		ArrayList<FDtoOrder> FDtoOrder = new ArrayList<FDtoOrder>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select order_customer, order_at, (order_price * order_count) from order1 where order_funding = ? ;";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, funding_num);

			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
		
				String order_customer = resultSet.getString(1); 
				Timestamp order_at = resultSet.getTimestamp(2); 
				int order_cost = resultSet.getInt(3); 
				FDtoOrder dtoorder = new FDtoOrder(order_customer,order_at, order_cost);
				
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
	} //option list end

	public int select_hits(String funding_num) {
		int hits = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select funding_hits from funding where funding_num = ?;";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, funding_num);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				hits = resultSet.getInt(1);
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
		return hits;
	}//select_hits
	public void update_hits(String funding_num, int hits) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "update funding set funding_hits = ? where funding_num = ?;";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, hits);
			preparedStatement.setString(2, funding_num);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();;
			}
		}
	}//update_hits
	public ArrayList<FDtoFunding> mainlist(String querying) {
		ArrayList<FDtoFunding> list = new ArrayList<FDtoFunding>();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			connection = dataSource.getConnection();
			String query = "SELECT funding_num, funding_seller, funding_banner, funding_title, funding_openAt, funding_closeAt, funding_state, "
					+ "(select seller_name from seller as s where f.funding_seller = s.seller_id), "
					+ "(select sum(order_price*order_count) from order1 o where o.order_funding = f.funding_num group by order_funding)/funding_purpose*100 as achievement, "
					+ "(select sum(order_price*order_count) from order1 o where o.order_funding = f.funding_num group by order_funding) "
					+ " FROM funding as f "+querying+";";

			preparedstatement = connection.prepareStatement(query);
			resultset = preparedstatement.executeQuery();
			while(resultset.next()) {
				int funding_num = resultset.getInt(1);
				String funding_seller = resultset.getString(8);
				String funding_banner = resultset.getString(3);
				String funding_title = resultset.getString(4);
				Timestamp funding_openAt = resultset.getTimestamp(5);
				Timestamp funding_closeAt = resultset.getTimestamp(6);
				String funding_state = resultset.getString(7);
				int funding_achievement = resultset.getInt(9);
				int total = resultset.getInt(10);
				FDtoFunding dto = new FDtoFunding(funding_num, funding_seller, funding_banner, funding_title, funding_openAt, funding_closeAt, funding_state, funding_achievement, total);
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
	}
	
	public FDtoFunding myorder_funding(String num) {
		FDtoFunding dto = null;
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			connection = dataSource.getConnection();
			String query = "SELECT funding_num, funding_title, funding_state, (select seller_name from seller s where f.funding_seller = s.seller_id) from funding f where funding_num = ? ";
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, num);
			resultset = preparedstatement.executeQuery();
			
			if(resultset.next()) {
				int funding_num = resultset.getInt(1);
				String funding_seller = resultset.getString(4);
				String funding_title = resultset.getString(2);
				String funding_state = resultset.getString(3);
				
				dto = new FDtoFunding(funding_num, funding_seller, funding_title, funding_state);
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
	public ArrayList<FDtoOrder> myorder_ordering(String num,String id) {
		ArrayList<FDtoOrder> list = new ArrayList<FDtoOrder>();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			connection = dataSource.getConnection();
			String query = "SELECT (SELECT option_name from funding_option fo where o.order_option = fo.option_num)"
					+ ", order_price, order_count,order_at from order1 o where order_funding = ? AND order_customer = ?;";
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, num);
			preparedstatement.setString(2, id);
			resultset = preparedstatement.executeQuery();
			
			while(resultset.next()) {
				String option_name = resultset.getString(1);
				int order_price = resultset.getInt(2);
				int order_count = resultset.getInt(3);
				Timestamp order_at = resultset.getTimestamp(4);
				
				FDtoOrder dto = new FDtoOrder(order_price, order_count, order_at, option_name);
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
	}
	public void question_create(String funding_num, String id, String content) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		try {
			connection = dataSource.getConnection();
			String query = "Insert into funding_question (question_customer, question_funding, question_seller, question_content, question_at, question_state) "
					+ "values(?,?,(select funding_seller from funding where funding_num = ?), ?, now(), '답변대기');";
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1,id);
			preparedstatement.setString(2, funding_num);
			preparedstatement.setString(3, funding_num);
			preparedstatement.setString(4, content);
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
	}
	public void update_infor(String id, String pw, String phone) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		try {
			connection = dataSource.getConnection();
			String query = "update customer set customer_pw = ?, customer_phone = ? where customer_id = ?";
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, pw);
			preparedstatement.setString(2, phone);
			preparedstatement.setString(3, id);
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
	}
}
