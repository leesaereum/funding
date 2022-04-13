package funding.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import funding.dao.FDaoC;

public class SocialLoginCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String input_id = request.getParameter("email");
		HttpSession session = request.getSession();
		FDaoC dao = new FDaoC();
		Boolean res = dao.checkEmail(input_id);
		
		
		
		if(res) {
			request.setAttribute("viewpage", "main.do?sort=all");
			session.setAttribute("email", input_id);
			session.setAttribute("customer_id", input_id);
			session.setAttribute("id", input_id);

		}else {
			request.setAttribute("viewpage", "/pages/SignUp.jsp");
			request.setAttribute("error", "연동된 ID가 없습니다. 회원가입을 먼저 진행해주세요");
		}

		
	}

}
