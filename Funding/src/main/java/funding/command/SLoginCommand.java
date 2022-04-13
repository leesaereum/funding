package funding.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import funding.dao.FDaoS;

public class SLoginCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id = request.getParameter("seller_id");
		String pw = request.getParameter("seller_pw");
		FDaoS daoS = new FDaoS();
		
		String seller_id = daoS.slogin(id,pw);
		if(seller_id != null) {
			HttpSession session = request.getSession();
			session.setAttribute("id", seller_id);
			session.setAttribute("isSeller", "true");
		}
		
		if(seller_id == null) {
			request.setAttribute("viewpage", "/pages/slogin.jsp?error=error");
		}else {
			request.setAttribute("viewpage", "main.do?sort=all");
		}
	}	

}
