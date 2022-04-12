package funding.command;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.dao.FDaoS;
import funding.dto.FDtoFunding;

public class SMypageCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Integer funding_num = Integer.parseInt(request.getParameter("funding_num"));
		FDaoS daoS = new FDaoS();
		System.out.println(funding_num);
		
	}
}
