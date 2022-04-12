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
		FDtoFunding dto = daoS.selectDetail(funding_num);
		//ArrayList<> options = daoS.selectOption(funding_num);
		request.setAttribute("Mfunding", dto);
		
		//daoS.sMfunding_detail(funding_num, funding_title, funding_openAt, funding_closeAt,
				//	funding_purpose, funding_fee);
	
		//String funding_title= request.getParameter("funding_title"); 
		//String funding_openAt= request.getParameter("funding_openAt");
		//String funding_closeAt= request.getParameter("funding_closeAt"); 
		//int	funding_purpose=Integer.parseInt(request.getParameter("funding_purpose")); 
		//int funding_fee= Integer.parseInt(request.getParameter("funding_fee"));
	}

}
