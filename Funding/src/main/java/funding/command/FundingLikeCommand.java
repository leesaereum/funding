package funding.command;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.dao.FDaoC;


public class FundingLikeCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String like_customer  = request.getParameter("customer_id");
		Date like_at = Date.valueOf(LocalDate.now());
		
		int like_funding  = Integer.parseInt(request.getParameter("funding_num")) ;
		
		request.setAttribute("viewpage", "/fundingContent_view.do?fid=" + request.getParameter("funding_num"));
		FDaoC dao = new FDaoC();
		dao.likeInsert(like_customer, like_funding, like_at);
		
	}
}
