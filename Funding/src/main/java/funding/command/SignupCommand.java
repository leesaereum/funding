package funding.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.dao.FDaoC;

public class SignupCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id").trim();
		String pw = request.getParameter("pw").trim();
		String name = request.getParameter("name").trim();
		String phone = request.getParameter("phone1")+"-"+request.getParameter("phone2").trim()+
				"-"+request.getParameter("phone3").trim();
		String addrees1 = request.getParameter("address1");
		String addrees2 = request.getParameter("address2");
		String addrees3 = request.getParameter("address3");
		String pw_q = request.getParameter("pw_q");
		String pw_a = request.getParameter("pw_a").trim();
		
		FDaoC dao = new FDaoC();
		dao.signUp(id, pw, name, phone, pw_q, pw_a);
		dao.addAddress(id, addrees1, addrees2, addrees3);
	}

}
