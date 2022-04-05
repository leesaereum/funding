package funding.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

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

	public String login(String id, String pw) {
		Connection connection = null;
		PreparedStatement prepardestatement = null;
		ResultSet resultset = null;
		String customer_id = null;
		try {
			connection = dataSource.getConnection();
			String query = "SELECT customer_id FROM customer WHERE customer_id = ? AND customer_pw = ?";
			prepardestatement = connection.prepareStatement(query);
			prepardestatement.setString(1, id);
			prepardestatement.setString(2, pw);
			resultset = prepardestatement.executeQuery();
			
			if(resultset.next()) {
				customer_id = resultset.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) connection.close();
				if (prepardestatement != null) prepardestatement.close();
				if (resultset != null) resultset.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return customer_id;

	}
}
