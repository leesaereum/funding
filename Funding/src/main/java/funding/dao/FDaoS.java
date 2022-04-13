package funding.dao;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import funding.dto.FDtoCalculate;
import funding.dto.FDtoFunding;
import funding.dto.FDtoFundingContent;
import funding.dto.FDtoFundingOption;
import funding.dto.FDtoFundingQuestion;
import funding.dto.FDtoNotice;

public class FDaoS {
	DataSource dataSource;

	public FDaoS() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/funding_system");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// constructor

	// ssignUp --> sign up for seller
	public void ssignUp(String seller_id, String seller_pw, String seller_number,
			String seller_profile, String seller_name, String seller_phone, String seller_person_name,
			String seller_person_phone) {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			String query = "insert into seller (seller_id, seller_pw, seller_number, seller_profile, seller_name, seller_phone "
					+ ", seller_person_name, seller_person_phone, seller_state) values (?, ?, ?, ?, ?, ?, ?, ?, '승인대기')";

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
	}

	public boolean duplecateID(String id, String pw) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		int result = 0;

		String query = "select seller_pw from seller where seller_id = ?";
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String pW = resultSet.getString("pw");
				if (pW.equals(pw) == true) {
					return true;
				}
			}
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
			return false;
		}
	}

	public boolean checkDuplicateId(String id) {
		boolean result = true;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select s.seller_id, c.customer_id from seller s, customer c "
				+ "where c.customer_id = ? or s.seller_id = ?";


		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, id);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String seller_id = resultSet.getString(1);
				String customer_id = resultSet.getString(2);
				if(seller_id !=null || customer_id !=null) result = false;
			}
			
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
				e.printStackTrace();
			}
		}
		return result;
	}
	public void address(String address_seller, String address_state, String address_city, String address_line) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			String query = "insert into address (address_seller, address_state, address_city, address_line) values (?, ?, ?, ?)";

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, address_seller);
			preparedStatement.setString(2, address_state);
			preparedStatement.setString(3, address_city);
			preparedStatement.setString(4, address_line);

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
		
	}//ssignUp end
		

	// ssignIn --> sign In for seller
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

			if (resultSet.next()) {
				seller_id = resultSet.getString("seller_id");
			}

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
		return seller_id;
	}//ssignIn end

	// seller apply
	public void sFOapply(String seller_id, String seller_name, String seller_number, String seller_person_name,
			String seller_person_phone, String address_seller, String address_state, String address_city,
			String address_line) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			String query = "select s.seller_name, s.seller_number, s.seller_person_name, s.seller_person_phone, a.address_state, a.address_city, a.address_line "
					+ "from seller s, address a " + "where s.seller_id = a.address_seller";

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, seller_name);
			preparedStatement.setString(2, seller_number);
			preparedStatement.setString(3, seller_person_name);
			preparedStatement.setString(4, seller_person_phone);
			preparedStatement.setString(5, address_state);
			preparedStatement.setString(6, address_city);
			preparedStatement.setString(7, address_line);

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

	}
	
	//수정하기 -----------
	

	// calculate funding
	public ArrayList<FDtoCalculate> list(String nNUM, int funding, String id) {
		ArrayList<FDtoCalculate> list = new ArrayList<FDtoCalculate>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "select c.calculate_num, c.calculate_funding, c.calculate_seller, c.calculate_admin, "
					+ "c.calculate_cost, c.calculate_createAt, "
					+ "c.calculate_approveAt, c.calculate_state from calculate c , funding f "
					+ "where f.funding_seller = ? and f.funding_num = ?"; 
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			preparedStatement.setInt(2, funding);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int calculate_num = resultSet.getInt(1);
				int calculate_funding = resultSet.getInt(2);
				String calculate_seller = resultSet.getString(3);
				String calculate_admin = resultSet.getString(4);
				int calculate_cost = resultSet.getInt(5);
				Timestamp calculate_createAt = resultSet.getTimestamp(6);
				Timestamp calculate_approveAt = resultSet.getTimestamp(7);
				String calculate_state = resultSet.getString(8);

				FDtoCalculate dto = new FDtoCalculate(calculate_num, calculate_funding, calculate_seller, calculate_admin, calculate_cost,
									calculate_createAt, calculate_approveAt, calculate_state);
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null ) preparedStatement.close();
				if(connection != null ) connection.close();
				if (resultSet != null) resultSet.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public void sMFCapply(int calculate_funding, String calculate_seller) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query ="insert into calculate (calculate_funding, calculate_seller, calculate_admin, calculate_createAt, calculate_state) "
					+ "values('?','?','admin@admin.com',now(),'정산대기') "
					+ "update calculate set calculate_cost = "
					+ "(select sum(order_price * order_count) from order1 o "
					+ "where o.order_funding = calculate.calculate_funding group by o.order_funding)";
			preparedStatement = connection.prepareStatement(query);
		
			preparedStatement.setInt(1, calculate_funding);
			preparedStatement.setString(2, calculate_seller);

			preparedStatement.executeUpdate();
		}catch(Exception e) {
			
		}
	}
	
	//Manage funding list (SMFManangeCommand)
	public ArrayList<FDtoFunding> Mfunding_list(String id) {
		ArrayList<FDtoFunding> list = new ArrayList<FDtoFunding>();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			connection = dataSource.getConnection();
			String query = "SELECT funding_num, funding_title, funding_openAt, funding_closeAt,funding_state FROM funding where funding_seller = ?";
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, id);
			resultset = preparedstatement.executeQuery();
			
			while(resultset.next()) {
				int funding_num = resultset.getInt(1);
				String funding_title = resultset.getString(2);
				Timestamp funding_openAt = resultset.getTimestamp(3);
				Timestamp funding_closeAt = resultset.getTimestamp(4);
				String funding_state = resultset.getString(5);
				FDtoFunding dto = new FDtoFunding(funding_num, funding_title, funding_openAt, funding_closeAt,funding_state);
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
	}//Mfunding_list end
	
	//Detail_List (SMFDetailCommand-1page)
	public FDtoFunding selectDetail(String num) {
		FDtoFunding dto = null;
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			connection = dataSource.getConnection();
			String query = "SELECT funding_num, funding_banner, funding_title, "
					+ "funding_openAt, funding_closeAt, funding_purpose, funding_fee from funding "
					+ "where funding_num = ?";
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, num);
			resultset = preparedstatement.executeQuery();
			
			while(resultset.next()) {
				int funding_num = resultset.getInt(1);
				String funding_banner = resultset.getString(2);
				String funding_title = resultset.getString(3);
				Timestamp funding_openAt = resultset.getTimestamp(4);
				Timestamp funding_closeAt = resultset.getTimestamp(5);
				int funding_purpose = resultset.getInt(6);
				int funding_fee = resultset.getInt(7);
				dto = new FDtoFunding(funding_num, funding_banner, funding_title, funding_openAt, funding_closeAt, funding_purpose, funding_fee);
					
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
	
	//selectOption list (SMFDetailCommand-2page)
		public ArrayList<FDtoFundingOption> selectOption(String num){
			ArrayList<FDtoFundingOption> options = new ArrayList<FDtoFundingOption>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultset = null;
			
			try {
				connection = dataSource.getConnection();
				String query = "SELECT option_num, option_name, option_price, option_amount FROM funding_option where option_funding = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, num);
				resultset = preparedStatement.executeQuery();
				
				while(resultset.next()) {
					int option_num = resultset.getInt("option_num");
					String option_name = resultset.getString("option_name");
					int option_price = resultset.getInt("option_price");
					int option_amount = resultset.getInt("option_amount");
					
					FDtoFundingOption option =  new  FDtoFundingOption(option_num, option_name, option_price, option_amount);
					options.add(option);
				}
			}catch (Exception e) {
				// TODO: handle exception
			}try {
				if (connection != null) connection.close();
				if (preparedStatement != null) preparedStatement.close();
				if (resultset != null) resultset.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return options;
		}//end
	
	//selectDetail_List(SMFDetailCommand-3page)	
	public FDtoFundingContent selectDetail1(String num) {
		FDtoFundingContent dto1 = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		
		try {
			connection= dataSource.getConnection();
			String query = "select content_content from funding_content fc inner join funding f on fc.content_funding "
					+ "and f.funding_num=? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, num);
			resultset = preparedStatement.executeQuery();
			System.out.println(resultset.next());
			while(resultset.next()) {
				String content_content = resultset.getString(1);
				dto1 = new FDtoFundingContent(content_content);
				System.out.println(content_content);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) connection.close();
				if (preparedStatement != null) preparedStatement.close();
				if (resultset != null) resultset.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto1;
	}
	
	//Detail_List_Modify(1page)
//	public void modifySelectDetail(String num, String banner, String title, String openAt, String closeAt, int purpose, int fee)
	public void modifySelectDetail(String num, String banner, String title, String openAt, String closeAt, String purpose, String fee) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "UPDATE funding SET funding_banner = ?, funding_title = ?, funding_openAt =?, funding_closeAt = ? , "
							+ "funding_purpose = ?, funding_fee = ? Where funding_num = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, banner);
			preparedStatement.setString(2, title);
			preparedStatement.setString(3, openAt);
			preparedStatement.setString(4, closeAt);
			preparedStatement.setString(5, purpose);
			preparedStatement.setString(6, fee);
			preparedStatement.setString(7, num);
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
	}	

	//Detail_List_Modify(2page)
//	public void modifySelectDetail1(String num, String name, int price, int amount)
	public void modifySelectDetail1(String num, String name, String price, String amount) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "UPDATE funding_option SET option_ name= ?, option_price = ?, option_amount =? "
							+ "Where option_funding = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, Integer.parseInt(price));
			preparedStatement.setInt(3, Integer.parseInt(amount));
			preparedStatement.setString(4, num);
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
	}
	
//	public void modifySelectDetail2(String num, String content)
	public void modifySelectDetail2(String num, String content) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "UPDATE funding_content SET content_content= ? "
							+"Where content_funding = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, content);
			preparedStatement.setString(2, num);
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
	}
	
	//Detail_List_Delete
	public void deleteSelectDetail(String num) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			String query = "DELETE FROM funding WHERE funding_num = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, num);
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
	}
	
	public void deleteSelectDetail1(String num) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			String query = "DELETE FROM funding WHERE funding_num = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, num);
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
	}
	
	//-----------------------------------------------------------------------------------
	
	//funding question
	public FDtoFundingQuestion FQuestion_list(String num){
		FDtoFundingQuestion dtosFQ = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select question_num, question_customer, question_content, question_at, question_state, "
					+ "(select funding_title from funding f where f.funding_num = q.question_num) "
					+ "from funding_question q "
					+ "where question_num = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, num);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int question_num = resultSet.getInt("question_num"); //1234로 써도 되고, Column 이름으로 써도 됨!
				String question_customer = resultSet.getString("question_customer");
				String question_content = resultSet.getString("question_content");
				Timestamp question_at = resultSet.getTimestamp("question_at");
				String question_state = resultSet.getString("question_state");
				String question_funding_title = resultSet.getString(6);
				
				dtosFQ = new FDtoFundingQuestion(question_num, question_customer, question_content, question_at, question_state, question_funding_title);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//이상이 있건 없건 메모리 정리	
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dtosFQ;
	} //funding question end
	
	//funding answer
