package funding.command;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.dao.FDaoS;

public class SMFDetailCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		String funding_num =request.getParameter("funding_num");
		String funding_title= request.getParameter("funding_title"); 
		String funding_openAt= request.getParameter("funding_openAt");
		String funding_closeAt= request.getParameter("funding_closeAt"); 
		int	funding_purpose=Integer.parseInt(request.getParameter("funding_purpose")); 
		int funding_hits = Integer.parseInt(request.getParameter("funding_hits"));
		String funding_state = request.getParameter("funding_state"); 
		int funding_fee= Integer.parseInt(request.getParameter("funding_fee"));
		FDaoS daoS = new FDaoS();
		daoS.sMfunding_detail(funding_num, funding_title, funding_openAt, funding_closeAt,
					funding_purpose, funding_hits, funding_state, funding_fee);
	}

}
