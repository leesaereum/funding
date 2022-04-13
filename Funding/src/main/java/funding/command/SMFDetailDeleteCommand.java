package funding.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.dao.FDaoS;

public class SMFDetailDeleteCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String funding_num =request.getParameter("funding_num");
		FDaoS daoS = new FDaoS();
		
		System.out.println(funding_num);
		daoS.deleteSelectDetail(funding_num);
	}

}
