package funding.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

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
}