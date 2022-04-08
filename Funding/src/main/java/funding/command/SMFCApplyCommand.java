package funding.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.dao.FDaoS;
import funding.dto.FDtoCalculate;

public class SMFCApplyCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		FDaoS daoS = new FDaoS();
		ArrayList<FDtoCalculate> dtoCalculates = daoS.list();
		request.setAttribute("list", dtoCalculates);
		
		String funding_title =request.getParameter("funding_title");
		String admin_name = request.getParameter("admin_name");
		
		daoS.calcFunding_title(funding_title);
		daoS.calcAdmin_name(admin_name);
	}

}
