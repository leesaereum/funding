package funding.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.dao.FDaoC;

public class FindpwCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id").trim();
		String pw_q = request.getParameter("pw_q").trim();
		String pw_a = request.getParameter("pw_a").trim();
		FDaoC dao = new FDaoC();
		String customer_pw = dao.findpw(id,pw_q, pw_a);
		if(customer_pw!=null) {
			request.setAttribute("customer_pw", customer_pw);
			request.setAttribute("customer_id", id);
			request.setAttribute("viewpage", "/pages/findpw.jsp");
			
		}else request.setAttribute("viewpage", "/pages/findPw_view.jsp?error=error");
	}

}
