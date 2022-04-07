package funding.command;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.dao.FDaoC;


public class FundingLikeCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String like_customer  = request.getParameter("customer_id");
		String like_At = request.getParameter("like_at");
		java.sql.Date like_at = java.sql.Date.valueOf(like_At);
		
//		String like_At  = request.getParameter("customer_id");
		int like_funding  = Integer.parseInt(request.getParameter("funding_num")) ;
		
		FDaoC dao = new FDaoC();
		
		dao.likeInsert(like_customer, like_funding, like_at);
		
		
	}

}
