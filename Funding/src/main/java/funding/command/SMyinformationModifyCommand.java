package funding.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import funding.dao.FDaoC;
import funding.dao.FDaoS;

public class SMyinformationModifyCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String pw = request.getParameter("pw1");
		String phone = request.getParameter("phone");
		
		FDaoS dao = new FDaoS();
		dao.update_infor(id, pw, phone);
	}

}
