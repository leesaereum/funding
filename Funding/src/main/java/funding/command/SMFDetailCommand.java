package funding.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.dao.FDaoS;
import funding.dto.FDtoFunding;

public class SMFDetailCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		String funding_num =request.getParameter("funding_num");
		
		FDaoS daoS = new FDaoS();
		FDtoFunding dtoFunding = daoS.sMfunding_detail(funding_num);
		request.setAttribute("Mfunding", dtoFunding);
	}

}
