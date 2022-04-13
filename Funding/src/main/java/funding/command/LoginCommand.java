package funding.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import funding.dao.FDaoC;


public class LoginCommand implements FCommand {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String input_id = request.getParameter("customer_id").trim();
		String input_pw = request.getParameter("customer_pw").trim();
		
		FDaoC dao = new FDaoC();
		String customer_id = dao.login(input_id, input_pw);
		
		if(customer_id!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("id", customer_id);
			session.setAttribute("customer_id", customer_id);
			session.setAttribute("email", customer_id);
		}
		if(customer_id==null) {
			request.setAttribute("viewpage", "./pages/login.jsp?error=error");
		}else {
			request.setAttribute("viewpage", "main.do?sort=all");
		}
	}

}
