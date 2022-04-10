package funding.command;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.dao.FDaoS;

public class SMypageCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String funding_seller = request.getParameter("funding_seller");
		String funding_title = request.getParameter("funding_title");
		String funding_banner =request.getParameter("funding_banner");
		Timestamp funding_openAt =Timestamp.valueOf("funding_openAt");
		Timestamp funding_closeAt =Timestamp.valueOf("funding_openAt");
		int funding_purpose =Integer.parseInt(request.getParameter("funding_purpose"));
		int funding_hits =Integer.parseInt(request.getParameter("funding_hits"));
		String funding_state =request.getParameter("funding_state");
		int funding_fee =Integer.parseInt(request.getParameter("funding_fee"));
		
		FDaoS daoS = new FDaoS();
		daoS.sMypage(funding_seller, funding_banner, funding_title, funding_openAt
				, funding_closeAt, funding_purpose, funding_hits, funding_state, funding_fee);
	}
}
