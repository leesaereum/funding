package funding.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyinformationModifyCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pw = request.getParameter("customer_pw");
		//String phone = request.getParameter("phone");
		String phone="01012345678";
		phone = phone.substring(3);
		System.out.println(phone);
	}

}
