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
import funding.dto.FDtoNotice;
import funding.dto.FDtoSeller;
import funding.dto.FDtoSystemQuestion;

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
			String query = "select customer_id, customer_name, customer_phone, address_state, address_city, address_line from customer, address where customer.customer_id = address.address_customer";
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

	// seller applylist

	public ArrayList<FDtoSeller> sellerapplylist() {

		ArrayList<FDtoSeller> dtos = new ArrayList<FDtoSeller>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "SELECT * FROM seller WHERE seller_state NOT IN ('블랙')";

			preparedStatement = connection.prepareStatement(query);
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
	} 
	
	// seller applylist end
	
	
	// seller detail
	
	public ArrayList<FDtoSeller> sellerdetail(String sellerId) {
		
		System.out.println("OK");
		System.out.println(sellerId);
		ArrayList<FDtoSeller> dtos = new ArrayList<FDtoSeller>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "SELECT * FROM seller WHERE seller_id = ? ";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, sellerId);
			resultSet = preparedStatement.executeQuery();
			

			
			while (resultSet.next()) {
				String seller_id = resultSet.getString("seller_id");
				String seller_pw = resultSet.getString("seller_pw");
				String seller_license = resultSet.getString("seller_license");
				String seller_number = resultSet.getString("seller_number");
				String seller_profile = resultSet.getString("seller_profile");
				String seller_name = resultSet.getString("seller_name");
				String seller_phone = resultSet.getString("seller_phone");
				String seller_person_name = resultSet.getString("seller_person_name");
				String seller_person_phone = resultSet.getString("seller_person_phone");
				String seller_state = resultSet.getString("seller_state");
				
				System.out.println(seller_id);
				
				FDtoSeller dto22 = new FDtoSeller(seller_id, seller_pw, seller_license, seller_number, seller_profile, seller_name, seller_phone, seller_person_name, seller_person_phone, seller_state);
				
				dtos.add(dto22);
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
	} 
	
	// seller detailt end


	
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
			String query = "SELECT funding_num, funding_seller, funding_title, funding_state FROM funding WHERE funding_state NOT IN ('진행')";

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
	
	
	
	// funding detail
	
	public ArrayList<FDtoFunding> fundingdetail(String fundingNum) {
		

		ArrayList<FDtoFunding> dtos = new ArrayList<FDtoFunding>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "SELECT * FROM funding WHERE funding_num = ? ";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, fundingNum);
			resultSet = preparedStatement.executeQuery();
			

			
			while (resultSet.next()) {
				int funding_num = resultSet.getInt("funding_num");
				String funding_seller = resultSet.getString("funding_seller");
				String funding_banner = resultSet.getString("funding_banner");
				String funding_title = resultSet.getString("funding_title");
				
				Timestamp funding_createAt = resultSet.getTimestamp("funding_createAt");
				Timestamp funding_deleteAt = resultSet.getTimestamp("funding_deleteAt");
				Timestamp funding_openAt = resultSet.getTimestamp("funding_openAt");
				Timestamp funding_closeAt = resultSet.getTimestamp("funding_closeAt");
				
				int funding_purpose = resultSet.getInt("funding_purpose");
				int funding_hits = resultSet.getInt("funding_hits");

				String funding_state = resultSet.getString("funding_state");
				int funding_fee = resultSet.getInt("funding_fee");
				
				System.out.println(funding_num);
				
				FDtoFunding dto33 = new FDtoFunding(funding_num, funding_seller, funding_banner, funding_title, funding_createAt, funding_deleteAt, funding_openAt, funding_closeAt, funding_purpose, funding_hits, funding_state, funding_fee);
				
				dtos.add(dto33);
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
	} 
	
	// funding detail end
	

	// fundingapprove
	public FDtoFunding fundingapprove(String funding_num) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		FDtoFunding dto = null;

		try {
			connection = dataSource.getConnection();
			String query = "UPDATE funding SET funding_state = '진행' Where funding_num = ?";

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
	
	
	
	//calculate approve wait list
	
	
	public ArrayList<FDtoSystemQuestion> systemQuestionlist() {

		ArrayList<FDtoSystemQuestion> dtos = new ArrayList<FDtoSystemQuestion>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "SELECT question_num, question_customer, question_title, question_content, question_at, question_state FROM system_question";

			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int question_num = resultSet.getInt("question_num");
				String question_customer = resultSet.getString("question_customer");
				String question_title = resultSet.getString("question_title");
				String question_content= resultSet.getString("question_content");
				Timestamp question_at = resultSet.getTimestamp("question_at");
				String question_state = resultSet.getString("question_state");

				FDtoSystemQuestion dto04 = new FDtoSystemQuestion(question_num, question_customer, question_title, question_content, question_at, question_state );

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
	
	public ArrayList<FDtoFunding> fundinglist() {

		ArrayList<FDtoFunding> dtos = new ArrayList<FDtoFunding>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "SELECT funding_title, funding_num, funding_state, seller_name FROM funding LEFT OUTER JOIN seller ON funding_seller = seller_id WHERE funding_state IN ('진행')";

			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String funding_title = resultSet.getString("funding_title");
				int funding_num = resultSet.getInt("funding_num");
				String funding_state = resultSet.getString("funding_state");
				String seller_name = resultSet.getString("seller_name");

				FDtoFunding dto66 = new FDtoFunding(funding_num, seller_name, funding_title, funding_state);

				dtos.add(dto66);

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
	

	//admin notice list
	public ArrayList<FDtoNotice> anotice_list() {
		ArrayList<FDtoNotice> dtos = new ArrayList<FDtoNotice>();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			connection = dataSource.getConnection();
			String query = "SELECT notice_num, notice_admin, notice_title, notice_At FROM notice order by notice_At desc";
			preparedstatement = connection.prepareStatement(query);
			resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				int notice_num = resultset.getInt(1);
				String notice_admin = resultset.getString(2);
				String notice_title = resultset.getString(3);
				Timestamp notice_At = resultset.getTimestamp(4);
				FDtoNotice dtoNotice = new FDtoNotice(notice_num, notice_admin, notice_title, notice_At);
				dtos.add(dtoNotice);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (preparedstatement != null)
					preparedstatement.close();
				if (resultset != null)
					resultset.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dtos;
	}// notice_list end
	
	
	//notice content
	public FDtoNotice noticecontent(String noticeNum) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		FDtoNotice dto = null;

		try {
			connection = dataSource.getConnection();
			String query = "select notice_admin, notice_title, notice_content, notice_At from notice where notice_num = ?  ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, noticeNum);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String notice_admin = resultSet.getString(1);
				String notice_title = resultSet.getString(2);
				String notice_content = resultSet.getString(3);
				Timestamp notice_At = resultSet.getTimestamp(4);

//				dto = new FDtoNotice(Integer.parseInt(noticeNum), notice_admin, notice_title, notice_content, notice_At);
				dto = new FDtoNotice(Integer.parseInt(noticeNum), notice_admin, notice_title, notice_content,
						notice_At);

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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}// notice content end

	
	// admin notice modify
	public void anoticemodify(String notice_num, String notice_title, String notice_content, Timestamp notice_At) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			String query = "UPDATE notice SET notice_title = ?, notice_content =?, notice_At = ?  Where notice_num = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, notice_title);
			preparedStatement.setString(2, notice_content);
			preparedStatement.setTimestamp(3, notice_At);
			preparedStatement.setString(4, notice_num);
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
	}// admin notice modify end

	
	// admin notice delete
	public void anoticedelete(String notice_num) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			String query = "DELETE FROM notice WHERE notice_num = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, notice_num);
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
	}// admin notice delete end

	
	
	//anotice create
	public void anoticecreate(Object notice_admin, String notice_title, String notice_content) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			String query = "insert into notice (notice_admin, notice_title, notice_content, notice_At) values (?, ?, ?, now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, (String) notice_admin);
			preparedStatement.setString(2, notice_title);
			preparedStatement.setString(3, notice_content);

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}// anotice create end
	
	public ArrayList<FDtoSystemQuestion> SystemQuestionDetail(String question_num) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<FDtoSystemQuestion> dtos = new ArrayList<FDtoSystemQuestion>();

		try {
			connection = dataSource.getConnection();
			String query = "select question_customer, question_title, question_content, question_answer from system_question where question_num = ?  ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, question_num);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String question_customer = resultSet.getString(1);
				String question_title = resultSet.getString(2);
				String question_content = resultSet.getString(3);
				String question_answer = resultSet.getString(4);
				
			
				
//				dto = new FDtoNotice(Integer.parseInt(noticeNum), notice_admin, notice_title, notice_content, notice_At);
				FDtoSystemQuestion FDtoSystemQuestion = new FDtoSystemQuestion(Integer.parseInt(question_num), question_customer, question_title, question_content, question_answer);
				dtos.add(FDtoSystemQuestion);
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dtos;
	}// notice content end
	
	public void SystemQuestionRemove(String question_num) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			String query = "Update system_question set question_answer = \"\", question_state = \"답변대기\"  WHERE question_num = ?";
			preparedStatement = connection.prepareStatement(query);
		
			preparedStatement.setString(1, question_num);
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
	}// admin notice delete end
	
	public void SystemQAnswerInsert(String question_answer, String question_num) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String complete = "완료";
		
		try {
			connection = dataSource.getConnection();
			
			String query = "Update system_question set question_answer = ?, question_state = ? WHERE question_num = ?";
			preparedStatement = connection.prepareStatement(query);
		
			preparedStatement.setString(1, question_answer);
			preparedStatement.setString(2, complete);
			preparedStatement.setString(3, question_num);
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
	}// admin notice delete end
}
