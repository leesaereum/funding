package funding.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import funding.dao.FDaoA;
import funding.dto.FDtoCalculate;
import funding.dto.FDtoFunding;

public class ACRejectCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object adminID = session.getAttribute("adminId");
		String adminId = (String)adminID;
		
		String calNum = request.getParameter("calNum");
		FDaoA dao = new FDaoA();
		FDtoCalculate dto = dao.calreject(calNum);
	}

}
