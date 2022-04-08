package funding.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.dao.FDaoS;

public class SMFCApplyCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int calculate_funding =Integer.parseInt(request.getParameter("calculate_funding"));
		String calculate_seller = request.getParameter("calculate_seller");
		String calculate_admin = request.getParameter("calculate_admin");
		int calculate_cost = Integer.parseInt(request.getParameter("calculate_cost"));
		String createAt =request.getParameter("createAt");
		String approveAt =request.getParameter("approveAt");
		String calculate_state =request.getParameter("calculate_state");
		
		FDaoS daoS = new FDaoS();
		daoS.sMFCapply(calculate_funding, calculate_seller, calculate_admin, calculate_cost
						,calculate_seller, calculate_admin, calculate_state);
		
	}

}
