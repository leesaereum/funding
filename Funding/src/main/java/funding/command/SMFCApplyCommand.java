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

		FDaoS daoS = new FDaoS();
		int calculate_funding =Integer.parseInt(request.getParameter("calculate_funding"));
		String calculate_seller =request.getParameter("calculate_funding");
		
		daoS.sMFCapply(calculate_funding, calculate_seller);
		
	}

}