//	public FDtoFundingQuestion FAnswer_detail(String num){
//		FDtoFundingQuestion dtoFA = null;
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		ResultSet resultset = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			String query ="select * from funding_question where question_num = ? ";
//
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setString(1, num);
//			resultset = preparedStatement.executeQuery();
//			
//			if(resultset.next()) {
//				int question_num = resultset.getInt("question_num"); //1234로 써도 되고, Column 이름으로 써도 됨!
//				String question_customer = resultset.getString("question_customer");
//				String question_seller = resultset.getString("question_seller");
//				String question_title = resultset.getString("question_title");
//				String question_content = resultset.getString("question_content");
//				Timestamp question_answer_at = resultset.getTimestamp("question_answer_at");
//				String question_state = resultset.getString("question_state");
//				String question_answer = resultset.getString("question_answer");
////				if(question_answer == null) question_state="답변대기";
//				dtoFA = new FDtoFundingQuestion(question_num, question_customer, question_seller, question_title
//												, question_content, question_state, question_answer, question_answer_at);
//			}
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}try {
//			if (connection != null) connection.close();
//			if (preparedStatement != null) preparedStatement.close();
//			if (resultset != null) resultset.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return dtoFA;
//	}
	
	public void FAnswer_Update(String num, String answer) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;		
		System.out.println(answer);
		try {
			connection = dataSource.getConnection();
			String query = "update funding_question set question_state = '답변완료' , question_answer = ? , question_answer_at = now() "
					+ "where question_num = ?;";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, answer);
			preparedStatement.setString(2, num);
			preparedStatement.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if (connection != null) connection.close();
				if (preparedStatement != null) preparedStatement.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	public void fundingDataInsert(String funding_seller, String funding_banner, String funding_title,
			Date funding_openAt, Date funding_closeAt, int funding_purpose, int funding_fee) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			String query = "INSERT INTO funding (funding_seller, funding_banner, funding_title, funding_openAt, funding_closeAt, funding_purpose, funding_fee, funding_state) values(?, ?, ?, ?, ?, ?, ?,'대기')";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, funding_seller);
			preparedStatement.setString(2, funding_banner);
			preparedStatement.setString(3, funding_title);
			preparedStatement.setDate(4, funding_openAt);
			preparedStatement.setDate(5, funding_closeAt);
			preparedStatement.setInt(6, funding_purpose);
			preparedStatement.setInt(7, funding_fee);

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
			System.out.println("finish");
		}

	}// fundingDataInsert

	public int funding_num(String funding_title) {
		// list

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

			if (resultSet.next()) {
				int get_funding_num = resultSet.getInt("funding_num");

				System.out.println(get_funding_num);

				funding_num = get_funding_num;
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
				;
			}
		}
		return funding_num;
	} //funding_num end

	public void optionDataInsert(int option_numbering, String option_name, int option_price, int option_amount,
			int option_funding) {

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
		} finally {
			try {
				if (preparedStatement != null) preparedStatement.close();
				if (connection != null) connection.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	public void update_infor(String id, String pw, String phone) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		try {
			connection = dataSource.getConnection();
			String query = "update seller set seller_pw = ?, seller_phone = ? where seller_id = ?";
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
	public ArrayList<FDtoFundingQuestion> myfq(String id){
		ArrayList<FDtoFundingQuestion> myfq_list = new ArrayList<FDtoFundingQuestion>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "select (select funding_title from funding f where f.funding_num = q.question_funding), "
					+ "question_num, question_funding, question_content, question_at, question_state"
					+ " from funding_question q where question_seller = ? order by question_funding";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String question_funding_title = resultSet.getString(1);
				int question_num = resultSet.getInt(2);
				int question_funding = resultSet.getInt(3);
				String question_content = resultSet.getString(4);
				Timestamp question_at = resultSet.getTimestamp(5);
				String question_state = resultSet.getString(6);
				FDtoFundingQuestion dto = new FDtoFundingQuestion(question_num, question_funding, question_content, question_funding_title, question_at, question_state);
				myfq_list.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null ) preparedStatement.close();
				if(connection != null ) connection.close();
				if (resultSet != null) resultSet.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return myfq_list;
	}
	public FDtoFunding calfunding(String num) {
		FDtoFunding dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			String query = "select funding_num, funding_title, "
					+ "(select sum(order_price*order_count) from order1 o where o.order_funding = f.funding_num) as total"
					+ " from funding f where funding_num = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, num);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int funding_num = resultSet.getInt(1);
				String funding_title = resultSet.getString(2);
				int total = resultSet.getInt(3);
				
				dto = new FDtoFunding(funding_num, funding_title, total);
			}

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
	}
	public String calinf(String num) {
		String cal_state = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			String query = "select calculate_state"
					+ " from calculate where funding_num = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, num);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				cal_state = resultSet.getString(2);
			}
			
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
		return cal_state;
	}

}