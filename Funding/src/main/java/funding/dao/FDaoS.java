package funding.dao;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import funding.dto.FDtoCalculate;
import funding.dto.FDtoFunding;
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
	public void ssignUp(String seller_id, String seller_pw, String seller_pw2, String seller_number,
			String seller_profile, String seller_name, String seller_phone, String seller_person_name,
			String seller_person_phone, String address_seller, String address_state, String address_city,
			String address_line) {
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

	// calculate funding
	public ArrayList<FDtoCalculate> list() {
		ArrayList<FDtoCalculate> dtoCalculates = new ArrayList<FDtoCalculate>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "select c.calcuate_funding from calculate c, admin ad, funding ";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int calculate_funding = resultSet.getInt("calculate_funding");
				String calculate_seller = resultSet.getString("calculate_seller");
				String calculate_admin = resultSet.getString("calculate_admin");
				int calculate_cost = resultSet.getInt("calculate_cost");
				Timestamp calculate_createAt = resultSet.getTimestamp("createAt");
				Timestamp calculate_approveAt = resultSet.getTimestamp("approveAt");
				String calculate_state = resultSet.getString("calculate_state");

				FDtoCalculate dtoCalculate = new FDtoCalculate(calculate_cost, calculate_funding, calculate_seller,
						calculate_admin, calculate_cost, calculate_approveAt, calculate_approveAt);
				dtoCalculates.add(dtoCalculate);
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
		return dtoCalculates;
	}

	public String calcFunding_title(String funding_title) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String title = null;

		try {
			connection = dataSource.getConnection();
			String query = "select funding_title from funding where funding_seller = (select "
					+ "calculate_seller from calculate)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, title);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				title = resultSet.getString("funding_title");
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
		return funding_title;
	}

	public String calcAdmin_name(String admin_name) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String ad_name = null;

		try {
			connection = dataSource.getConnection();
			String query = "select admin_name from admin";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, ad_name);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				ad_name = resultSet.getString("funding_title");
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
		return admin_name;
	}
	
	public void sMypage_count(int funding_num) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			String query = "select count(funding_num) from funding "
					+"where funding_seller in (select seller_id from seller)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, funding_num);
			
			preparedStatement.executeUpdate();

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null ) connection.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	//Manage funding list
	public ArrayList<FDtoFunding> Mfunding_list() {
		ArrayList<FDtoFunding> list = new ArrayList<FDtoFunding>();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			connection = dataSource.getConnection();
			String query = "SELECT funding_num, funding_banner, funding_title, funding_openAt FROM funding";
			preparedstatement = connection.prepareStatement(query);
			resultset = preparedstatement.executeQuery();
			
			while(resultset.next()) {
				int funding_num = resultset.getInt(1);
				String funding_banner = resultset.getString(2);
				String funding_title = resultset.getString(3);
				Timestamp funding_openAt = resultset.getTimestamp(4);
				FDtoFunding dto = new FDtoFunding(funding_num, funding_banner, funding_title, funding_openAt);
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
	
	//Mfunding_detail
	public FDtoFunding sMfunding_detail(String num) {
		FDtoFunding dtoFunding = null;
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "SELECT * FROM funding WHERE funding_num = ?";
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setInt(1, Integer.parseInt(num));
			resultset = preparedstatement.executeQuery();
			
			while(resultset.next()) {
				int funding_num = resultset.getInt(1);
				String funding_seller = resultset.getString(2);
				String funding_title = resultset.getString(3);
				String funding_banner =resultset.getString(4);
				Timestamp funding_openAt =resultset.getTimestamp("funding_openAt");
				Timestamp funding_closeAt =resultset.getTimestamp("funding_closeAt");
				int funding_purpose =resultset.getInt(7);
				int funding_hits =resultset.getInt(8);
				String funding_state =resultset.getString(9);
				int funding_fee =resultset.getInt(10);
				
				dtoFunding = new FDtoFunding(funding_num, funding_seller, funding_banner, funding_title, funding_openAt
						, funding_closeAt, funding_purpose, funding_hits, funding_state, funding_fee); 
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
		return dtoFunding;
	}//Mfunding_detail end
	
	//funding question
	public ArrayList<FDtoFundingQuestion> FQuestion_list(){
		ArrayList<FDtoFundingQuestion> dtosFQ = new ArrayList<FDtoFundingQuestion>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select question_num, question_customer, question_title, question_content, question_at, question_state "
					+ "from funding_question "
					+ "where question_funding in (select funding_num from funding)";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int question_num = resultSet.getInt("question_num"); //1234로 써도 되고, Column 이름으로 써도 됨!
				String question_customer = resultSet.getString("question_customer");
				String question_title = resultSet.getString("question_title");
				String question_content = resultSet.getString("question_content");
				Timestamp question_at = resultSet.getTimestamp("question_at");
				String question_state = resultSet.getString("question_state");
				
				FDtoFundingQuestion dtoFQ = new FDtoFundingQuestion(question_num, question_customer, question_title
														, question_content, question_at, question_state);
				
				dtosFQ.add(dtoFQ);
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
	public FDtoFundingQuestion FAnswer_detail(String num){
		FDtoFundingQuestion dtoFA = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		
		try {
			connection = dataSource.getConnection();
			String query ="select * from funding_question where question_num = ? ";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, num);
			resultset = preparedStatement.executeQuery();
			
			if(resultset.next()) {
				int question_num = resultset.getInt("question_num"); //1234로 써도 되고, Column 이름으로 써도 됨!
				String question_customer = resultset.getString("question_customer");
				String question_seller = resultset.getString("question_seller");
				String question_title = resultset.getString("question_title");
				String question_content = resultset.getString("question_content");
				Timestamp question_answer_at = resultset.getTimestamp("question_answer_at");
				String question_state = resultset.getString("question_state");
				String question_answer = resultset.getString("question_answer");
//				if(question_answer == null) question_state="답변대기";
				dtoFA = new FDtoFundingQuestion(question_num, question_customer, question_seller, question_title
												, question_content, question_state, question_answer, question_answer_at);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}try {
			if (connection != null) connection.close();
			if (preparedStatement != null) preparedStatement.close();
			if (resultset != null) resultset.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoFA;
	}
	
	public void FAnswer_Update(String num, String answer) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;		
		try {
			connection = dataSource.getConnection();
			String query = "update funding_question set question_state ='답변완료', question_answer = ?, question_answer_at = now() "
					+ "where question_num = ?";
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
	//수정하기 위에
	//--------------------------------------------------------------------------------

	public void fundingDataInsert(String funding_seller, String funding_banner, String funding_title,
			Date funding_openAt, Date funding_closeAt, int funding_purpose, String funding_category, int funding_fee) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			String query = "INSERT INTO funding (funding_seller, funding_banner, funding_title, funding_openAt, funding_closeAt, funding_purpose, funding_category, funding_fee, funding_state) values(?, ?, ?, ?, ?, ?, ?, ?,'진행')";
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
}