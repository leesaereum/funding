package funding.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import funding.dao.FDaoA;
public class ALoginCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String aid = request.getParameter("adminId");
		String apw = request.getParameter("adminPw");
		FDaoA daoA = new FDaoA();
		
		

		String aId = daoA.AlogIn(aid, apw);
		if(aId != null) {
			HttpSession session = request.getSession();
			session.setAttribute("adminId", aId);
		}

		if(aId == null) {
			request.setAttribute("viewPage", "aLogin.jsp?error=error");
		}else {
			request.setAttribute("viewPage", "aCList.do");
		}
		

	}

}
